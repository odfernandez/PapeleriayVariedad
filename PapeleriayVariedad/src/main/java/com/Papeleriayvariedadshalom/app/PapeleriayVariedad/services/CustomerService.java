package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers();
    Customer findCustomerById(String id) throws ModelNotFoundException;
    Customer saveCustomer(Customer customer);
    Customer updateCustomer(String id, Customer customer) throws ModelNotFoundException;
    void deleteCustomer(String id) throws ModelNotFoundException;
}
