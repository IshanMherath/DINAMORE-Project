package lk.ijse.gdse.commen.observer;

import java.rmi.Remote;

public interface Subject extends Remote {
    public void registerObserver(Obsever observer) throws Exception;

    public void unregisterObserver(Obsever observer) throws Exception;

    public void notifyObservers() throws Exception;

}
