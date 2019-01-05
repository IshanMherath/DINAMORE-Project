package lk.ijse.gdse.saver.bussiness.impl;

import lk.ijse.gdse.commen.dto.CommenDTO;
import lk.ijse.gdse.commen.dto.CustomerDTO;
import lk.ijse.gdse.commen.dto.FoodDTO;
import lk.ijse.gdse.saver.Entity.Food;
import lk.ijse.gdse.saver.bussiness.custom.CustomerBO;
import lk.ijse.gdse.saver.bussiness.custom.FoodBO;
import lk.ijse.gdse.saver.daolayar.custom.FoodDAO;
import lk.ijse.gdse.saver.daolayar.dao.DAOFactory;
import lk.ijse.gdse.saver.daolayar.dao.SuperDAO;
import lk.ijse.gdse.saver.resouse.DBConnection;

import java.sql.Connection;
import java.util.ArrayList;

public class FoodBOImpl implements FoodBO {
    private FoodDAO foodDAO;
    public FoodBOImpl() {
        foodDAO = (FoodDAO) DAOFactory.getInstance().getDAO(DAOFactory.BOTypes.FOOD);
    }

    @Override
    public ArrayList<FoodDTO> getAllFooodIds() throws Exception {
        Connection connection= DBConnection.getInstance().getConnection();
        foodDAO.setConnection(connection);
        ArrayList<FoodDTO>  dtos=new ArrayList<>();
        ArrayList<Food> allFoodIds = foodDAO.getAllFoodIds();
        for (Food foodDTO:allFoodIds) {
            dtos.add(new FoodDTO(foodDTO.getItemCode(),foodDTO.getItemName(),foodDTO.getItemDescription(),foodDTO.getQty(),foodDTO.getPrise()));
        }
        DBConnection.getInstance().releaseConnection(connection);
        return dtos;
    }
}
