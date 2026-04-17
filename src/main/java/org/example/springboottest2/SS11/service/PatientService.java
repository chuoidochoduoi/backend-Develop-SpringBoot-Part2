package org.example.springboottest2.SS11.service;

import lombok.extern.slf4j.Slf4j;
import org.example.springboottest2.SS11.model.Patient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PatientService {


    public void addPatient(Patient patient) {

        log.info("Nhận bệnh nhân mới: {}", patient.getName());

        if (patient.getAge() > 120) {
            log.warn("Tuổi bệnh nhân bất thường: {} tuổi", patient.getAge());
        }

        log.info("Đã lưu bệnh nhân: {}", patient.getName());
    }
}
