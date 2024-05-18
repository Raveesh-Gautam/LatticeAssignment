package lattice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lattice.project.model.Patient;
import lattice.project.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
        return ResponseEntity.noContent().build();
    }
}
