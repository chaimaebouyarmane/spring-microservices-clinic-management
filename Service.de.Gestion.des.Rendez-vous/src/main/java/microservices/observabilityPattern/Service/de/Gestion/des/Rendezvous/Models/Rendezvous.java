package microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Rendezvous {
    @Id
    private Long idrendezvous;
    private Date date;
    private String cause;
    private String patient;
    private String medecin;
}
