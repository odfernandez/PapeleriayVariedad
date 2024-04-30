package com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.servicesImpl;

import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.errors.ModelNotFoundException;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.models.Customer;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.repositories.CustomerRepository;
import com.Papeleriayvariedadshalom.app.PapeleriayVariedad.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        if (customer.isEmpty()){
            throw new ModelNotFoundException("Customer is not available");
        }
        return customer.get();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer customerDb = Customer.builder()
                .idCustomer(customer.getIdCustomer())
                .firstName(customer.getFirstName())
                .secondName(customer.getSecondName())
                .firstLastName(customer.getFirstLastName())
                .secondLastName(customer.getSecondLastName())
                .address(customer.getAddress())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .build();
        return customerRepository.save(customerDb);
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) throws ModelNotFoundException {
        Customer customerDb = findCustomerById(id);
        if (Objects.nonNull(customer.getIdCustomer())&& !"".equalsIgnoreCase(customer.getIdCustomer())){
            customerDb.setIdCustomer(customer.getIdCustomer());
        }
        if (Objects.nonNull(customer.getFirstName())&& !"".equalsIgnoreCase(customer.getFirstName())){
            customerDb.setFirstName(customer.getFirstName());
        }
        customerDb.setSecondName(customer.getSecondName());
        if (Objects.nonNull(customer.getFirstLastName())&& !"".equalsIgnoreCase(customer.getFirstLastName())){
            customerDb.setFirstLastName(customer.getFirstLastName());
        }
        customerDb.setSecondLastName(customer.getSecondLastName());
        if (Objects.nonNull(customer.getAddress())&& !"".equalsIgnoreCase(customer.getAddress())){
            customerDb.setAddress(customer.getAddress());
        }
        if (Objects.nonNull(customer.getPhone())&& !"".equalsIgnoreCase(customer.getPhone())){
            customerDb.setPhone(customer.getPhone());
        }
        if (Objects.nonNull(customer.getEmail())&& !"".equalsIgnoreCase(customer.getEmail())){
            customerDb.setEmail(customer.getEmail());
        }

        return customerRepository.save(customerDb);
    }

    @Override
    public void deleteCustomer(String id) throws ModelNotFoundException {
        Customer customerDb = findCustomerById(id);
        customerRepository.deleteById(customerDb.getIdCustomer());
    }
}
