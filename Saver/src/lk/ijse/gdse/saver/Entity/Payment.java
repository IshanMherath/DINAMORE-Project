package lk.ijse.gdse.saver.Entity;

public class Payment {
    private int pay_id;
    private int deliver_id;
    private int customerID;
    private double deliverfee;
    private double discount;
    private double total_Price;
    private double balance;

    public Payment() {
    }

    public Payment(int pay_id, int deliver_id, int customerID, double deliverfee, double discount, double total_Price, double balance) {
        this.pay_id = pay_id;
        this.deliver_id = deliver_id;
        this.customerID = customerID;
        this.deliverfee = deliverfee;
        this.discount = discount;
        this.total_Price = total_Price;
        this.balance = balance;
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
    }

    public int getDeliver_id() {
        return deliver_id;
    }

    public void setDeliver_id(int deliver_id) {
        this.deliver_id = deliver_id;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public double getDeliverfee() {
        return deliverfee;
    }

    public void setDeliverfee(double deliverfee) {
        this.deliverfee = deliverfee;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal_Price() {
        return total_Price;
    }

    public void setTotal_Price(double total_Price) {
        this.total_Price = total_Price;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
