package org.example.springboottest2.SS12.repository;

import org.example.springboottest2.SS12.model.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {


    List<Supply> findByIsDeletedFalse();



    List<Supply> findByNameContainingIgnoreCaseAndIsDeletedFalse(String name);
}