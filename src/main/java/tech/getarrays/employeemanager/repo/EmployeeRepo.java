package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<employee,Long> {
    Optional<employee>  findEmployeeById(Long id);

    void deleteEmployeeById(Long id);
}
