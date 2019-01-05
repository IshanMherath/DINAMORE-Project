package lk.ijse.gdse.commen.dto;

public class FoodDTO extends SuperDTO{
    private int itemCode;
    private String  itemName;
    private String itemDescription;
    private int qty;
    private double prise;

    public FoodDTO() {
    }

    public FoodDTO(int itemCode, String itemName, String itemDescription, int qty, double prise) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.qty = qty;
        this.prise = prise;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }
}
