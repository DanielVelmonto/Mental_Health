package co.com.mentalhealth.employee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", length = 150, nullable = false)
    private String name;

    @Column(name = "document_type", length = 500, nullable = false)
    private String document_type;

    @Column(name = "number_document", nullable = false)
    private long number_document;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "age", nullable = false, length = 100)
    private String age;

    @Column(name = "gender", nullable = false, length = 100)
    private String gender;

    @Column(name = "company_id", nullable = false, length = 100)
    private Long company_id;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creation_date;
}
