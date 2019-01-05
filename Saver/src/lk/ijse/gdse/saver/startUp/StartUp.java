package lk.ijse.gdse.saver.startUp;

import lk.ijse.gdse.saver.queueImpl.QueueImpl;
import lk.ijse.gdse.saver.service.factroryimpl.ServiceFactoryImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartUp {
    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.rebind("dinermore", ServiceFactoryImpl.getInstance());
            registry.rebind("queue", new QueueImpl());
            System.out.println("Server is Running Successfully...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
