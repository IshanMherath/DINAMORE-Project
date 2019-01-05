package lk.ijse.gdse.saver.daolayar.custom;

import lk.ijse.gdse.commen.dto.DeliverDTO;
import lk.ijse.gdse.commen.dto.OrdersDTO;
import lk.ijse.gdse.saver.Entity.Delevers;
import lk.ijse.gdse.saver.Entity.Orders;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;
import lk.ijse.gdse.saver.daolayar.dao.CrudDAO;

import java.util.ArrayList;

public interface DeliverDAO extends CrudDAO<Delevers,Integer> {
    boolean aaddDelivers(DeliverDTO dto)throws Exception;
    boolean deleteDelever(int id)throws Exception;
    Delevers SearchDelever(int id)throws Exception;
    boolean deleverUpdate(Delevers entity)throws Exception;
    ArrayList<Delevers> getAllDelivers()throws Exception;
    ArrayList<Orders> getAllDeleverOrderss()throws Exception;
    ArrayList<Delevers> getAllDeleverids()throws Exception;
    boolean updateOrdersPayment(int id)throws Exception;
}
