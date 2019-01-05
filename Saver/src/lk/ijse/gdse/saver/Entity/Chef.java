package lk.ijse.gdse.saver.Entity;

public class Chef {
    int chefID;
    String chefF_Name;
    String chefAddress;
    int chefTel;
    int age ;

    public Chef() {
    }

    public Chef(int chefID, String chefF_Name, String chefAddress, int chefTel, int age) {
        this.chefID = chefID;
        this.chefF_Name = chefF_Name;
        this.chefAddress = chefAddress;
        this.chefTel = chefTel;
        this.age = age;
    }

    public int getChefID() {
        return chefID;
    }

    public void setChefID(int chefID) {
        this.chefID = chefID;
    }

    public String getChefF_Name() {
        return chefF_Name;
    }

    public void setChefF_Name(String chefF_Name) {
        this.chefF_Name = chefF_Name;
    }

    public String getChefAddress() {
        return chefAddress;
    }

    public void setChefAddress(String chefAddress) {
        this.chefAddress = chefAddress;
    }

    public int getChefTel() {
        return chefTel;
    }

    public void setChefTel(int chefTel) {
        this.chefTel = chefTel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

