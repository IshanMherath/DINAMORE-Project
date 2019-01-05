package lk.ijse.gdse.saver.bussiness.impl;

import lk.ijse.gdse.commen.dto.CustomerDTO;
import lk.ijse.gdse.commen.dto.OrdersDTO;
import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.saver.Entity.Customer;
import lk.ijse.gdse.saver.Entity.Orders;
import lk.ijse.gdse.saver.Entity.PlaceOrder;
import lk.ijse.gdse.saver.bussiness.custom.OrderQueueBO;
import lk.ijse.gdse.saver.daolayar.custom.CustomerDAO;
import lk.ijse.gdse.saver.daolayar.custom.OrderQueueDAO;
import lk.ijse.gdse.saver.daolayar.dao.DAOFactory;
import lk.ijse.gdse.saver.daolayar.dao.SuperDAO;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class OrderQueueBOImpl implements OrderQueueBO {
  private   OrderQueueDAO orderQueueDAO;
  //private CustomerDAO customerDAO;
    public OrderQueueBOImpl() {
        orderQueueDAO = (OrderQueueDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.QUEUE);
       // customerDAO= (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.CUSTOMER);
  }

    @Override
    public ArrayList<OrdersDTO> getAllOrders() throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        orderQueueDAO.setConnection(connection);
        ArrayList<OrdersDTO> DTOS=new ArrayList<>();
        ArrayList<Orders> rders = orderQueueDAO.getAllOrders();
        for (Orders place : rders) {
            OrdersDTO placeOrderDTO=new OrdersDTO(
                    place.getItemCode(),
                    place.getCustomerID(),
                    place.getReceptionistID(),
                    place.getOrderDate(),
                    place.getOrderQty(),
                    place.getUnitPrice(),
                    place.getStatus());
                DTOS.add(placeOrderDTO);
        }
        return DTOS;
    }

    @Override
    public boolean updateOrders(int code) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        orderQueueDAO.setConnection(connection);
        boolean b = orderQueueDAO.updateOrders(code);
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public CustomerDTO searchCustomerrs(int id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        orderQueueDAO.setConnection(connection);
        Customer cust = orderQueueDAO.searchCustomer(id);
        CustomerDTO DTO=new CustomerDTO(cust.getCustomerID(),cust.getCustomer_Name(),cust.getCustomerAddress(),cust.getCustomerNicNO(),cust.getSalary());
        DBConnection.getInstance().releaseConnection(connection);
        return DTO;
    }
}
