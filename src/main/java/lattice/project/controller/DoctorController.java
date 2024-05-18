package lattice.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lattice.project.model.Doctor;
import lattice.project.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.addDoctor(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable Long id) {
        doctorService.removeDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
