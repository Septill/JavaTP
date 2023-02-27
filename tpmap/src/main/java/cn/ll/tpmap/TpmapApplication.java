package cn.ll.tpmap;

import cn.ll.tpmap.entities.*;
import cn.ll.tpmap.repositories.ConsultationRepository;
import cn.ll.tpmap.repositories.MedicinRepository;
import cn.ll.tpmap.repositories.PatientRepository;
import cn.ll.tpmap.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class TpmapApplication  {

	public static void main(String[] args) {
		SpringApplication.run(TpmapApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository, MedicinRepository medicinRepository,
							RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository){
		return args -> {
			patientRepository.save(new Patient(null,"Victor",new Date(),false,null));
			Patient patient = new Patient();
			patient.setNom("Cedric");
			patient.setMalade(false);
			patient.setDateNaissance(new Date());
			patientRepository.save(patient);

			Stream.of("Irina","Hadrien","Armond").forEach(name->{
				Patient patient1 = new Patient();
				patient1.setNom(name);
				patient1.setMalade(true);
				patient1.setDateNaissance(new Date());
				patientRepository.save(patient1);
					});

			Stream.of("Rayene","Katarina","Jesoph").forEach(nom->{
				Medicin medicin = new Medicin();
				medicin.setNom(nom);
				medicin.setEmail(nom+"@gmail.com");
				medicin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
				medicinRepository.save(medicin);
			});

			Patient patient2 = patientRepository.findById(1L).orElse(null);
			//为什么此处不可加orElse
			Patient patient3 = patientRepository.findByNom("Irina");

			Medicin medicin = medicinRepository.findByNom("Jesoph");

			RendezVous rendezVous= new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.DONE);
			rendezVous.setMedicin(medicin);
			rendezVous.setPatient(patient2);
			rendezVousRepository.save(rendezVous);

			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation = new Consultation();
//			consultation.setDateConsultation(rendezVous1.getDate());
//			consultation.setRapport("rapport de consultation de " + rendezVous.getPatient());
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("rapport");
			consultationRepository.save(consultation);
		};
	}
}
