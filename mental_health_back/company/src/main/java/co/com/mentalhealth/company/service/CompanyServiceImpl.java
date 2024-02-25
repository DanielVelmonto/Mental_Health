package co.com.mentalhealth.company.service;

import co.com.mentalhealth.company.model.Company;
import co.com.mentalhealth.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company saveCompany(Company company){
        company.setCreation_date(LocalDateTime.now());
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long companyId){
        companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findCompanyById(Long companyId){
        return companyRepository.findById(companyId);
    }

}
