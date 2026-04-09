package org.example.springboottest2.SS7.Repository;

import org.example.springboottest2.SS7.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {



}
