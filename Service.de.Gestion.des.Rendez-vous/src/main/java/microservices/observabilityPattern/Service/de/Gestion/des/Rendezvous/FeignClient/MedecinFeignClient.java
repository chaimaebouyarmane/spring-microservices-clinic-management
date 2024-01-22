package microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.FeignClient;

import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.DTOs.MedecinDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "SERVICE.DE.GESTION.DES.MEDECINS",url = "http://localhost:8082")
public interface MedecinFeignClient {
    @GetMapping("/medecin/findByName/{name}")
    MedecinDTO findByName(@PathVariable String name);
}