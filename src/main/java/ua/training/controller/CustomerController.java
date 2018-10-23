package ua.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.training.model.entity.Customer;
import ua.training.model.entity.Order;
import ua.training.model.service.CustomerService;
import ua.training.model.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> customers = customerService.getCustomers();

        if(customers == null || customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id){
        Customer customer = customerService.getCustomerById(id);

        if(customer == null ){
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/orders", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Order>> getOrderByCustomerId(@PathVariable int id){
        Customer customer = customerService.getCustomerById(id);

        if(customer == null || customer.getOrderList() == null || customer.getOrderList().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customer.getOrderList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/orders/{idOrder}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Order> getOrderById(@PathVariable int id,
                                              @PathVariable int idOrder){
        Customer customer = customerService.getCustomerById(id);


        Order order = null;
        if(customer != null) {
            order = orderService.getOrderByIds(customer, idOrder);
        }

        if(order == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(order, HttpStatus.OK);
    }



    @RequestMapping( method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){

        if(customer == null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerService.createCustomer(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable int id){

        if(customer == null ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerService.updateCustomer(id,customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Customer> deleteCustomer(@PathVariable int id){

        Customer customer = customerService.getCustomerById(id);

        if(customer == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }







}
