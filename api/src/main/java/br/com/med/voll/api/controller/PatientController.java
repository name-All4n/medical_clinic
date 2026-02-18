package br.com.med.voll.api.controller;


import br.com.med.voll.api.doctor.DataDoctorRegister;
import br.com.med.voll.api.patient.DataListiningPatient;
import br.com.med.voll.api.patient.DataPatientRegister;
import br.com.med.voll.api.patient.Patient;
import br.com.med.voll.api.repository.PatientRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<DataListiningPatient> list(@PageableDefault (page = 0, size = 10,
            sort = {"nome"}) Pageable pagination){
        return repository.findAll(pagination).map(DataListiningPatient::new);
    }
}
