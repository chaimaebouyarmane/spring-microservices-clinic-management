package microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.DTOs;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RendezvousDTO {

    private Long idrendezvous;
    private Date date;
    private String cause;
    private PatientDTO patient;
    private String medecin;
}