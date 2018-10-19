package ua.training.model.entity;

public class Order {
    private int id;
    private String productName;
    private int amount;
    private int customerId;

    public Order() {
    }

    public Order(int id, String productName, int amount, int customerId) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
