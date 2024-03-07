package co.com.mentalhealth.apigateway.controller;

import co.com.mentalhealth.apigateway.request.CompanyServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gateway/company")
public class CompanyController {

    @Autowired
    private CompanyServiceRequest companyServiceRequest;

    @PostMapping
    public ResponseEntity<?> saveCompany(@RequestBody Object company){
        return new ResponseEntity<>(companyServiceRequest.saveCompany(company), HttpStatus.CREATED);
    }

    @DeleteMapping("{companyId}")
    public ResponseEntity<?> deleteCompany(@PathVariable("companyId") Long companyId){
        companyServiceRequest.deleteCompany(companyId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllComapnies(){
        return ResponseEntity.ok(companyServiceRequest.getAllCompanies());
    }
}
