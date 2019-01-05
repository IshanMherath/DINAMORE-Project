package lk.ijse.gdse.cliant.queueHandler;

import lk.ijse.gdse.commen.dto.QueueDTO;
import lk.ijse.gdse.commen.queue.Queue;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class QueueHandler {
    public boolean setOrder(QueueDTO dto) {
        try {
            Queue queue = (Queue) Naming.lookup("rmi://localhost:5050/queue");
            queue.addNewOrder(dto);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public QueueDTO getOrder(){
        QueueDTO dto=new QueueDTO();

        try {
            Queue queue = (Queue) Naming.lookup("rmi://localhost:5050/queue");
            QueueDTO dto1=queue.getOrder();
            dto=dto1;
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
        if (dto!=null){
            return dto;
        }else {
            return null;
        }
    }
    public boolean removeOrder(){
        try {
            Queue queue = (Queue) Naming.lookup("rmi://localhost:5050/queue");
            queue.remove();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
