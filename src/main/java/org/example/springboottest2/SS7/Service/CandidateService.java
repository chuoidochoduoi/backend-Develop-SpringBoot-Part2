package org.example.springboottest2.SS7.Service;



import org.example.springboottest2.SS7.DTO.Request.CandidateCreateDTO;
import org.example.springboottest2.SS7.DTO.Request.CandidateUpdateDTO;
import org.example.springboottest2.SS7.Repository.CandidateRepository;
import org.example.springboottest2.SS7.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;



    public void createCandidate(CandidateCreateDTO candidateCreateDTO) {


       Candidate candidate = new Candidate();

       candidate.setAge(candidateCreateDTO.getAge());
       candidate.setEmail(candidateCreateDTO.getEmail());
       candidate.setFullName(candidateCreateDTO.getFullName());
       candidate.setYearsOfExperience(candidateCreateDTO.getYearsOfExperience());
       candidate.setPhone(candidateCreateDTO.getPhone());
       candidateRepository.save(candidate);


    }


    public Candidate updateCandidate(int id, CandidateUpdateDTO dto) {

        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        candidate.setAddress(dto.getAddress());
        candidate.setBio(dto.getBio());

        return candidateRepository.save(candidate);
    }
}
