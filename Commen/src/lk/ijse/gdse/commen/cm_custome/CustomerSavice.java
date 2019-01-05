package lk.ijse.gdse.commen.cm_custome;

import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.CommenDTO;
import lk.ijse.gdse.commen.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerSavice extends SuperSarvice {
    public boolean CustomerSave(CustomerDTO customerDTO)throws Exception;
    public ArrayList<CustomerDTO> getAllCustomer()throws Exception;
    public boolean DeleteCustomer(String id)throws Exception;
    public boolean saveTransaction(CommenDTO commenDTO)throws Exception;
    boolean saveTransaction2(CommenDTO dto)throws Exception;
    CustomerDTO searchCustomer(int id)throws Exception;

}
