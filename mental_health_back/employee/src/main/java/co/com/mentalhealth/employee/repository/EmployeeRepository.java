package co.com.mentalhealth.employee.repository;

import co.com.mentalhealth.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
