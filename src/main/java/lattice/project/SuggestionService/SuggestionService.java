package lattice.project.SuggestionService;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lattice.project.exception.LocationNotSupportedException;
import lattice.project.exception.NoDoctorAvailableException;
import lattice.project.model.Doctor;
import lattice.project.model.Patient;
import lattice.project.model.Speciality;
import lattice.project.model.Symptom;
import lattice.project.repository.DoctorRepository;
import lattice.project.repository.PatientRepository;
import lattice.project.repository.PatientRepository;

@Service
public class SuggestionService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public List<Doctor> suggestDoctors(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                            .orElseThrow();

        String patientCity = patient.getCity();
        Symptom symptom = patient.getSymptom();
        Speciality speciality = mapSymptomToSpeciality(symptom);

        if (!Arrays.asList("Delhi", "Noida", "Faridabad").contains(patientCity)) {
            throw new LocationNotSupportedException("We are still waiting to expand to your location");
        }

        List<Doctor> doctors = doctorRepository.findByCityAndSpeciality(patientCity, speciality);
        if (doctors.isEmpty()) {
            throw new NoDoctorAvailableException("There isn't any doctor present at your location for your symptom");
        }

        return doctors;
    }

    private Speciality mapSymptomToSpeciality(Symptom symptom) {
        switch (symptom) {
            case ARTHRITIS:
            case BACK_PAIN:
            case TISSUE_INJURIES:
                return Speciality.ORTHOPEDIC;
            case DYSMENORRHEA:
                return Speciality.GYNECOLOGY;
            case SKIN_INFECTION:
            case SKIN_BURN:
                return Speciality.DERMATOLOGY;
            case EAR_PAIN:
                return Speciality.ENT_SPECIALIST;
            default:
                throw new IllegalArgumentException("Unknown symptom: " + symptom);
        }
    }
}
