package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.ZonedDateTime;

public interface getZonedDataTime extends Remote {

    public ZonedDateTime getZonedDateTime(String zonedTime) throws RemoteException;

}
