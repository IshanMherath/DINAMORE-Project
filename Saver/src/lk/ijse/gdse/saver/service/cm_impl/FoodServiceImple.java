package lk.ijse.gdse.saver.service.cm_impl;

import lk.ijse.gdse.commen.cm_custome.FoodSavice;
import lk.ijse.gdse.commen.dto.FoodDTO;
import lk.ijse.gdse.saver.bussiness.bo.BoFactory;
import lk.ijse.gdse.saver.bussiness.custom.FoodBO;
import lk.ijse.gdse.saver.daolayar.dao.DAOFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class FoodServiceImple extends UnicastRemoteObject implements FoodSavice {
    private FoodBO foodBO;
    public FoodServiceImple() throws RemoteException {
        foodBO= (FoodBO) BoFactory.getInstance().getBO(BoFactory.BOTypes.FOOD);
    }

    @Override
    public ArrayList<FoodDTO> loardFoodIds() throws Exception {
        ArrayList<FoodDTO> allFooodIds = foodBO.getAllFooodIds();
        return allFooodIds;
    }
}
