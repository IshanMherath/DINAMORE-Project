package lk.ijse.gdse.cliant.proxy;

import lk.ijse.gdse.commen.cm_custome.*;
import lk.ijse.gdse.commen.cm_service.SaviceFactory;
import lk.ijse.gdse.commen.cm_service.SuperSarvice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProxyHandler implements SaviceFactory {
    private static ProxyHandler proxyHandler;
    private  SaviceFactory serviceFactory;
    private CustomerSavice customerSavice;
    private OrderQueSavice orderQueSavice;
    private DeliverSavice deliverSavice;
    private ReceptionistService receptionistService;
    private CheffService cheffService;
    private FoodSavice foodSavice;
    public ProxyHandler() {
        try {
            serviceFactory = (SaviceFactory) Naming.lookup("rmi://localhost:5050/dinermore");
            customerSavice = (CustomerSavice) serviceFactory.getSarvice(SaviceTypes.CUSTOMER);
            orderQueSavice = (OrderQueSavice) serviceFactory.getSarvice(SaviceTypes.QUEUE);
            deliverSavice= (DeliverSavice) serviceFactory.getSarvice(SaviceTypes.DELIVER);
            receptionistService= (ReceptionistService) serviceFactory.getSarvice(SaviceTypes.RECEPTIONIST);
            cheffService= (CheffService) serviceFactory.getSarvice(SaviceTypes.CHEFF);
            foodSavice= (FoodSavice) serviceFactory.getSarvice(SaviceTypes.FOOD);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ProxyHandler getIntstance(){
        if(proxyHandler == null){
            proxyHandler=new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperSarvice getSarvice(SaviceTypes types) throws Exception {
        switch (types){
            case CUSTOMER:
                return customerSavice;
            case QUEUE:
                return orderQueSavice;
            case DELIVER:
                return deliverSavice;
            case RECEPTIONIST:
                return receptionistService;
            case CHEFF:
                return cheffService;
            case FOOD:
                return foodSavice;
            default:
                return null;
        }
    }
}

