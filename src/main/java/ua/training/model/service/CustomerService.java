package ua.training.model.service;

import ua.training.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer getCustomerById(int id);
    Customer getCustomerByName(String name);
    void deleteCustomers();
    void deleteCustomerById(int id);
    Customer updateCustomer(Customer customer);
    void createCustomer(Customer customer);

}
