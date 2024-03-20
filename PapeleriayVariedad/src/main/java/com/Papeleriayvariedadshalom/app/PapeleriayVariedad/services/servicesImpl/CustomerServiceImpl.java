package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.servicesImpl;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Company;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Customer;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories.CustomerRepository;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl  implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(String id) throws ModelNotFoundException {
        Optional<Customer> customer = customerRepository.findById(id);
        if (!customer.isPresent()){
            throw new ModelNotFoundException("Customer is not available");
        }
        return customer.get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
