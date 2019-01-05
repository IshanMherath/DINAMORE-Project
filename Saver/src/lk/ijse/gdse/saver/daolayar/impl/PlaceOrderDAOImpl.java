package lk.ijse.gdse.saver.daolayar.impl;

import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.saver.Entity.PlaceOrder;
import lk.ijse.gdse.saver.daolayar.custom.PlaceOrderDAO;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {
//    private Connection connection;
    public PlaceOrderDAOImpl() {

    }

    @Override
    public void setConnection(Connection connection) throws Exception {
//        this.connection=connection;
    }

    @Override
    public boolean save(PlaceOrder ID) throws Exception {
        String sql="INSERT INTO placeorder values (?,?,?,?,?,?,?,?)";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm= connection.prepareStatement(sql);
        pstm.setObject(1,ID.getOrederID());
        pstm.setObject(2,ID.getCustomerID());
        pstm.setObject(3,ID.getReceptionistID());
        pstm.setObject(4,ID.getItemCode());

        pstm.setObject(5,ID.getOrderDate());
        pstm.setObject(6,ID.getOrderTakeTime());
        pstm.setObject(7,ID.getOrderIssuTime());
        pstm.setObject(8,ID.getOrderQty());
        System.out.println("Place Order DTO : "+ID.getOrederID()+" : "+ID.getCustomerID()+" : "+ID.getReceptionistID()+" : "+ID.getOrderDate()+" : "+ID.getOrderTakeTime()+" : "+ID.getOrderIssuTime()+" : "+ID.getOrderQty());

        return pstm.executeUpdate() > 0;

    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }


}
