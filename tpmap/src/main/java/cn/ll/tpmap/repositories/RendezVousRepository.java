package cn.ll.tpmap.repositories;

import cn.ll.tpmap.entities.Patient;
import cn.ll.tpmap.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
}
