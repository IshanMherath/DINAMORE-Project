package lk.ijse.gdse.saver.daolayar.dao;


import lk.ijse.gdse.saver.bussiness.bo.SuperBO;
import lk.ijse.gdse.saver.daolayar.impl.*;

public class DAOFactory {
    public enum  BOTypes {
        CUSTOMER,FOOD,PLACEORDER,CHEFF,QUEUE,DELIVER,RECEPTIONIST,ORDER
    }
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        if(daoFactory==null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public SuperDAO getDAO(BOTypes type){
        switch (type){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case FOOD:
                return new FoodDAOImpl();
            case PLACEORDER:
                return new PlaceOrderDAOImpl();
            case CHEFF:
                return new CheffDAOImpl();
            case QUEUE:
                return new OrderQueueDAOImpl();
            case DELIVER:
                return new DeliverDAOImpl();
            case RECEPTIONIST:
                return new ReceptionisDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
                default:

                    return null;
        }
    }
}
