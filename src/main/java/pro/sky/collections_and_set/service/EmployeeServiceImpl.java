package pro.sky.collections_and_set.service;

import org.springframework.stereotype.Service;
import pro.sky.collections_and_set.exception.EmployeeAlreadyAddedException;
import pro.sky.collections_and_set.exception.EmployeeNotFoundException;
import pro.sky.collections_and_set.exception.EmployeeStorageIsFullException;
import pro.sky.collections_and_set.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees;
    private final String ERR_EMPL_STORAGE_FULL = "Массив сотрудников переполнен";
    private final String ERR_EMPL_ALREADY_ADDED = "Сотрудник уже имеется в массиве";
    private final String ERR_EMPL_NOT_FOUND = "Сотрудник не найден";
    private final int MAX_EMPL_NUMBER = 10;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() == MAX_EMPL_NUMBER) {
            throw new EmployeeStorageIsFullException(ERR_EMPL_STORAGE_FULL);
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException(ERR_EMPL_ALREADY_ADDED);
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException(ERR_EMPL_NOT_FOUND);
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException(ERR_EMPL_NOT_FOUND);
        }
    }

    @Override
    public List<Employee> printEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
