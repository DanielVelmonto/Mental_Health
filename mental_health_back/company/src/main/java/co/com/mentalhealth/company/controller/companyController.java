package co.com.mentalhealth.company.controller;

import co.com.mentalhealth.company.model.Company;
import co.com.mentalhealth.company.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/company")
public class companyController {

    public static final Logger logger = LoggerFactory.getLogger(companyController.class);

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<?> saveCompany(@RequestBody Company company){
        logger.info("Inicia la creacion de una compañia");
        company.setStatus(1);
        return new ResponseEntity<>(companyService.saveCompany(company), HttpStatus.CREATED);
    }

    @PutMapping("{companyId}")
    public ResponseEntity<?> updateCompany(@PathVariable Long companyId, @RequestBody Company detailCompany){
        Company company = companyService.findCompanyById(companyId).orElseThrow(() -> new ResourceNotFoundException("No se encontro la compañia con id: "+companyId));
        company.setCompany_name(detailCompany.getCompany_name());
        company.setManager(detailCompany.getManager());
        company.setManager_phone(detailCompany.getManager_phone());
        company.setNit(detailCompany.getNit());
        company.setNumber_employees(detailCompany.getNumber_employees());
        company.setManager_email(detailCompany.getManager_email());
        company.setStatus(1);
        Company companyUpdated = companyService.saveCompany(company);
        return ResponseEntity.ok(companyUpdated);
    }

    @DeleteMapping("{companyId}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long companyId){
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("{companyId}")
    public ResponseEntity<?> findCompanyById(@PathVariable Long companyId){
        Company company = companyService.findCompanyById(companyId).orElseThrow(() -> new ResourceNotFoundException("No se encontro la compañia con id: "+companyId));
        return ResponseEntity.ok(company);
    }


    @GetMapping
    public ResponseEntity<?> getAllCompanies(){
        return ResponseEntity.ok(companyService.findAllCompanies());
    }
}
