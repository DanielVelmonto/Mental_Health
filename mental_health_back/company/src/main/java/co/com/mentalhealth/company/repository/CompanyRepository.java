package co.com.mentalhealth.company.repository;


import co.com.mentalhealth.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
