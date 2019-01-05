package lk.ijse.gdse.saver.service.cm_impl;

import lk.ijse.gdse.commen.cm_custome.CheffService;
import lk.ijse.gdse.commen.dto.ChefDTO;
import lk.ijse.gdse.commen.dto.PlaceOrderDTO;
import lk.ijse.gdse.commen.dto.QueueDTO;
import lk.ijse.gdse.saver.bussiness.bo.BoFactory;
import lk.ijse.gdse.saver.bussiness.bo.SuperBO;
import lk.ijse.gdse.saver.bussiness.custom.CheffBO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CheffServiceImpl extends UnicastRemoteObject implements CheffService {
private CheffBO cheffBO;
    public CheffServiceImpl() throws RemoteException {
    cheffBO= (CheffBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.CHEFF);
    }

    @Override
    public PlaceOrderDTO serchOrder() throws Exception {
        return null;
    }

    @Override
    public boolean addCheff(QueueDTO dto) throws Exception {
        return true;
    }

    @Override
    public boolean addCheff(ChefDTO dto) throws Exception {
        return cheffBO.addCheff(dto);
    }

    @Override
    public boolean deleteCheff(int id) throws Exception {
        return cheffBO.deleteCheff(id);
    }

    @Override
    public ChefDTO searchCheff(int id) throws Exception {
        ChefDTO dto = cheffBO.searchCheff(id);
        return dto;
    }

    @Override
    public boolean updateChef(ChefDTO dto) throws Exception {
        return cheffBO.updateCheff(dto);
    }

    @Override
    public ArrayList<ChefDTO> getAllCheff() throws Exception {
        ArrayList<ChefDTO> allCheff = cheffBO.getAllCheff();
        return allCheff;
    }
}
