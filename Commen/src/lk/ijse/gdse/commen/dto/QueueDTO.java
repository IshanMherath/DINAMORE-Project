package lk.ijse.gdse.commen.dto;

public class QueueDTO extends SuperDTO {
    private int orederID;
    private int customerID;
    private int itemCode;
    private String orderIssuTime;
    private int orderQty;

    public QueueDTO() {
    }

    public QueueDTO(int orederID, int customerID, int itemCode, String orderIssuTime, int orderQty) {
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

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
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
