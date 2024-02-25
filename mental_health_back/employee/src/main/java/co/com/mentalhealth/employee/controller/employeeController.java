package co.com.mentalhealth.employee.controller;

import co.com.mentalhealth.employee.model.Employee;
import co.com.mentalhealth.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class employeeController {

    public static final Logger logger = LoggerFactory.getLogger(employeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
        logger.info("Inicia la creacion de una compañia");
        employee.setStatus(1);
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee detailEmployee){
        Employee employee = employeeService.findEmployeeById(employeeId).orElseThrow(() -> new ResourceNotFoundException("No se encontro la compañia con id: "+employeeId));
        employee.setAge(detailEmployee.getAge());
        employee.setGender(detailEmployee.getGender());
        employee.setEmail(detailEmployee.getEmail());
        employee.setCompany_id(detailEmployee.getCompany_id());
        employee.setName(detailEmployee.getName());
        employee.setDocument_type(detailEmployee.getDocument_type());
        employee.setNumber_document(detailEmployee.getNumber_document());
        employee.setStatus(1);
        Employee employeeUpdated = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(employeeUpdated);
    }

    @DeleteMapping("{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<?> findEmployeeById(@PathVariable Long employeeId){
        Employee employee = employeeService.findEmployeeById(employeeId).orElseThrow(() -> new ResourceNotFoundException("No se encontro la compañia con id: "+employeeId));
        return ResponseEntity.ok(employee);
    }


    @GetMapping
    public ResponseEntity<?> getAllCompanies(){
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }
}
