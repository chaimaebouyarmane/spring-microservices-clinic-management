package MicroServices.ObservabilityPattern.Gestion.des.Patients.Services;

import MicroServices.ObservabilityPattern.Gestion.des.Patients.Models.Patient;
import MicroServices.ObservabilityPattern.Gestion.des.Patients.Repos.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;


    public Patient save(Patient patient) {
        return patientRepo.save(patient);
    }

    public Patient findByCin(String cin) {
        return patientRepo.findByCin(cin);
    }

    public List<Patient> findAll() {
        return patientRepo.findAll();
    }

    public String delete(String cin) {
        Patient patient = patientRepo.findByCin(cin);
        patientRepo.delete(patient);
        return cin;
    }

    public Patient update(Patient updatedPatientInfo) {

        Patient existingPatient = patientRepo.findByCin(updatedPatientInfo.getCin());
        if (existingPatient != null) {
            existingPatient.setCin(updatedPatientInfo.getCin());
            existingPatient.setFullname(updatedPatientInfo.getFullname());
            existingPatient.setMobile(updatedPatientInfo.getMobile());
            existingPatient.setAge(updatedPatientInfo.getAge());
            existingPatient.setGender(updatedPatientInfo.getGender());

            return patientRepo.save(existingPatient);
        }else {
            return null;
        }
    }

}
