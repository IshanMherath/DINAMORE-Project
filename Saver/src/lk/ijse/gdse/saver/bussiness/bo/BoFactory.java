package lk.ijse.gdse.saver.bussiness.bo;


import lk.ijse.gdse.saver.bussiness.impl.*;

public class BoFactory {
    public enum  BOTypes {
        CUSTOMER,FOOD,PLACEORDER,QUEUE,DELIVER,RECEPTIONIST,CHEFF
    }
    private static BoFactory boFactory;

    private BoFactory(){

    }

    public static BoFactory getInstance(){
        if(boFactory==null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }
    public SuperBO getBO(BOTypes type){

   switch (type){
       case CUSTOMER:
                return new CustomerBOImpl();
       case FOOD:
           return new FoodBOImpl();
       case QUEUE:
           return new OrderQueueBOImpl();
       case DELIVER:
           return new DeliverBOImpl();
       case RECEPTIONIST:
           return new ReceptionisBOImpl();
       case CHEFF:
           return new CheffBOImpl();
        default:
            return null;
        }
    }
}
