package co.com.mentalhealth.employee.service;

import co.com.mentalhealth.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

    List<Employee> findAllEmployees();

    Optional<Employee> findEmployeeById(Long employeeId);
}


