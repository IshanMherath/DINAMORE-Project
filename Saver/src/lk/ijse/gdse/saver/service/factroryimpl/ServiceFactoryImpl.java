package lk.ijse.gdse.saver.service.factroryimpl;

import lk.ijse.gdse.commen.cm_service.SaviceFactory;
import lk.ijse.gdse.commen.cm_service.SuperSarvice;
import lk.ijse.gdse.saver.service.cm_impl.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceFactoryImpl extends UnicastRemoteObject implements SaviceFactory {
    public static SaviceFactory saviceFactory;
    public ServiceFactoryImpl() throws RemoteException {
    }

    public  static SaviceFactory getInstance() throws RemoteException {
        if(saviceFactory==null){
            saviceFactory=new ServiceFactoryImpl();
        }
        return saviceFactory;
    }
    @Override
    public SuperSarvice getSarvice(SaviceTypes types) throws Exception {
        switch (types){
            case CUSTOMER:
                return new CustomerServiceImpl();
            case CHEFF:
                return new CheffServiceImpl();
            case QUEUE:
                return new OrderQueueSaviceImpl();
            case DELIVER:
                return new DeliverSaviceImpl();
            case RECEPTIONIST:
                return new ReceptionisServicetImpl();
            case FOOD:
                return new FoodServiceImple();
                default:
                    return null;
        }
    }
}
