package lk.ijse.gdse.saver.bussiness.custom;

import lk.ijse.gdse.commen.dto.CommenDTO;
import lk.ijse.gdse.commen.dto.CustomerDTO;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;

import java.util.ArrayList;

 public interface CustomerBO extends SuperBO {
    public boolean saveBCustomer(CustomerDTO customerDTO)throws Exception;
    public ArrayList<CustomerDTO> getAllCustomerss()throws Exception;
    public boolean deleteCustomerrs(String id)throws Exception;
    public boolean saveTransaction(CommenDTO commenDTO)throws Exception;
    CustomerDTO searchCustomer(int id)throws Exception;
    boolean saveTransaction2(CommenDTO dto)throws Exception;


}


