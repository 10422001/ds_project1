package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface putString extends Remote {
    public void putString(String message) throws RemoteException;
}
