package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class putStringImpl extends UnicastRemoteObject implements putString {
    protected putStringImpl() throws RemoteException {
    }

    public void putString(String message) throws RemoteException {
        System.out.println(message);
    }}
