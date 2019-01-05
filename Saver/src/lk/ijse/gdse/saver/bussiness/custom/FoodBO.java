package lk.ijse.gdse.saver.bussiness.custom;

import lk.ijse.gdse.commen.dto.FoodDTO;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;

import java.util.ArrayList;

public interface FoodBO extends SuperBO {
    ArrayList<FoodDTO> getAllFooodIds()throws Exception;
}
