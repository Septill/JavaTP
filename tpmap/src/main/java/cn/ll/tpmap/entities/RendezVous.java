package cn.ll.tpmap.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class RendezVous {
   // @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long id;
    @Id
    private String Id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    private Medicin medicin;
    @OneToOne(mappedBy = "rendezVous", fetch = FetchType.LAZY)
    private Consultation consultation;
}
