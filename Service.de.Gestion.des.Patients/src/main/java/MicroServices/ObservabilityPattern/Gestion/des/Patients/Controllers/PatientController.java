package MicroServices.ObservabilityPattern.Gestion.des.Patients.Controllers;

import MicroServices.ObservabilityPattern.Gestion.des.Patients.DTOs.PatientDTO;
import MicroServices.ObservabilityPattern.Gestion.des.Patients.DTOs.RendezvousDTO;
import MicroServices.ObservabilityPattern.Gestion.des.Patients.FeignClient.RendezvousFeignCLient;
import MicroServices.ObservabilityPattern.Gestion.des.Patients.Models.Patient;
import MicroServices.ObservabilityPattern.Gestion.des.Patients.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private RendezvousFeignCLient rendezvousFeignCLient;

    @GetMapping("/getAll") @ResponseStatus(HttpStatus.OK)
    public List<Patient> findAll(){
        return patientService.findAll();
    }
    /*@GetMapping("/byCIN/{cin}") @ResponseStatus(HttpStatus.OK)
    public PatientDTO getByCin(@PathVariable String cin){
        Patient patient=patientService.findByCin(cin);
        PatientDTO patientDTO=new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setCin(patient.getCin());
        patientDTO.setMobile(patient.getMobile());
        patientDTO.setGender(patient.getGender());
        patientDTO.setAge(patient.getAge());
        patientDTO.setFullname(patient.getFullname());
        List<RendezvousDTO> rendezvousDTO=rendezvousFeignCLient.findAllByPatient(patient.getCin());
        patientDTO.setRendezvousDTOList(rendezvousDTO);
        return patientDTO;
    }*/
    @GetMapping("/byCIN/{cin}") @ResponseStatus(HttpStatus.OK)
    public Patient getByCin(@PathVariable String cin) {
        return patientService.findByCin(cin);
    }
    /*@PostMapping("/add") @ResponseStatus(HttpStatus.CREATED)
    public Patient save(@RequestBody Patient patient){
        return patientService.save(patient);
    }*/
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient save(@RequestBody Patient patient) {
        try {
            Patient existingPatient = patientService.findByCin(patient.getCin());

            if (existingPatient == null) {
                return patientService.save(patient);
            } else {
                System.out.println("Le patient existe déjà.");
                return existingPatient;
            }
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'enregistrement du patient. Cause : " + e.getMessage(), e);
        }
    }

    @DeleteMapping("/delete/{CIN}") @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable String CIN){
        return patientService.delete(CIN);
    }
    @PutMapping("/update") @ResponseStatus(HttpStatus.OK)
    public Patient update(@RequestBody Patient patient){
        return  patientService.update(patient);
    }

}
