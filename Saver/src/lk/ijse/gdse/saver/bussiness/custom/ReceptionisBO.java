package lk.ijse.gdse.saver.bussiness.custom;

import lk.ijse.gdse.commen.dto.ReseptionDTO;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;

import java.util.ArrayList;

public interface ReceptionisBO extends SuperBO {
    boolean addReception(ReseptionDTO dto)throws Exception;
    boolean deleteReception(int id)throws Exception;
    ReseptionDTO serchCustomer(int id)throws Exception;
    boolean UpdateReception(ReseptionDTO dto)throws Exception;
    ArrayList<ReseptionDTO> getAllReceptionss()throws Exception;
}
