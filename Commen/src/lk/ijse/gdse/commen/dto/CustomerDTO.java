package lk.ijse.gdse.commen.dto;

public class CustomerDTO extends SuperDTO {
    private int id;
    private String name;
    private String address;
    private String nic;
    private int salary;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String name, String address, String nic, int salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
