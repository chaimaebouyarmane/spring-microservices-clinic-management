package microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Services;

import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Models.Rendezvous;
import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Repo.RendezvousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezvousService {
    @Autowired
    private RendezvousRepo rendezvousRepo;

    public Rendezvous save(Rendezvous rendezvous) {
        return rendezvousRepo.save(rendezvous);
    }

    public Rendezvous findById(Long id) {
        return rendezvousRepo.findByIdrendezvous(id);
    }

    public List<Rendezvous> findAll() {
        return rendezvousRepo.findAll();
    }

    public Long delete(Long id) {
        Rendezvous rendezvous = rendezvousRepo.findByIdrendezvous(id);
        rendezvousRepo.delete(rendezvous);
        return id;
    }

    public Rendezvous update(Rendezvous rendezvous) {
        Rendezvous existingR = rendezvousRepo.findByIdrendezvous(rendezvous.getIdrendezvous());
        if (existingR != null) {
            existingR.setCause(rendezvous.getCause());
            existingR.setDate(rendezvous.getDate());
            existingR.setMedecin(rendezvous.getMedecin());
            existingR.setPatient(rendezvous.getPatient());
            return rendezvousRepo.save(existingR);
        }else {
            return null;
        }
    }
    public List<Rendezvous> findAllByPatient(String p){
        return rendezvousRepo.findByPatient(p);
    }
}
