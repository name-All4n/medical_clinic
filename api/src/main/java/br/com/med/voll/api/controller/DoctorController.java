package br.com.med.voll.api.controller;


import br.com.med.voll.api.doctor.DataDoctorRegister;
import br.com.med.voll.api.doctor.Doctor;
import br.com.med.voll.api.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @Transactional
    @PostMapping
    public void register(@RequestBody @Valid DataDoctorRegister data){
        repository.save(new Doctor(data));
    }
}
