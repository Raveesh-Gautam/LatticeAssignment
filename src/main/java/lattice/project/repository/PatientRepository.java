package lattice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lattice.project.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
}
