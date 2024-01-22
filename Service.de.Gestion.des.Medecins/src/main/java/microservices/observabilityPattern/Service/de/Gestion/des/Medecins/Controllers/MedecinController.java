package microservices.observabilityPattern.Service.de.Gestion.des.Medecins.Controllers;

import microservices.observabilityPattern.Service.de.Gestion.des.Medecins.Models.Medecin;
import microservices.observabilityPattern.Service.de.Gestion.des.Medecins.Services.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController @RequestMapping("medecin")
public class MedecinController {
    @Autowired
    private MedecinService medecinService;

    @PostMapping("/add") @ResponseStatus(HttpStatus.CREATED)
    public Medecin save(@RequestBody Medecin medecin){
        return medecinService.save(medecin);
    }
    @GetMapping("/getAll") @ResponseStatus(HttpStatus.OK)
    public List<Medecin> findAll(){
        return medecinService.findAll();
    }
    @GetMapping("/getByCin/{cin}") @ResponseStatus(HttpStatus.OK)
    public Medecin findByCin(@PathVariable String cin){
        return medecinService.findByCin(cin);
    }
    @GetMapping("/findAllByName") @ResponseStatus(HttpStatus.OK)
    public List<String> findAllByName(){
        return medecinService.findAllFullname();
    }
    @GetMapping("/findByName/{name}") @ResponseStatus(HttpStatus.OK)
    public Medecin findByName(@PathVariable String name){
        return medecinService.findByFullname(name);
    }
    @DeleteMapping("/delete/{cin}") @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable String cin){
        return medecinService.delete(cin);
    }
    @PutMapping("/update") @ResponseStatus(HttpStatus.OK)
    public Medecin update(@RequestBody Medecin medecin){
        return medecinService.update(medecin);
    }
}
