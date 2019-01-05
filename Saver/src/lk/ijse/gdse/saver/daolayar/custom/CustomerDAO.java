package lk.ijse.gdse.saver.daolayar.custom;

import lk.ijse.gdse.commen.dto.CommenDTO;
import lk.ijse.gdse.saver.Entity.Customer;
import lk.ijse.gdse.saver.daolayar.dao.CrudDAO;
import lk.ijse.gdse.saver.daolayar.dao.SuperDAO;

import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer, Integer> {
    public ArrayList<Customer> getAllCustomersss()throws Exception;
    Customer SearchCustomer(int id)throws Exception;

}
