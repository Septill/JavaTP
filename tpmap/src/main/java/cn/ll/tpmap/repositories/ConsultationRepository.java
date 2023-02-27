package cn.ll.tpmap.repositories;

import cn.ll.tpmap.entities.Consultation;
import cn.ll.tpmap.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
