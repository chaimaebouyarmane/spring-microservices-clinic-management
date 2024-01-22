package MicroServices.ObservabilityPattern.Gestion.des.Patients.Repos;

import MicroServices.ObservabilityPattern.Gestion.des.Patients.Models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository @RepositoryRestResource
public interface PatientRepo extends JpaRepository<Patient,Long> {
    Patient findByCin(String cin);

}
