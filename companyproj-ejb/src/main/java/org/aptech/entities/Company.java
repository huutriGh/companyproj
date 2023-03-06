package org.aptech.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Company")
public class Company implements Serializable {

    @Id
    @Column(name = "CompanyId", columnDefinition = "varchar(10)")
    private String companyId;

    @Column(name = "CompanyName", columnDefinition = "varchar(50)")
    private String companyName;

    @ManyToMany(mappedBy = "companies")
    private Set<Employee> employees;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Company() {
    }
}
