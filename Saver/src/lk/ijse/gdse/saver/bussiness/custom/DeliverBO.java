package lk.ijse.gdse.saver.bussiness.custom;

import lk.ijse.gdse.commen.dto.DeliverDTO;
import lk.ijse.gdse.commen.dto.OrdersDTO;
import lk.ijse.gdse.commen.dto.PaymentDTO;
import lk.ijse.gdse.saver.Entity.Delevers;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;

import java.util.ArrayList;

public interface DeliverBO extends SuperBO {
boolean aaddDelivers(DeliverDTO dto)throws Exception;
boolean deleteDelever(int id)throws Exception;
DeliverDTO SearchDelever(int id)throws Exception;
boolean deleverUpdate(DeliverDTO dto)throws Exception;
ArrayList<DeliverDTO> getAllDelivers()throws Exception;
ArrayList<OrdersDTO> getAllDeleverOrderss()throws Exception;
ArrayList<DeliverDTO> getAllDeleverIds()throws Exception;
boolean updateorderpayment(int id )throws Exception;
}
