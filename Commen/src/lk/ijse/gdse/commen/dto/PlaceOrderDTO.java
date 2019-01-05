package lk.ijse.gdse.commen.dto;

public class PlaceOrderDTO extends SuperDTO{
    private int orederID;
    private int customerID;
    private int receptionistID;
    private int itemCode;
    private String orderDate;
    private String orderTakeTime;
    private String orderIssuTime;
    private int orderQty;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(int orederID, int customerID, int receptionistID, int itemCode, String orderDate, String orderTakeTime, String orderIssuTime, int orderQty) {
        this.orederID = orederID;
        this.customerID = customerID;
        this.receptionistID = receptionistID;
        this.itemCode = itemCode;
        this.orderDate = orderDate;
        this.orderTakeTime = orderTakeTime;
        this.orderIssuTime = orderIssuTime;
        this.orderQty = orderQty;
    }

    public PlaceOrderDTO(int orederID, int customerID, int receptionistID, int itemCode, String orderIssuTime, int orderQty) {
        this.orederID = orederID;
        this.customerID = customerID;
        this.receptionistID = receptionistID;
        this.itemCode = itemCode;
        this.orderIssuTime = orderIssuTime;
        this.orderQty = orderQty;
    }

    public PlaceOrderDTO(int orederID, int customerID, int itemCode, String orderIssuTime, int orderQty) {
        this.orederID = orederID;
        this.customerID = customerID;
        this.itemCode = itemCode;
        this.orderIssuTime = orderIssuTime;
        this.orderQty = orderQty;
    }

    public int getOrederID() {
        return orederID;
    }

    public void setOrederID(int orederID) {
        this.orederID = orederID;
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

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTakeTime() {
        return orderTakeTime;
    }

    public void setOrderTakeTime(String orderTakeTime) {
        this.orderTakeTime = orderTakeTime;
    }

    public String getOrderIssuTime() {
        return orderIssuTime;
    }

    public void setOrderIssuTime(String orderIssuTime) {
        this.orderIssuTime = orderIssuTime;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }
}
