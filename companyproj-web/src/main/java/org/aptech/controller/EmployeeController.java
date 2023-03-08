package org.aptech.controller;

import org.aptech.entities.Company;
import org.aptech.entities.Course;
import org.aptech.entities.Employee;
import org.aptech.services.EmployeeService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {

    @EJB
    EmployeeService<Employee> employeeService;
    @EJB
    EmployeeService<Company> companyService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ?
                "ADD" : request.getParameter("action");
        if (action.equalsIgnoreCase("ADD")) {
            request.getServletContext().getRequestDispatcher("/WEB-INF/Insert.jsp").forward(request, response);
        } else if (action.equalsIgnoreCase("SEARCH")) {
            request.getServletContext().getRequestDispatcher("/WEB-INF/Search.jsp").forward(request, response);
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ?
                "ADD" : request.getParameter("action");
        if (action.equalsIgnoreCase("ADD")) {
            addEmployee(request, response);
        } else if (action.equalsIgnoreCase("SEARCH")) {

            employeeService.setType(Employee.class);
            String employId = request.getParameter("empId");
            Employee employee = employeeService.getEntityById(employId);
            request.setAttribute("employee", employee);
            request.getServletContext().getRequestDispatcher("/WEB-INF/Result.jsp").forward(request, response);

        }


    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String empId = request.getParameter("empId");
        String empName = request.getParameter("empName");
        String compId = request.getParameter("comId");
        String comIdNew = request.getParameter("comIdNew");
        String compName = request.getParameter("compName");
        String courseId = request.getParameter("courseId");

        Company newCompany = new Company();
        newCompany.setCompanyId(comIdNew);
        newCompany.setCompanyName(compName);

        companyService.addEntity(newCompany);

        Company company = new Company();
        company.setCompanyId(compId);

        Set<Company> companies = new HashSet<>();
        companies.add(company);
        companies.add(newCompany);
        Employee employee = new Employee();

        Course course = new Course();
        course.setCourseId(courseId);
        course.setEmployee(employee);

        Set<Course> courses = new HashSet<>();
        courses.add(course);

        employee.setEmployeeId(empId);
        employee.setEmployeeName(empName);
        employee.setCompanies(companies);
        employee.setCourses(courses);


        if (employeeService.addEntity(employee)) {
            response.getWriter().write("Insert employee Success");
        } else {
            response.getWriter().write("Insert employee Fail.");
        }
    }
}
