package ua.training.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.training.model.entity.Customer;
import ua.training.model.service.CustomerService;
import ua.training.model.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customers;

    @Autowired
    private OrderService orderService;
    private int idCounter = 2;


    public CustomerServiceImpl() {
        customers = new ArrayList<>();
        customers.add(new Customer(1, "John Smith"));
        customers.add(new Customer(2, "Adele Dou"));
    }

    @Override
    public List<Customer> getCustomers() {
        for (Customer customer : customers) {
            customer.setOrderList(orderService.getOrdersByCustomer(customer));
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if(customer.getId() == id){
                customer.setOrderList(orderService.getOrdersByCustomer(customer));
                return customer;
            }
        }
        return null;
    }

    @Override
    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if(customer.getName().equals(name)){
                customer.setOrderList(orderService.getOrdersByCustomer(customer));
                return customer;
            }
        }
        return null;
    }

    @Override
    public void deleteCustomers() {
        customers.clear();

    }

    @Override
    public void deleteCustomerById(int id) {
        for (Customer customer : customers) {
            if(customer.getId() == id){
                customers.remove(customer);
            }
        }
    }

    @Override
    public Customer updateCustomer(Customer newCustomer) {
        for (Customer customer : customers) {
            if(customer.getId() == newCustomer.getId()){
                customer.setId(newCustomer.getId());
                customer.setName(newCustomer.getName());
                customer.setOrderList(newCustomer.getOrderList());
                return customer;
            }
        }
        return null;
    }

    @Override
    public void createCustomer(Customer customer) {
        customers.add(customer);
    }
}
