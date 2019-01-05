package lk.ijse.gdse.commen.cm_custome;

import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.CustomerDTO;
import lk.ijse.gdse.commen.dto.OrdersDTO;
import lk.ijse.gdse.commen.dto.PlaceOrderDTO;

import java.util.ArrayList;

public interface OrderQueSavice extends SuperSarvice {
    ArrayList<OrdersDTO> getAllOrders() throws Exception;
    boolean updateOrders(int code)throws Exception;
    CustomerDTO searchCustomerr(int id) throws Exception;
}
