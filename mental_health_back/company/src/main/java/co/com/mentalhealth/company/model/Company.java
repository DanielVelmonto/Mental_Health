package co.com.mentalhealth.company.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name="company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nit", length = 150, nullable = false)
    private String nit;

    @Column(name = "company_name", length = 500, nullable = false)
    private String company_name;

    @Column(name = "number_employees", nullable = false)
    private long number_employees;

    @Column(name = "manager", nullable = false, length = 100)
    private String manager;

    @Column(name = "manager_email", nullable = false, length = 100)
    private String manager_email;

    @Column(name = "manager_phone", nullable = false, length = 100)
    private String manager_phone;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creation_date;
}
