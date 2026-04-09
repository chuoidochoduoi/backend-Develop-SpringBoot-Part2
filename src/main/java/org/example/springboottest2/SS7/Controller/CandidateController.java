package org.example.springboottest2.SS7.Controller;


import jakarta.validation.Valid;

import org.example.springboottest2.SS7.DTO.Reponse.ApiResponse2;
import org.example.springboottest2.SS7.DTO.Request.CandidateCreateDTO;
import org.example.springboottest2.SS7.DTO.Request.CandidateUpdateDTO;
import org.example.springboottest2.SS7.Service.CandidateService;
import org.example.springboottest2.SS7.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    CandidateService candidateService;



    @PostMapping
    public ResponseEntity<ApiResponse2<Void>> createResponseResponseEntity(@Valid @RequestBody CandidateCreateDTO candidateCreateDTO
                                                                          ) {
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.badRequest()
//                    .body(ApiResponse.error(bindingResult.getAllErrors().get(0).getDefaultMessage()));
//        }

        candidateService.createCandidate(candidateCreateDTO);

        return ResponseEntity.status(201)
                .body(ApiResponse2.ok(null));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse2<Candidate>> updateCandidate(
            @PathVariable("id") int id,
            @Valid @ModelAttribute CandidateUpdateDTO dto) {

        Candidate updated = candidateService.updateCandidate(id, dto);

        return ResponseEntity.ok(ApiResponse2.ok(updated));
    }


}
