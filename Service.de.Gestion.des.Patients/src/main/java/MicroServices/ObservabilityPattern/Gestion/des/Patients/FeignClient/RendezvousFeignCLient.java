package MicroServices.ObservabilityPattern.Gestion.des.Patients.FeignClient;

import MicroServices.ObservabilityPattern.Gestion.des.Patients.DTOs.RendezvousDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(name = "SERVICE.DE.GESTION.DES.RENDEZ-VOUS",url = "http://localhost:8081")
public interface RendezvousFeignCLient {
    @GetMapping("/rendezvous/GetAll")
    List<RendezvousDTO> findAll();
    @GetMapping("/rendezvous/allByPateint/cin")
    List<RendezvousDTO> findAllByPatient(@PathVariable String cin);

}
