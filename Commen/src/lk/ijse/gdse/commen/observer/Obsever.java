package lk.ijse.gdse.commen.observer;

import javafx.event.ActionEvent;

import java.rmi.Remote;

public interface Obsever extends Remote {

     void updateObserver() throws Exception;

}
