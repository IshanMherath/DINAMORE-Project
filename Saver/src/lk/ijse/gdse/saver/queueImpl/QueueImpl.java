package lk.ijse.gdse.saver.queueImpl;

import lk.ijse.gdse.commen.dto.QueueDTO;
import lk.ijse.gdse.commen.queue.Queue;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class QueueImpl extends UnicastRemoteObject implements Queue {
    public QueueImpl() throws RemoteException {
    }

    @Override
    public void addNewOrder(QueueDTO dto) throws Exception {

    }

    @Override
    public QueueDTO getOrder() throws Exception {
        return null;
    }

    @Override
    public void remove() throws Exception {

    }
}
