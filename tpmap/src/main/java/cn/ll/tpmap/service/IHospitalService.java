package cn.ll.tpmap.service;

import cn.ll.tpmap.entities.Consultation;
import cn.ll.tpmap.entities.Medicin;
import cn.ll.tpmap.entities.Patient;
import cn.ll.tpmap.entities.RendezVous;

public interface IHospitalService implements {
    Patient savePatient(Patient patient);
    Medicin saveMedicin(Medicin medicin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
