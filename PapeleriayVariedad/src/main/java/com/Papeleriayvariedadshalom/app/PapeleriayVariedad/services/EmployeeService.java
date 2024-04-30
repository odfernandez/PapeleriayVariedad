package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();
    Employee findEmployeeById(String id) throws ModelNotFoundException;
    Employee saveEmployee(Employee employee) throws ModelNotFoundException;
    Employee updateEmployee(String id, Employee employee) throws ModelNotFoundException;
    void deleteEmployee(String id) throws ModelNotFoundException;
}
