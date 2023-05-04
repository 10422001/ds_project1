package org.example;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.TimeZone;

public class Client {
    int port;

    Registry reg;
    Remote remote;
    getTime getTime;
    getZonedDataTime getZonedDataTime;
    putString putString;

    printItembyProviderIF printItembyProvider;

    public Client(int port) {
        this.port = port;
    }

    public void connect() throws RemoteException, NotBoundException {
        this.reg = LocateRegistry.getRegistry(this.port);
        String[] id = TimeZone.getAvailableIDs();


        this.remote = reg.lookup("MyServices");
        this.getTime = (getTime) remote;
        this.getZonedDataTime = (getZonedDataTime) remote;
        this.putString = (putString) remote;
        this.putString.putString("Hello World");
        System.out.println("Server Time: " + getTime.getTime());
        System.out.println("Local Time:  " + System.nanoTime());
//        System.out.println(id[0]);
        System.out.println(this.getZonedDataTime.getZonedDateTime(id[0]));
//        System.out.println(this.getZonedDataTime.getZonedDateTime("Asia/Ho Chi Minh"));
        this.printItembyProvider = (printItembyProviderIF) remote;
        printItembyProvider.printItembyProvider("A&E INC");

    }
}
