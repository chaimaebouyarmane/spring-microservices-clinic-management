package microservices.observabilityPattern.Service.de.Gestion.des.Medecins.Repo;

import microservices.observabilityPattern.Service.de.Gestion.des.Medecins.Models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository @RepositoryRestResource
public interface MedecinRepo extends JpaRepository<Medecin,Long> {
    Medecin findByCin(String cin);
    @Query("SELECT m.fullname FROM Medecin m")
    List<String> findAllFullnames();
    Medecin findByFullname(String fullname);
}
