package lk.ijse.gdse.saver.service.cm_impl;

import lk.ijse.gdse.commen.cm_custome.OrderQueSavice;
import lk.ijse.gdse.commen.cm_service.SaviceFactory;
import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.CustomerDTO;
import lk.ijse.gdse.commen.dto.OrdersDTO;
import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.commen.observer.Obsever;
import lk.ijse.gdse.commen.observer.Subject;
import lk.ijse.gdse.saver.bussiness.bo.BoFactory;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;
import lk.ijse.gdse.saver.bussiness.custom.OrderQueueBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderQueueSaviceImpl extends UnicastRemoteObject implements OrderQueSavice, Subject {
    private OrderQueueBO orderQueueBO;
    private static List<Obsever> observers = new ArrayList<>();
    public OrderQueueSaviceImpl() throws RemoteException {
        orderQueueBO = (OrderQueueBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.QUEUE);
    }

    @Override
    public ArrayList<OrdersDTO> getAllOrders() throws Exception {
       ArrayList<OrdersDTO> orderDTOS=new ArrayList<>();
        ArrayList<OrdersDTO> allOrders = orderQueueBO.getAllOrders();
        for (OrdersDTO dto:allOrders) {
           orderDTOS.add(new OrdersDTO(
                   dto.getItemCode(),
                   dto.getCustomerID(),
                   dto.getReceptionistID(),
                   dto.getOrderDate(),
                   dto.getOrderQty(),
                   dto.getUnitPrice(),
                   dto.getStatus()));
        }
        notifyObservers();
        return orderDTOS;
    }

    @Override
    public boolean updateOrders(int code) throws Exception {
        boolean b = orderQueueBO.updateOrders(code);
        return b;
    }

    @Override
    public CustomerDTO searchCustomerr(int id) throws Exception {
        CustomerDTO custDto = orderQueueBO.searchCustomerrs(id);
        CustomerDTO cust=new CustomerDTO(custDto.getId(),custDto.getName(),custDto.getAddress(),custDto.getNic(),custDto.getSalary());
        notifyObservers();
        return cust;
    }

    @Override
    public void registerObserver(Obsever observer) throws Exception {
        observers.add(observer);

    }

    @Override
    public void unregisterObserver(Obsever observer) throws Exception {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(() -> {
            for (Obsever observer : observers) {
                try {
                    observer.updateObserver();
                } catch (Exception ex) {
                    Logger.getLogger(OrderQueueSaviceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

}

