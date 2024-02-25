package co.com.mentalhealth.company.service;

import co.com.mentalhealth.company.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company saveCompany(Company company);

    void deleteCompany(Long companyId);

    List<Company> findAllCompanies();

    Optional<Company> findCompanyById(Long companyId);
}


