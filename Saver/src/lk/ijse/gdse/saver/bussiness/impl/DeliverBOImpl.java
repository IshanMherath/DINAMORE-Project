package lk.ijse.gdse.saver.bussiness.impl;

import lk.ijse.gdse.commen.cm_custome.DeliverSavice;
import lk.ijse.gdse.commen.dto.DeliverDTO;
import lk.ijse.gdse.commen.dto.OrdersDTO;
import lk.ijse.gdse.saver.Entity.Delevers;
import lk.ijse.gdse.saver.Entity.Orders;
import lk.ijse.gdse.saver.bussiness.custom.DeliverBO;
import lk.ijse.gdse.saver.daolayar.custom.DeliverDAO;
import lk.ijse.gdse.saver.daolayar.dao.DAOFactory;
import lk.ijse.gdse.saver.daolayar.dao.SuperDAO;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.util.ArrayList;

public class DeliverBOImpl implements DeliverBO {
    private DeliverDAO deliverDAO;
    public DeliverBOImpl() {
        deliverDAO = (DeliverDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.DELIVER);
    }

    @Override
    public boolean aaddDelivers(DeliverDTO dto) throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        deliverDAO.setConnection(connection);
        boolean b = deliverDAO.aaddDelivers(dto);
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public boolean deleteDelever(int id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        deliverDAO.setConnection(connection);
        boolean b = deliverDAO.deleteDelever(id);
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public DeliverDTO SearchDelever(int id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        deliverDAO.setConnection(connection);
        Delevers delevers = deliverDAO.SearchDelever(id);
        DeliverDTO dto=new DeliverDTO(delevers.getDeleverId(),delevers.getDeleverName(),delevers.getDeleverAddress(),delevers.getBikeRider_Tel(),delevers.getAge());
        DBConnection.getInstance().releaseConnection(connection);
        return dto;
    }

    @Override
    public boolean deleverUpdate(DeliverDTO dto) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        deliverDAO.setConnection(connection);
        boolean b = deliverDAO.deleverUpdate(new Delevers(dto.getDeleverId(), dto.getDeleverName(), dto.getDeleverAddress(), dto.getBikeRider_Tel(), dto.getAge()));
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }

    @Override
    public ArrayList<DeliverDTO> getAllDelivers() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        deliverDAO.setConnection(connection);
        ArrayList<DeliverDTO> dtos=new ArrayList<>();
        ArrayList<Delevers> dto = deliverDAO.getAllDelivers();
        for (Delevers d: dto) {
            dtos.add(new DeliverDTO(d.getDeleverId(),d.getDeleverName(),d.getDeleverAddress(),d.getBikeRider_Tel(),d.getAge()));
        }
return dtos;
    }

    @Override
    public ArrayList<OrdersDTO> getAllDeleverOrderss() throws Exception {
       Connection connection=DBConnection.getInstance().getConnection();
       deliverDAO.setConnection(connection);
        ArrayList<OrdersDTO> delverOrder=new ArrayList<>();
        ArrayList<Orders> orders = deliverDAO.getAllDeleverOrderss();
        for (Orders order:orders) {
            delverOrder.add(new OrdersDTO(
                    order.getItemCode(),
                    order.getCustomerID(),
                    order.getReceptionistID(),
                    order.getOrderDate(),
                    order.getOrderQty(),
                    order.getUnitPrice(),
                    order.getStatus()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return delverOrder;
    }

    @Override
    public ArrayList<DeliverDTO> getAllDeleverIds() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        deliverDAO.setConnection(connection);
        ArrayList<DeliverDTO> delivers=new ArrayList();
        ArrayList<Delevers> dto= deliverDAO.getAllDeleverids();
        for (Delevers del:dto) {
            delivers.add(new DeliverDTO(del.getDeleverId(), del.getDeleverName(), del.getDeleverAddress(), del.getBikeRider_Tel(), del.getAge()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return delivers;
    }

    @Override
    public boolean updateorderpayment(int id) throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        deliverDAO.setConnection(connection);
        boolean b = deliverDAO.updateOrdersPayment(id);
        DBConnection.getInstance().releaseConnection(connection);
        return b;
    }
}
