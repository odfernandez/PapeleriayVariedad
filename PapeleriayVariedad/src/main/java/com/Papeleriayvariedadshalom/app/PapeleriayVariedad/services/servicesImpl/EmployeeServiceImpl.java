package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.servicesImpl;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Customer;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Employee;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Rol;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories.EmployeeRepository;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.EmployeeService;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RolService rolService;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(String id) throws ModelNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()){
            throw new ModelNotFoundException("Employee is not available");
        }
        return employee.get();
    }

    @Override
    public Employee saveEmployee(Employee employee) throws ModelNotFoundException {
        Optional<Rol> rol = rolService.findRolByDescriptionIgnoreCase(employee.getRol().getDescription());
        Employee employeeDb = Employee.builder()
                .idEmployee(employee.getIdEmployee())
                .firstName(employee.getFirstName())
                .secondName(employee.getSecondName())
                .firstLastName(employee.getFirstLastName())
                .secondLastName(employee.getSecondLastName())
                .address(employee.getAddress())
                .phone(employee.getPhone())
                .email(employee.getEmail())
                .state(employee.isState())
                .rol(rol.get())
                .build();
        return employeeRepository.save(employeeDb);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) throws ModelNotFoundException {
        Employee employeeDb = findEmployeeById(id);
        Optional<Rol> rol = rolService.findRolByDescriptionIgnoreCase(employee.getRol().getDescription());
        if (Objects.nonNull(employee.getIdEmployee())&& !"".equalsIgnoreCase(employee.getIdEmployee())){
            employeeDb.setIdEmployee(employee.getIdEmployee());
        }
        if (Objects.nonNull(employee.getFirstName())&& !"".equalsIgnoreCase(employee.getFirstName())){
            employeeDb.setFirstName(employee.getFirstName());
        }
        employeeDb.setSecondName(employee.getSecondName());
        if (Objects.nonNull(employee.getFirstLastName())&& !"".equalsIgnoreCase(employee.getFirstLastName())){
            employeeDb.setFirstLastName(employee.getFirstLastName());
        }
        employeeDb.setSecondLastName(employee.getSecondLastName());
        if (Objects.nonNull(employee.getAddress())&& !"".equalsIgnoreCase(employee.getAddress())){
            employeeDb.setAddress(employee.getAddress());
        }
        if (Objects.nonNull(employee.getPhone())&& !"".equalsIgnoreCase(employee.getPhone())){
            employeeDb.setPhone(employee.getPhone());
        }
        if (Objects.nonNull(employee.getEmail())&& !"".equalsIgnoreCase(employee.getEmail())){
            employeeDb.setEmail(employee.getEmail());
        }
        employeeDb.setState(employee.isState());
        if (Objects.nonNull(rol.get().getDescription())&& !"".equalsIgnoreCase(rol.get().getDescription())){
            employeeDb.setRol(rol.get());
        }
        return employeeRepository.save(employeeDb);
    }

    @Override
    public void deleteEmployee(String id) throws ModelNotFoundException {
        Employee employeeDB = findEmployeeById(id);
        employeeRepository.deleteById(employeeDB.getIdEmployee());
    }
}
