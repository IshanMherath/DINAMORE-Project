package lk.ijse.gdse.commen.cm_custome;

import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.FoodDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface FoodSavice extends SuperSarvice {
    ArrayList<FoodDTO>  loardFoodIds()throws Exception;
}
