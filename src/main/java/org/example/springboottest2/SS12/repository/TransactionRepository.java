package org.example.springboottest2.SS12.repository;

import org.example.springboottest2.SS12.dto.Response.DailyExportResponse;
import org.example.springboottest2.SS12.dto.Response.TopExportResponse;
import org.example.springboottest2.SS12.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("""
        SELECT new org.example.springboottest2.SS12.dto.Response.DailyExportResponse(
            s.id, s.name, SUM(t.amount)
        )
        FROM Transaction t
        JOIN t.supply s
        WHERE t.type = 'EXPORT'
        AND t.createdAt >= :start
        AND t.createdAt < :end
        GROUP BY s.id, s.name
    """)
    List<DailyExportResponse> getDailyExport(LocalDateTime start, LocalDateTime end);


    @Query("""
        SELECT new org.example.springboottest2.SS12.dto.Response.TopExportResponse(
            s.name, SUM(t.amount)
        )
        FROM Transaction t
        JOIN t.supply s
        WHERE t.type = 'EXPORT'
        GROUP BY s.id, s.name
        ORDER BY SUM(t.amount) DESC
    """)
    Page<TopExportResponse> getTopExport(Pageable pageable);
}
