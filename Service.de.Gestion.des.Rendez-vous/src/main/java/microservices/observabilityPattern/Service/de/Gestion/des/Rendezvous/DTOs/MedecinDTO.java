package microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MedecinDTO {
    private Long id;
    private String cin;
    private String fullname;
    private String mobile;
    private String gender;
    private String specialite;

}

