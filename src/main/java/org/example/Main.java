package org.example;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

//import Server.Server;
public class Main {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException, NotBoundException {
        final int port = 9999;
        Server server = new Server(port);
        Client client = new Client(port);
        client.connect();
        //        MyServices server = new MyServices(9999);
    }
}