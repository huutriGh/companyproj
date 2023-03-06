package org.aptech.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
    @Column(name = "EmployeeId", columnDefinition = "varchar(10)")
    private  String employeeId;

    @Column(name = "EmployeeName")
    private String EmployeeName;


    @ManyToMany
    @JoinTable(
            name = "Employee_Company",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name ="company_id")
    )
    private Set<Company> companies;

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }


    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
