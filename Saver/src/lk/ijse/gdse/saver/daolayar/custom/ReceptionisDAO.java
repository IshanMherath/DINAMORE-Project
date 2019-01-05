package lk.ijse.gdse.saver.daolayar.custom;

import lk.ijse.gdse.saver.Entity.Receptionis;
import lk.ijse.gdse.saver.daolayar.dao.CrudDAO;

import java.util.ArrayList;

public interface ReceptionisDAO extends CrudDAO<Receptionis,Integer> {
    boolean addReception(Receptionis receptionis)throws Exception;
    boolean deleteReception(int id)throws Exception;
    Receptionis searchCustomer(int id)throws Exception;
    boolean updateRecption(Receptionis entity)throws Exception;
    ArrayList<Receptionis> getAllReceptionss()throws Exception;
}
