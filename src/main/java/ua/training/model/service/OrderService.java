package ua.training.model.service;

import ua.training.model.entity.Customer;
import ua.training.model.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    List<Order> getOrdersByCustomer(Customer customer);
    Order getOrderById(int id);
    Order getOrderByIds(Customer customer, int id);

    Order getOrderByName(String name);
    void deleteOrders();
    void deleteOrdersForCustomer(Customer customer);
    void deleteOrderById(int id);
    void updateOrder(Order order);
    void createOrder(Order order);

}
