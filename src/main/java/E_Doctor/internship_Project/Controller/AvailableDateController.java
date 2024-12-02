package E_Doctor.internship_Project.Controller;

import E_Doctor.internship_Project.Entity.AvailableDate;
import E_Doctor.internship_Project.Service.AvailableDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class AvailableDateController {

    @Autowired
    private AvailableDateService availableDateService;

    // Get availability by doctor
    @GetMapping("/availability")
    public ResponseEntity<AvailableDate> getAvailabilityByDoctor() {
        AvailableDate availableDate = availableDateService.getAvailabilityByDoctor();
        if (availableDate != null) {
            return ResponseEntity.ok(availableDate);  // HTTP 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // HTTP 404 Not Found if no availability
        }
    }

    // Update availability
    @PutMapping("/availability")
    public ResponseEntity<AvailableDate> updateAvailability(@RequestBody AvailableDate availableDate) {
        try {
            AvailableDate updatedAvailability = availableDateService.updateAvailability(availableDate);
            return ResponseEntity.ok(updatedAvailability);  // HTTP 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  // HTTP 400 Bad Request in case of errors
        }
    }
}
