package lk.ijse.gdse.commen.cm_custome;

import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.*;

import java.util.ArrayList;

public interface DeliverSavice extends SuperSarvice {
    CustomerDTO serchCustomerInDelever(int id)throws Exception;
    ArrayList<PlaceOrderDTO> addDeleverQueue()throws Exception;
    boolean addDelevers(DeliverDTO dto)throws Exception;
    boolean DeleteDelever(int id)throws Exception;
    DeliverDTO searchDelevers(int id)throws Exception;
    boolean deleverUpdate(DeliverDTO dto)throws Exception;
    ArrayList<DeliverDTO> getAllDeleverss()throws Exception;
    ArrayList<OrdersDTO> getAllDeleverOrder()throws Exception;
    ArrayList<DeliverDTO> getAllDeleversIds()throws Exception;
    boolean updatOrderPayment(int id)throws Exception;

}
