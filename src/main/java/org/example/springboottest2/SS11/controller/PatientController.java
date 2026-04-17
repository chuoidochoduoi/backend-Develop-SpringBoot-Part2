package org.example.springboottest2.SS11.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springboottest2.SS11.model.Patient;
import org.example.springboottest2.SS11.service.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@Slf4j
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
        return "Thêm bệnh nhân thành công!";
    }
}