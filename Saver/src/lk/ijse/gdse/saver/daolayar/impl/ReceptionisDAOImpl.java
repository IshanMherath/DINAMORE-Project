package lk.ijse.gdse.saver.daolayar.impl;

import lk.ijse.gdse.saver.Entity.Receptionis;
import lk.ijse.gdse.saver.daolayar.custom.ReceptionisDAO;
import lk.ijse.gdse.saver.daolayar.dao.CrudUtil;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReceptionisDAOImpl implements ReceptionisDAO {
    @Override
    public boolean addReception(Receptionis receptionis) throws Exception {
        String sql="Insert into receptionist values(?,?,?,?,?,?)";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,receptionis.getReceptionistID());
        pstm.setObject(2,receptionis.getReceptionistF_Name());
        pstm.setObject(3,receptionis.getReceptionistAddress());
        pstm.setObject(4,receptionis.getReceptionistTel());
        pstm.setObject(5,receptionis.getAge());
        pstm.setObject(6,receptionis.getCity());

        return pstm.executeUpdate() > 0;

    }

    @Override
    public boolean deleteReception(int id) throws Exception {
        String sql="Delete from receptionist where receptionistID=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public Receptionis searchCustomer(int id) throws Exception {
        String sql="Select * from receptionist where receptionistID=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);
        ResultSet set = pstm.executeQuery();
       Receptionis receptionis=null;
        while (set.next()){
            receptionis=new Receptionis(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5),set.getString(6));

        }
        return receptionis;

    }

    @Override
    public boolean updateRecption(Receptionis entity) throws Exception {
        String sql="Update receptionist set receptionistF_Name=?,receptionistAddress=?,receptionistTel=?,age=?,city=? where receptionistID=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,entity.getReceptionistF_Name());
        pstm.setObject(2,entity.getReceptionistAddress());
        pstm.setObject(3,entity.getReceptionistTel());
        pstm.setObject(4,entity.getAge());
        pstm.setObject(5,entity.getCity());
        pstm.setObject(6,entity.getReceptionistID());

        return pstm.executeUpdate() > 0;

    }

    @Override
    public ArrayList<Receptionis> getAllReceptionss() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        ArrayList<Receptionis> list=new ArrayList<>();
        ResultSet set = CrudUtil.executeQuery("Select * from receptionist");
        while (set.next()){
            list.add(new Receptionis(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5),set.getString(6)));
        }
        return list;
    }

    @Override
    public boolean save(Receptionis ID) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {

    }
}
