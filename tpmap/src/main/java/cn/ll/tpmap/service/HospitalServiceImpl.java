package cn.ll.tpmap.service;

import cn.ll.tpmap.entities.Consultation;
import cn.ll.tpmap.entities.Medicin;
import cn.ll.tpmap.entities.Patient;
import cn.ll.tpmap.entities.RendezVous;
import cn.ll.tpmap.repositories.ConsultationRepository;
import cn.ll.tpmap.repositories.MedicinRepository;
import cn.ll.tpmap.repositories.PatientRepository;
import cn.ll.tpmap.repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    //@Autowired
    private PatientRepository patientRepository;
    private MedicinRepository medicinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;



    // soit faut qu'on ajoute @Autowired pour chaque repository
    public HospitalServiceImpl(PatientRepository patientRepository, MedicinRepository medicinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medicinRepository = medicinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        //return null;
        return patientRepository.save(patient);
    }

    @Override
    public Medicin saveMedicin(Medicin medicin) {
                //return null;
        return medicinRepository.save(medicin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
                //return null;
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
                //return null;
        return consultationRepository.save(consultation);
    }
}
