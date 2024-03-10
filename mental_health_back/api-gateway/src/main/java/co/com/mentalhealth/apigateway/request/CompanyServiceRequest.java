package co.com.mentalhealth.apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "company-service", path = "/api/company",url = "${company.service.url}",configuration = FeignConfiguration.class)
public interface CompanyServiceRequest {

    @PostMapping
    Object saveCompany(@RequestBody Object requestBody);

    @DeleteMapping("{companyId}")
    void deleteCompany(@PathVariable("companyId") Long companyId);

    @GetMapping
    List<Object> getAllCompanies();

    @GetMapping("{companyId}")
    Object findCompanyById(@PathVariable("companyId") Long companyId);

    @PutMapping("{companyId}")
    Object updateCompany(@PathVariable("companyId") Long companyId, @RequestBody Object requestBody);
}
