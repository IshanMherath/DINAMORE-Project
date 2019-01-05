package lk.ijse.gdse.commen.dto;

public class DeliverDTO extends SuperDTO{
    private int deleverId;
    private String deleverName;
    private String deleverAddress;
    private int bikeRider_Tel;
    private int  age;

    public DeliverDTO() {
    }

    public DeliverDTO(int deleverId, String deleverName, String deleverAddress, int bikeRider_Tel, int age) {
        this.deleverId = deleverId;
        this.deleverName = deleverName;
        this.deleverAddress = deleverAddress;
        this.bikeRider_Tel = bikeRider_Tel;
        this.age = age;
    }

    public int getDeleverId() {
        return deleverId;
    }

    public void setDeleverId(int deleverId) {
        this.deleverId = deleverId;
    }

    public String getDeleverName() {
        return deleverName;
    }

    public void setDeleverName(String deleverName) {
        this.deleverName = deleverName;
    }

    public String getDeleverAddress() {
        return deleverAddress;
    }

    public void setDeleverAddress(String deleverAddress) {
        this.deleverAddress = deleverAddress;
    }

    public int getBikeRider_Tel() {
        return bikeRider_Tel;
    }

    public void setBikeRider_Tel(int bikeRider_Tel) {
        this.bikeRider_Tel = bikeRider_Tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
