package cn.ll.tpmap.repositories;

import cn.ll.tpmap.entities.Medicin;
import cn.ll.tpmap.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicinRepository extends JpaRepository<Medicin, Long> {
    Medicin findByNom(String nom);
}
