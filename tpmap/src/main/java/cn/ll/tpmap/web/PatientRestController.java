package cn.ll.tpmap.web;

import cn.ll.tpmap.entities.Patient;
import cn.ll.tpmap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    private List<Patient> patient (){
        return patientRepository.findAll();
    }
}
