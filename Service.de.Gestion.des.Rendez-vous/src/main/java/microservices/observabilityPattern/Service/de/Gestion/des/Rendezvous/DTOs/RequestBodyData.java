package microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Models.Rendezvous;

@Data @AllArgsConstructor @NoArgsConstructor
public class RequestBodyData {
    private PatientDTO patient;
    private Rendezvous rendezvous;
    private MedecinDTO medecin;

}
