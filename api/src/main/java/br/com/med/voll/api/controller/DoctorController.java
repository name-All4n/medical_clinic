package br.com.med.voll.api.controller;


import br.com.med.voll.api.doctor.DataDoctorRegister;
import br.com.med.voll.api.doctor.DataListingDoctors;
import br.com.med.voll.api.doctor.DataUpdateDoctors;
import br.com.med.voll.api.doctor.Doctor;
import br.com.med.voll.api.patient.DataPatientRegister;
import br.com.med.voll.api.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Page<DataListingDoctors> list(@PageableDefault(size=10, sort={"name"}) Pageable pagination) {
        return repository.findAllByActiveTrue(pagination).map(DataListingDoctors::new);

    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateDoctors data) {
        var doctor = repository.getReferenceById(data.id());
        doctor.uptadeInformations(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        var doctor = repository.getReferenceById(id);
        doctor.delete();
    }
}
