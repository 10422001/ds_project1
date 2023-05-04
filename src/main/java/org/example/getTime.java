package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface getTime extends Remote {
    public long getTime() throws RemoteException;
}
