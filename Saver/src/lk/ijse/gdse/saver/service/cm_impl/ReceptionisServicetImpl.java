package lk.ijse.gdse.saver.service.cm_impl;

import lk.ijse.gdse.commen.cm_custome.ReceptionistService;
import lk.ijse.gdse.commen.cm_service.SaviceFactory;
import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.commen.dto.ReseptionDTO;
import lk.ijse.gdse.saver.bussiness.bo.BoFactory;
import lk.ijse.gdse.saver.bussiness.custom.ReceptionisBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ReceptionisServicetImpl extends UnicastRemoteObject implements ReceptionistService {
    private ReceptionisBO receptionisBO;
    public ReceptionisServicetImpl() throws RemoteException {
        receptionisBO= (ReceptionisBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.RECEPTIONIST);
    }

    @Override
    public boolean addReception(ReseptionDTO dto) throws Exception {
        return receptionisBO.addReception(dto);
    }

    @Override
    public boolean deleteReception(int id) throws Exception {
        return receptionisBO.deleteReception(id);
    }

    @Override
    public ReseptionDTO searchReceptioin(int id) throws Exception {
        ReseptionDTO dto = receptionisBO.serchCustomer(id);
        return dto;
    }

    @Override
    public boolean updateReception(ReseptionDTO dto) throws Exception {
       return receptionisBO.UpdateReception(dto);
    }

    @Override
    public ArrayList<ReseptionDTO> getAllReceptionss() throws Exception {
        ArrayList<ReseptionDTO> allReceptionss = receptionisBO.getAllReceptionss();
        return allReceptionss;
    }
}
