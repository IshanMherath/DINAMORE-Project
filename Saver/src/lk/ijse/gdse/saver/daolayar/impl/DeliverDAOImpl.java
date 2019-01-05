package lk.ijse.gdse.saver.daolayar.impl;

import lk.ijse.gdse.commen.dto.DeliverDTO;
import lk.ijse.gdse.saver.Entity.Delevers;
import lk.ijse.gdse.saver.Entity.Orders;
import lk.ijse.gdse.saver.daolayar.custom.DeliverDAO;
import lk.ijse.gdse.saver.daolayar.dao.CrudUtil;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeliverDAOImpl implements DeliverDAO {

    @Override
    public boolean save(Delevers ID) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {

    }

    @Override
    public boolean aaddDelivers(DeliverDTO dto) throws Exception {
        String sql="Insert into Delevers values(?,?,?,?,?)";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,dto.getDeleverId());
        pstm.setObject(2,dto.getDeleverName());
        pstm.setObject(3,dto.getDeleverAddress());
        pstm.setObject(4,dto.getBikeRider_Tel());
        pstm.setObject(5,dto.getAge());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean deleteDelever(int id) throws Exception {
      String sql="Delete from Delevers where deleverId=?";
      Connection connection=DBConnection.getInstance().getConnection();
      PreparedStatement pstm = connection.prepareStatement(sql);
      pstm.setObject(1,id);
      return pstm.executeUpdate() > 0;
    }

    @Override
    public Delevers SearchDelever(int id) throws Exception {
      String sql="Select * from Delevers where deleverId=?";
      Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);
        Delevers delevers=null;
        ResultSet set = pstm.executeQuery();
       while (set.next()){
           delevers=new Delevers(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5));
       }
        return delevers;
    }

    @Override
    public boolean deleverUpdate(Delevers entity) throws Exception {
        String sql="Update delevers set deleverName=?,deleverAddress=?,bikeRider_Tel=?,age=? where deleverId=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,entity.getDeleverName());
        pstm.setObject(2,entity.getDeleverAddress());
        pstm.setObject(3,entity.getBikeRider_Tel());
        pstm.setObject(4,entity.getAge());
        pstm.setObject(5,entity.getDeleverId());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public ArrayList<Delevers> getAllDelivers() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        ResultSet set = CrudUtil.executeQuery("Select * from delevers");
        ArrayList<Delevers> list=new ArrayList<>();
        while (set.next()){
            list.add(new Delevers(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5)));
        }
        return list;
    }

    @Override
    public ArrayList<Orders> getAllDeleverOrderss() throws Exception {
        String id="Order_Over";
        ArrayList<Orders> orders=new ArrayList<>();
        ResultSet set = CrudUtil.executeQuery("Select * from orders where status='" + id + "'");
        while (set.next()){
            orders.add(new Orders(
                    set.getInt(1),
                    set.getInt(2),
                    set.getInt(3),
                    set.getString(4),
                    set.getInt(5),
                    set.getDouble(6),
                    set.getString(7)));
        }
        return orders;
    }

    @Override
    public ArrayList<Delevers> getAllDeleverids() throws Exception {

        ArrayList<Delevers> delevers = new ArrayList<>();

        ResultSet set = CrudUtil.executeQuery("Select * from delevers");
        while (set.next()){
            new Delevers(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5));
        }
        return delevers;
    }

    @Override
    public boolean updateOrdersPayment(int id) throws Exception {
        String state="Order_Delevered";
        boolean b = CrudUtil.executeUpdate("Update Orders set status='" + state + "' where itemCode='" + id + "'");
        return b;
    }
}
