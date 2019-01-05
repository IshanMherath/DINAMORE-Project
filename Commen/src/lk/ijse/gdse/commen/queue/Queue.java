package lk.ijse.gdse.commen.queue;

import lk.ijse.gdse.commen.dto.QueueDTO;

import java.rmi.Remote;

public interface Queue extends Remote {
    void addNewOrder(QueueDTO dto)throws Exception;

    QueueDTO getOrder()throws Exception;

    public void remove()throws Exception;
}
