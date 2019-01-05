package lk.ijse.gdse.saver.Entity;

public class Receptionis {
    private int  receptionistID;
    private String  receptionistF_Name;
    private String  receptionistAddress;
    private int receptionistTel ;
    private int age;
    private String city;

    public Receptionis() {
    }

    public Receptionis(int receptionistID, String receptionistF_Name, String receptionistAddress, int receptionistTel, int age, String city) {
        this.receptionistID = receptionistID;
        this.receptionistF_Name = receptionistF_Name;
        this.receptionistAddress = receptionistAddress;
        this.receptionistTel = receptionistTel;
        this.age = age;
        this.city = city;
    }

    public int getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(int receptionistID) {
        this.receptionistID = receptionistID;
    }

    public String getReceptionistF_Name() {
        return receptionistF_Name;
    }

    public void setReceptionistF_Name(String receptionistF_Name) {
        this.receptionistF_Name = receptionistF_Name;
    }

    public String getReceptionistAddress() {
        return receptionistAddress;
    }

    public void setReceptionistAddress(String receptionistAddress) {
        this.receptionistAddress = receptionistAddress;
    }

    public int getReceptionistTel() {
        return receptionistTel;
    }

    public void setReceptionistTel(int receptionistTel) {
        this.receptionistTel = receptionistTel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
