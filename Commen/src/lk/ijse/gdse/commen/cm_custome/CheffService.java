package lk.ijse.gdse.commen.cm_custome;

import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.ChefDTO;
import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.commen.dto.QueueDTO;

import java.util.ArrayList;

public interface CheffService extends SuperSarvice {
    PlaceOrderDTO serchOrder()throws Exception;
    boolean addCheff(QueueDTO dto)throws Exception;
    boolean addCheff(ChefDTO dto)throws Exception;
    boolean deleteCheff(int id)throws Exception;
    ChefDTO searchCheff(int id)throws Exception;
    boolean updateChef(ChefDTO dto)throws Exception;
    ArrayList<ChefDTO> getAllCheff()throws Exception;
}
