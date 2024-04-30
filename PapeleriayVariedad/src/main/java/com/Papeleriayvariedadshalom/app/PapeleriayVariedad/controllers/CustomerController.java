package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.controllers;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Customer;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.CustomerService;
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
@RequestMapping(value = "/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping(value = "findAllCustomers")
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping(value = "findCustomerById/{id}")
    public Customer findCustomerById(@Valid @PathVariable String id) throws ModelNotFoundException {
        return customerService.findCustomerById(id);
    }

    @PostMapping(value = "saveCustomer")
    public Customer saveCustomer(@Valid @RequestBody Customer customer) throws ModelNotFoundException {
        return customerService.saveCustomer(customer);
    }

    @PutMapping(value = "updateCustomer/{id}")
    public Customer updateCustomer(@Valid @PathVariable String id, @RequestBody Customer customer) throws ModelNotFoundException {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping(value = "deleteCustomer/{id}")
    public String deleteCustomer(@Valid @PathVariable String id) throws ModelNotFoundException {
        customerService.deleteCustomer(id);
        return "Successfully Deleted";
    }
}
