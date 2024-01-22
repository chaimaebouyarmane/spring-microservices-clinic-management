package microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Controllers;

import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.DTOs.MedecinDTO;
import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.DTOs.PatientDTO;
import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.DTOs.RendezvousDTO;
import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.DTOs.RequestBodyData;
import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.FeignClient.MedecinFeignClient;
import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.FeignClient.PatientFeignClient;
import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Models.Rendezvous;
import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Services.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("rendezvous")
public class RendezvousController {
    @Autowired
    private RendezvousService rendezvousService;
    @Autowired
    private MedecinFeignClient medecinFeignClient;
    @Autowired
    private PatientFeignClient patientFeignClient;

    @PostMapping("/add")
    public Rendezvous save(@RequestBody RequestBodyData data) {
        try {
            PatientDTO patientDTO = data.getPatient();
            Rendezvous rendezvousDTO = data.getRendezvous();
            MedecinDTO medecinName = data.getMedecin();

            PatientDTO savedPatient = patientFeignClient.save(patientDTO);

            if (savedPatient == null) {
                throw new Exception("Erreur lors de l'enregistrement du patient");
            }

            MedecinDTO medecinDetails = medecinFeignClient.findByName(medecinName.getFullname());

            if (medecinDetails == null) {
                throw new Exception("Médecin introuvable");
            }

            rendezvousDTO.setPatient(savedPatient.getCin());
            rendezvousDTO.setMedecin(medecinDetails.getFullname());

            return rendezvousService.save(rendezvousDTO);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création du rendez-vous. Cause : " + e.getMessage(), e);
        }
    }


    @GetMapping("/GetAll") @ResponseStatus(HttpStatus.OK)
    public List<Rendezvous> findAll(){
        return rendezvousService.findAll();
    }
    @GetMapping("/findById/{id}") @ResponseStatus(HttpStatus.OK)
    public RendezvousDTO findById(@PathVariable Long id){
        Rendezvous rendezvous=rendezvousService.findById(id);
        PatientDTO patientDTO=patientFeignClient.getByCin(rendezvous.getPatient());
        RendezvousDTO rendezvousDTO=new RendezvousDTO();
        rendezvousDTO.setPatient(patientDTO);
        rendezvousDTO.setIdrendezvous(rendezvous.getIdrendezvous());
        rendezvousDTO.setDate(rendezvous.getDate());
        rendezvousDTO.setCause(rendezvous.getCause());
        rendezvousDTO.setMedecin(rendezvous.getMedecin());
        return  rendezvousDTO;

    }
    @DeleteMapping("/delete/{id}") @ResponseStatus(HttpStatus.OK)
    public Long delete(@PathVariable Long id){
        return rendezvousService.delete(id);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Rendezvous update(@RequestBody RequestBodyData data) {
        try {
            PatientDTO patientDTO = data.getPatient();
            Rendezvous rendezvousDTO = data.getRendezvous();
            MedecinDTO medecinDTO=data.getMedecin();
            PatientDTO updatedPatient=patientFeignClient.update(patientDTO);
            rendezvousDTO.setPatient(updatedPatient.getCin());
            rendezvousDTO.setMedecin(medecinDTO.getFullname());
            return rendezvousService.update(rendezvousDTO);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la mise à jour du rendez-vous. Cause : " + e.getMessage(), e);
        }
    }
    @GetMapping("/allByPatient/{cin}") @ResponseStatus(HttpStatus.OK)
    public List<Rendezvous> findAllByPatient(@PathVariable String cin){
        return rendezvousService.findAllByPatient(cin);
    }

}
