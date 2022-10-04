package pro.sky.collections_and_set.service;

import pro.sky.collections_and_set.model.Employee;

import java.util.List;
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> printEmployees();
}