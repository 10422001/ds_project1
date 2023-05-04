package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface printItembyProviderIF extends Remote {

    String printItembyProvider(String providerName) throws RemoteException;

}
