package lk.ijse.gdse.commen.cm_service;

import java.rmi.Remote;

public interface SaviceFactory extends Remote {
    public enum SaviceTypes{
        CUSTOMER,CHEFF,QUEUE,DELIVER,RECEPTIONIST,FOOD
    }
    public  SuperSarvice getSarvice(SaviceTypes types)throws Exception;
}
