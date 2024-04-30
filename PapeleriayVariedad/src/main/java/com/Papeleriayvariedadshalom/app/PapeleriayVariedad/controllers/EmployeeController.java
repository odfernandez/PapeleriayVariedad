package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.controllers;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Employee;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = "*",
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS
        }
)
@RequestMapping("/api/v1/employees")
public class EmployeeController {

        @Autowired
        EmployeeService employeeService;


        @GetMapping(value = "findAllEmployees")
        public List<Employee> findAllEmployees(){
                return employeeService.findAllEmployees();
        }

        @GetMapping(value = "findEmployeeById/{id}")
        public Employee findEmployeeById(@ Valid @PathVariable String id) throws ModelNotFoundException {
                return employeeService.findEmployeeById(id);
        }

        @PostMapping(value = "saveEmployee")
        public Employee saveEmployee(@Valid @RequestBody Employee employee) throws ModelNotFoundException {
                return employeeService.saveEmployee(employee);
        }

        @PutMapping(value = "updateEmployee/{id}")
        public Employee updateEmployee(@Valid @PathVariable String id, @RequestBody Employee employee) throws ModelNotFoundException {
                return employeeService.updateEmployee(id, employee);
        }

        @DeleteMapping(value = "deleteEmployee/{id}")
        public String deleteEmployee(@Valid @PathVariable String id) throws ModelNotFoundException {
                employeeService.deleteEmployee(id);
                return "Successfully Deleted";
        }
}
