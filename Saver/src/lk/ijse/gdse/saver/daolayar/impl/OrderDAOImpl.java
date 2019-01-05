package lk.ijse.gdse.saver.daolayar.impl;

import lk.ijse.gdse.saver.Entity.Orders;
import lk.ijse.gdse.saver.daolayar.custom.OrderDAO;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public void setConnection(Connection connection) throws Exception {

    }

    @Override
    public boolean saveOrder(Orders orders) throws Exception {
        String sql="INSERT INTO orders values (?,?,?,?,?,?,?)";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1,orders.getItemCode());
        pstm.setObject(2,orders.getCustomerID());
        pstm.setObject(3,orders.getReceptionistID());
        pstm.setObject(4,orders.getOrderDate());
        pstm.setObject(5,orders.getOrderQty());
        pstm.setObject(6,orders.getUnitPrice());
        pstm.setObject(7,orders.getStatus());

        return pstm.executeUpdate() > 0;
    }
}
