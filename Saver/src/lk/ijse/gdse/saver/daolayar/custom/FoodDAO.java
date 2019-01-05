package lk.ijse.gdse.saver.daolayar.custom;

import lk.ijse.gdse.commen.dto.FoodDTO;
import lk.ijse.gdse.saver.Entity.Food;
import lk.ijse.gdse.saver.daolayar.dao.CrudDAO;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface FoodDAO extends CrudDAO<Food,Integer> {
    ArrayList<Food> getAllFoodIds()throws Exception;

}
