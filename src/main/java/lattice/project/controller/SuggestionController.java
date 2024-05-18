package lattice.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lattice.project.SuggestionService.SuggestionService;
import lattice.project.exception.LocationNotSupportedException;
import lattice.project.exception.NoDoctorAvailableException;
import lattice.project.model.Doctor;

@RestController
@RequestMapping("/suggestions")
public class SuggestionController {
    @Autowired
    private SuggestionService suggestionService;

    @GetMapping("/{patientId}")
    public ResponseEntity<?> suggestDoctors(@PathVariable Long patientId) {
        try {
            List<Doctor> doctors = suggestionService.suggestDoctors(patientId);
            return ResponseEntity.ok(doctors);
        } catch (LocationNotSupportedException | NoDoctorAvailableException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
