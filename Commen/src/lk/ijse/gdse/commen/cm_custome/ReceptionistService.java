package lk.ijse.gdse.commen.cm_custome;

import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.DeliverDTO;
import lk.ijse.gdse.commen.dto.ReseptionDTO;

import java.util.ArrayList;

public interface ReceptionistService extends SuperSarvice {
    boolean addReception(ReseptionDTO dto) throws Exception;
    boolean deleteReception(int id)throws Exception;
    ReseptionDTO searchReceptioin(int id)throws Exception;
    boolean updateReception(ReseptionDTO dto)throws Exception;
    ArrayList<ReseptionDTO> getAllReceptionss()throws Exception;
}
