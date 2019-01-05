package lk.ijse.gdse.saver.daolayar.impl;

import lk.ijse.gdse.saver.Entity.Food;
import lk.ijse.gdse.saver.daolayar.custom.FoodDAO;
import lk.ijse.gdse.saver.daolayar.dao.CrudUtil;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodDAOImpl implements FoodDAO {
    //private Connection connection;
    @Override
    public void setConnection(Connection connection) throws Exception {
        //this.connection=connection;
    }
    @Override
    public boolean save(Food ID) throws Exception {
        String sql="INSERT INTO Food values (?,?,?,?,?)";
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1,ID.getItemCode());
        pstm.setObject(2,ID.getItemName());
        pstm.setObject(3,ID.getItemDescription());
        pstm.setObject(4,ID.getQty());
        pstm.setObject(5,ID.getPrise());
        System.out.println("Food Dto        : "+ID.getItemCode()+" : "+ID.getItemName()+" : "+ID.getItemDescription()+" : "+ID.getQty()+" : "+ID.getPrise());


        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public ArrayList<Food> getAllFoodIds() throws Exception {
        ArrayList<Food> foods=new ArrayList<>();
        ResultSet set = CrudUtil.executeQuery("Select * from food");
        while (set.next()){
            foods.add(new Food(set.getInt(1),set.getString(2),set.getString(3),set.getInt(4),set.getDouble(5)));
        }
        return foods;
    }
}
