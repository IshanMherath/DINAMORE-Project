package lk.ijse.gdse.saver.service.cm_impl;

import lk.ijse.gdse.commen.cm_custome.DeliverSavice;
import lk.ijse.gdse.commen.dto.CustomerDTO;
import lk.ijse.gdse.commen.dto.DeliverDTO;
import lk.ijse.gdse.commen.dto.OrdersDTO;
import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.saver.bussiness.bo.BoFactory;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;
import lk.ijse.gdse.saver.bussiness.custom.CustomerBO;
import lk.ijse.gdse.saver.bussiness.custom.DeliverBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class DeliverSaviceImpl extends UnicastRemoteObject implements DeliverSavice {
    private DeliverBO deliverBO;
    private CustomerBO customerBO;
    public DeliverSaviceImpl() throws RemoteException {
        deliverBO = (DeliverBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.DELIVER);
        customerBO= (CustomerBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.CUSTOMER);
    }

    @Override
    public CustomerDTO serchCustomerInDelever(int id) throws Exception {
        CustomerDTO cutomer = customerBO.searchCustomer(id);
        return new CustomerDTO(cutomer.getId(),cutomer.getName(),cutomer.getAddress(),cutomer.getNic(),cutomer.getSalary());
    }

    @Override
    public ArrayList<PlaceOrderDTO> addDeleverQueue() throws Exception {
        return null;
    }

    @Override
    public boolean addDelevers(DeliverDTO dto) throws Exception {
        return deliverBO.aaddDelivers(dto);
    }

    @Override
    public boolean DeleteDelever(int id) throws Exception {
        return deliverBO.deleteDelever(id);
    }

    @Override
    public DeliverDTO searchDelevers(int id) throws Exception {
        DeliverDTO dto = deliverBO.SearchDelever(id);
        return dto;
    }

    @Override
    public boolean deleverUpdate(DeliverDTO dto) throws Exception {
        return deliverBO.deleverUpdate(dto);
    }

    @Override
    public ArrayList<DeliverDTO> getAllDeleverss() throws Exception {
        ArrayList<DeliverDTO> allDelivers = deliverBO.getAllDelivers();
        return allDelivers;
    }

    @Override
    public ArrayList<OrdersDTO> getAllDeleverOrder() throws Exception {
        ArrayList<OrdersDTO> allDeleverOrderss = deliverBO.getAllDeleverOrderss();
        return allDeleverOrderss;
    }

    @Override
    public ArrayList<DeliverDTO> getAllDeleversIds() throws Exception {
        ArrayList<DeliverDTO> allDeleverIds = deliverBO.getAllDelivers();
        return allDeleverIds;
    }

    @Override
    public boolean updatOrderPayment(int id) throws Exception {
        boolean updateorderpayment = deliverBO.updateorderpayment(id);
        return updateorderpayment;
    }

//    @Override
//    public ArrayList<PlaceOrderDTO> addDeleverQueue(ArrayList<PlaceOrderDTO> dtos) throws Exception {
//        ArrayList<PlaceOrderDTO> dtos1 = new ArrayList<>();
//        for (PlaceOrderDTO p:dtos) {
//            dtos1.add(new PlaceOrderDTO(p.getOrederID(),p.getCustomerID(),p.getItemCode(),p.getOrderIssuTime(),p.getOrderQty()));
//        }
//        return dtos1;
//    }
}
