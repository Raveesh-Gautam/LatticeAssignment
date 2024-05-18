package lattice.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lattice.project.model.Patient;
import lattice.project.repository.PatientRepository;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
