package org.example.springboottest2.SS12.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springboottest2.SS12.Exception.BadRequestException;
import org.example.springboottest2.SS12.Exception.NotFoundException;
import org.example.springboottest2.SS12.dto.Request.SupplyRequest;
import org.example.springboottest2.SS12.dto.Response.DailyExportResponse;
import org.example.springboottest2.SS12.dto.Response.TopExportResponse;
import org.example.springboottest2.SS12.model.Supply;
import org.example.springboottest2.SS12.model.Transaction;
import org.example.springboottest2.SS12.repository.SupplyRepository;
import org.example.springboottest2.SS12.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class SupplyService {

    @Autowired
    private final SupplyRepository supplyRepo;

    @Autowired
    private final TransactionRepository transactionRepo;


    public Supply create(SupplyRequest req) {
        if (req.getName() == null || req.getName().isBlank()) {
            throw new BadRequestException("Tên không được trống");
        }

        Supply s = new Supply();
        s.setName(req.getName());

        s.setSpecification(req.getSpecification());
        s.setProvider(req.getProvider());
        s.setUnit(req.getUnit());
        s.setQuantity(0);

        supplyRepo.save(s);

        log.info("Đã tạo mới vật tư: {} với ID: {}", s.getName(), s.getId());

        return s;
    }

    public Supply update(Long id, Map<String, Object> body) {

        if (body.containsKey("id") || body.containsKey("quantity")) {
            log.warn("Client gửi field cấm: {}", body);

            throw new BadRequestException("Không được update id hoặc quantity");
        }

        Supply s = supplyRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tồn tại"));

        s.setName((String) body.get("name"));
        s.setSpecification((String) body.get("specification"));


        s.setProvider((String) body.get("provider"));


        return supplyRepo.save(s);
    }

    public void delete(Long id) {
        Supply s = supplyRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tồn tại"));

        if (s.isDeleted()) {


            throw new NotFoundException("Đã bị xóa");
        }

        s.setDeleted(true);
        supplyRepo.save(s);
    }

    public List<Supply> getAll() {
        List<Supply> list = supplyRepo.findByIsDeletedFalse();


        log.debug("Số bản ghi: {}", list.size());


        return list;
    }

    public List<Supply> search(String name) {
        List<Supply> list =
                supplyRepo.findByNameContainingIgnoreCaseAndIsDeletedFalse(name);

        if (list.isEmpty()) {
            log.info("Không tìm thấy: {}", name);


        }

        return list;
    }

    public void export(Long id, Integer amount) {

        Supply s = supplyRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tồn tại"));

        if (s.getQuantity() < amount) {



            log.error("Xuất thất bại ID {}: yêu cầu {}, tồn {}",
                    id, amount, s.getQuantity());

            throw new BadRequestException("Không đủ hàng");
        }

        s.setQuantity(s.getQuantity() - amount);
        supplyRepo.save(s);

        Transaction t = new Transaction();
        t.setSupply(s);
        t.setType("EXPORT");
        t.setAmount(amount);

        t.setCreatedAt(LocalDateTime.now());

        transactionRepo.save(t);
    }

    public void importStock(Long id, Integer amount) {

        Supply s = supplyRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tồn tại"));

        int old = s.getQuantity();

        s.setQuantity(old + amount);
        supplyRepo.save(s);

        Transaction t = new Transaction();
        t.setSupply(s);

        t.setType("IMPORT");


        t.setAmount(amount);
        t.setCreatedAt(LocalDateTime.now());

        transactionRepo.save(t);

        log.info("Nhập kho ID {}, +{}, tồn cũ {}", id, amount, old);
    }

    public List<DailyExportResponse> dailyExport() {

        log.info("Start thống kê");

        LocalDate today = LocalDate.now();

        List<DailyExportResponse> result =
                transactionRepo.getDailyExport(

                        today.atStartOfDay(),
                        today.plusDays(1).atStartOfDay()
                );

        log.info("Done thống kê");

        return result;
    }

    public TopExportResponse topExport() {

        Page<TopExportResponse> page =
                transactionRepo.getTopExport(PageRequest.of(0,1));


        if (page.isEmpty()) {
            throw new NotFoundException("Chưa có dữ liệu");
        }


        return page.getContent().get(0);
    }
}