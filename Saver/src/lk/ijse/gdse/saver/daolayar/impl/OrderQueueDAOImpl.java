package lk.ijse.gdse.saver.daolayar.impl;

import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.saver.Entity.Customer;
import lk.ijse.gdse.saver.Entity.Orders;
import lk.ijse.gdse.saver.Entity.PlaceOrder;
import lk.ijse.gdse.saver.daolayar.custom.OrderQueueDAO;
import lk.ijse.gdse.saver.daolayar.dao.CrudUtil;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderQueueDAOImpl implements OrderQueueDAO {
    private Connection connection;
    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection=connection;
    }

    @Override
    public ArrayList<Orders> getAllOrders() throws Exception {
        String id="Pending";
        ArrayList<Orders> placeOrder= new ArrayList<>();
       ResultSet set = CrudUtil.executeQuery("Select * from orders where status='"+id+"'");

//        String sql="Select * from orders where status='\"+Pending+\"'";
        while (set.next()){
            placeOrder.add(new Orders(
                    set.getInt(1),
                    set.getInt(2),
                    set.getInt(3),

                    set.getString(4),
                    set.getInt(5),
                    set.getDouble(6),
                    set.getString(7)));
        }
        return placeOrder;
       // System.out.println();
    }

    @Override
    public boolean updateOrders(int code) throws Exception {
        String id="Order_Over";
        boolean b = CrudUtil.executeUpdate("Update Orders set status='" + id + "' where itemCode='" + code + "'");
        return b;
    }

    @Override
    public Customer searchCustomer(int custId) throws Exception {
        String sql="Select * from customer where customerID=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,custId);
        ResultSet set = pstm.executeQuery();
        Customer customer=null;
        while (set.next()){
            customer= new Customer(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getInt(5));

        }
        return customer;
    }

}
