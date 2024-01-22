package microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Repo;

import microservices.observabilityPattern.Service.de.Gestion.des.Rendezvous.Models.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository @RepositoryRestResource
public interface RendezvousRepo extends JpaRepository<Rendezvous,Long> {
    Rendezvous findByIdrendezvous(Long id);

    List<Rendezvous> findByPatient(String patient);
}
