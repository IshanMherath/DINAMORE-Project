package lk.ijse.gdse.saver.Entity;

public class Customer {
    private int customerID;
    private String  customer_Name;
    private String customerAddress;
    private String customerNicNO;
    private int salary;

    public Customer() {
    }

    public Customer(int customerID, String customer_Name, String customerAddress, String customerNicNO, int salary) {
        this.customerID = customerID;
        this.customer_Name = customer_Name;
        this.customerAddress = customerAddress;
        this.customerNicNO = customerNicNO;
        this.salary = salary;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomer_Name() {
        return customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        this.customer_Name = customer_Name;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerNicNO() {
        return customerNicNO;
    }

    public void setCustomerNicNO(String customerNicNO) {
        this.customerNicNO = customerNicNO;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
