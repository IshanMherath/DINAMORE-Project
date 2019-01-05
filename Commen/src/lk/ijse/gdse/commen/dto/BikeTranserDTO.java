package lk.ijse.gdse.commen.dto;

import java.io.Serializable;

public class BikeTranserDTO extends SuperDTO {
  private int custid;
  private String custName;
  private String address;
  private String nic;
  private int prise;

    public BikeTranserDTO() {
    }

    public BikeTranserDTO(int custid, String custName, String address, String nic, int prise) {
        this.custid = custid;
        this.custName = custName;
        this.address = address;
        this.nic = nic;
        this.prise = prise;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getPrise() {
        return prise;
    }

    public void setPrise(int prise) {
        this.prise = prise;
    }
}
