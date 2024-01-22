package microservices.observabilityPattern.Service.de.Gestion.des.Medecins.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor @NoArgsConstructor //@Table(name = "Medein")
public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cin ;
    private String fullname;
    private String mobile;
    private String gender ;
    private String specialite;
}
