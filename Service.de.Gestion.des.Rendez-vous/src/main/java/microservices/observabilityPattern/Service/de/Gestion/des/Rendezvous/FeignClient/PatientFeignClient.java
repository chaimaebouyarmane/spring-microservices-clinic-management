package microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.FeignClient;

import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.DTOs.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "GESTION.DES.PATIENTS",url = "http://localhost:8080")
public interface PatientFeignClient {
    @PostMapping("/patient/add")
    PatientDTO save(@RequestBody PatientDTO patient);
    @GetMapping("/patient/byCIN/{cin}")
    PatientDTO getByCin(@PathVariable String cin);
    @PutMapping("/patient/update")
    PatientDTO update(@RequestBody PatientDTO patient);
}
