package lk.ijse.gdse.saver.daolayar.custom;

import lk.ijse.gdse.commen.dto.ChefDTO;
import lk.ijse.gdse.commen.dto.QueueDTO;
import lk.ijse.gdse.saver.Entity.Chef;
import lk.ijse.gdse.saver.daolayar.dao.CrudDAO;

import java.util.ArrayList;

public interface CheffDAO extends CrudDAO<ChefDTO,Integer> {
    boolean addCheff(Chef dto)throws Exception;
    boolean deleteCheff(int id)throws Exception;
    Chef searchCheff(int id)throws Exception;
    boolean updateCheff(Chef entity)throws Exception;
    ArrayList<Chef> getAllCheff()throws Exception;
}
