package lk.ijse.gdse.saver.daolayar.custom;

import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.saver.Entity.Customer;
import lk.ijse.gdse.saver.Entity.Orders;
import lk.ijse.gdse.saver.Entity.PlaceOrder;
import lk.ijse.gdse.saver.daolayar.dao.SuperDAO;

import java.util.ArrayList;

public interface OrderQueueDAO extends SuperDAO {
    ArrayList<Orders> getAllOrders()throws Exception;
    boolean updateOrders(int code)throws Exception;
    Customer searchCustomer(int custId)throws Exception;
}
