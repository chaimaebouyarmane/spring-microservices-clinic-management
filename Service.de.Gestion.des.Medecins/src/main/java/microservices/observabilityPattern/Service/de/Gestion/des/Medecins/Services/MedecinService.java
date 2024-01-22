package microservices.observabilityPattern.Service.de.Gestion.des.Medecins.Services;

import microservices.observabilityPattern.Service.de.Gestion.des.Medecins.Models.Medecin;
import microservices.observabilityPattern.Service.de.Gestion.des.Medecins.Repo.MedecinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedecinService {
    @Autowired
    private MedecinRepo medecinRepo;

    public Medecin save(Medecin medecin){
        return medecinRepo.save(medecin);
    }
    public Medecin findByCin(String cin){
        return medecinRepo.findByCin(cin);
    }
    public List<Medecin> findAll(){
        return medecinRepo.findAll();
    }
    public String delete(String cin){
        Medecin medecin=medecinRepo.findByCin(cin);
        medecinRepo.delete(medecin);
        return cin;
    }
    public Medecin update(Medecin medecin){
        Medecin existingM = medecinRepo.findByCin(medecin.getCin());
        if (existingM != null) {
            existingM.setCin(medecin.getCin());
            existingM.setFullname(medecin.getFullname());
            existingM.setGender(medecin.getGender());
            existingM.setMobile(medecin.getMobile());
            existingM.setSpecialite(medecin.getSpecialite());
            return medecinRepo.save(existingM);
        }else {
            return null;
        }
    }
    public List<String> findAllFullname(){
        return medecinRepo.findAllFullnames();
    }
    public Medecin findByFullname(String name){
        return medecinRepo.findByFullname(name);
    }
}
