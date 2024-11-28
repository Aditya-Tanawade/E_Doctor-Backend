package E_Doctor.internship_Project.Repository;


import E_Doctor.internship_Project.Entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    AvailableDate findByDoctorEmail(String doctorEmail);
}

