package lk.ijse.gdse.saver.bussiness.custom;

import lk.ijse.gdse.commen.dto.CustomerDTO;
import lk.ijse.gdse.commen.dto.OrdersDTO;
import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;

import java.util.ArrayList;

public interface OrderQueueBO extends SuperBO {
    ArrayList<OrdersDTO> getAllOrders()throws Exception;
    boolean updateOrders(int code)throws Exception;
    CustomerDTO searchCustomerrs(int id) throws Exception;
}
