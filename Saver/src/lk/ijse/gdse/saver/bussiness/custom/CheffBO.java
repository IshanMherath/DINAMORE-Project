package lk.ijse.gdse.saver.bussiness.custom;

import lk.ijse.gdse.commen.dto.ChefDTO;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;

import java.util.ArrayList;

public interface CheffBO extends SuperBO {
    boolean addOrder()throws Exception;
    boolean addCheff(ChefDTO dto)throws Exception;
    boolean deleteCheff(int id)throws Exception;
    ChefDTO searchCheff(int id)throws Exception;
    boolean updateCheff(ChefDTO dto)throws Exception;
    ArrayList<ChefDTO> getAllCheff()throws Exception;
}
