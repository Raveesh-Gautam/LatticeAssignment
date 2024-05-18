package lattice.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import lattice.project.model.Doctor;
import lattice.project.model.Speciality;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByCityAndSpeciality(String city, Speciality speciality);
}
