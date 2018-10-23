package ua.training.model.service.impl;

import org.springframework.stereotype.Service;
import ua.training.model.entity.Customer;
import ua.training.model.entity.Order;
import ua.training.model.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private List<Order> orders;

    public OrderServiceImpl() {
        orders = new ArrayList<>();
        orders.add(new Order(1, "banana", 4, 1));
        orders.add(new Order(2, "apple", 334, 1));
        orders.add(new Order(3, "grape", 34, 1));
        orders.add(new Order(4, "banana1", 44, 2));
        orders.add(new Order(5, "banana2", 45, 2));
        orders.add(new Order(6, "banana3", 54, 2));
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public List<Order> getOrdersByCustomer(Customer customer) {
        List<Order> orders1 = new ArrayList<>();
        for (Order order : orders){
            if(order.getCustomerId() == customer.getId()){
                orders1.add(order);
            }
        }
        return orders1;
    }

    @Override
    public Order getOrderById(int id) {
        for (Order order : orders){
            if(order.getId() == id){
                return order;
            }
        }
        return null;
    }

    @Override
    public Order getOrderByIds(Customer customer, int idOrder) {
        for (Order order : orders){
            if(order.getCustomerId() == customer.getId() && order.getId() == idOrder){
                return order;
            }
        }
        return null;
    }

    @Override
    public Order getOrderByName(String name) {
        for (Order order : orders){
            if(order.getProductName() == name){
                return order;
            }
        }
        return null;
    }

    @Override
    public void deleteOrdersForCustomer(Customer customer) {
        for (Order order : orders){
            if(order.getCustomerId() == customer.getId()){
               orders.remove(order);
            }
        }
    }

    @Override
    public void deleteOrders(){
        orders.clear();
    }

    @Override
    public void deleteOrderById(int id) {
        for (Order order : orders){
            if(order.getId() == id){
                orders.remove(order);
            }
        }

    }

    @Override
    public void updateOrder(Order newOrder) {
        for (Order order : orders){
            if(order.getId() == newOrder.getId()){
                order.setProductName(newOrder.getProductName());
                order.setAmount(newOrder.getAmount());
                order.setCustomerId(newOrder.getCustomerId());
            }
        }
    }

    @Override
    public void createOrder(Order order) {
        orders.add(order);
    }
}
