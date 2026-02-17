package br.com.med.voll.api.controller;


import br.com.med.voll.api.doctor.DataDoctorRegister;
import br.com.med.voll.api.patient.DataPatientRegister;
import br.com.med.voll.api.patient.Patient;
import br.com.med.voll.api.repository.PatientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @Transactional
    @PostMapping
    public void register(@RequestBody @Valid DataPatientRegister data){
        repository.save(new Patient(data));
    }
}
