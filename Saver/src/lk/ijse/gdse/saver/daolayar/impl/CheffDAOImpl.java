package lk.ijse.gdse.saver.daolayar.impl;

import lk.ijse.gdse.commen.cm_custome.CheffService;
import lk.ijse.gdse.commen.dto.ChefDTO;
import lk.ijse.gdse.commen.dto.QueueDTO;
import lk.ijse.gdse.saver.Entity.Chef;
import lk.ijse.gdse.saver.daolayar.custom.CheffDAO;
import lk.ijse.gdse.saver.daolayar.dao.CrudUtil;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CheffDAOImpl implements CheffDAO {

    @Override
    public boolean save(ChefDTO ID) throws Exception {
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
    public boolean addCheff(Chef dto) throws Exception {
        String sql="Insert into Chef values(?,?,?,?,?)";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,dto.getChefID());
        pstm.setObject(2,dto.getChefF_Name());
        pstm.setObject(3,dto.getChefAddress());
        pstm.setObject(4,dto.getChefTel());
        pstm.setObject(5,dto.getAge());

        return pstm.executeUpdate() >0;

    }

    @Override
    public boolean deleteCheff(int id) throws Exception {
        String sql="Delete from Chef where chefID=? ";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public Chef searchCheff(int id) throws Exception {
        String sql="Select * from Chef where chefID=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,id);
        ResultSet set = pstm.executeQuery();
        Chef chef=null;
        while (set.next()){
            chef= new Chef(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5));
        }
        return chef;
    }

    @Override
    public boolean updateCheff(Chef entity) throws Exception {
        String sql="Update chef set chefF_Name=?,chefAddress=?,chefTel=?,age=? where chefID=?";
        Connection connection=DBConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1,entity.getChefF_Name());
        pstm.setObject(2,entity.getChefAddress());
        pstm.setObject(3,entity.getChefTel());
        pstm.setObject(4,entity.getAge());
        pstm.setObject(5,entity.getChefID());

        return pstm.executeUpdate() > 0;

    }

    @Override
    public ArrayList<Chef> getAllCheff() throws Exception {
        Connection connection=DBConnection.getInstance().getConnection();
        ArrayList<Chef> chefs=new ArrayList<>();
        ResultSet set = CrudUtil.executeQuery("Select * from Chef");
        while (set.next()){
            chefs.add(new Chef(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getInt(5)));
        }
        return chefs;
    }
}
