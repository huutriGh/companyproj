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
    private String employeeName;


    @ManyToMany(fetch = FetchType.EAGER)
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
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    public Set<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }
}
