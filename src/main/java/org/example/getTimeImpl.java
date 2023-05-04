package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class getTimeImpl extends UnicastRemoteObject implements getTime {
    protected getTimeImpl() throws RemoteException {
    }

    public long getTime() throws RemoteException {
        return System.nanoTime();
    }
}
