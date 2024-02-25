package co.com.mentalhealth.employee.service;


import co.com.mentalhealth.employee.model.Employee;
import co.com.mentalhealth.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee){
        employee.setCreation_date(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(Long employeeId){
        return employeeRepository.findById(employeeId);
    }

}
