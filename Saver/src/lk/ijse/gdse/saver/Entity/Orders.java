package lk.ijse.gdse.saver.Entity;

public class Orders {
    private int itemCode;
    private int customerID;
    private int receptionistID;
    private String orderDate;
    private int orderQty;
    private double unitPrice;
    private String status;

    public Orders() {
    }

    public Orders(int itemCode, int customerID, int receptionistID, String orderDate, int orderQty, double unitPrice, String status) {
        this.itemCode = itemCode;
        this.customerID = customerID;
        this.receptionistID = receptionistID;
        this.orderDate = orderDate;
        this.orderQty = orderQty;
        this.unitPrice = unitPrice;
        this.status = status;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(int receptionistID) {
        this.receptionistID = receptionistID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
