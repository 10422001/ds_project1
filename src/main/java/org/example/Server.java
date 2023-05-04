package org.example;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

//public class server extends UnicastRemoteObject implements Adder{
public class Server extends UnicastRemoteObject {

    protected Server(int port) throws RemoteException, AlreadyBoundException {
        super(port);
//        Services services = new Services();
        Registry reg = LocateRegistry.createRegistry(port);
//        reg.bind("getTime", new getTimeImpl());
        reg.bind("MyServices", new MyServices());
//        reg.bind("getZonedDataTime", new getZonedDataTimeImpl());
//        reg.bind("putString", new putStringImpl());
//        reg.bind("getProviderDB", new MyServices().printItembyProvider());
    }
}




//    public static void main(String[] args) throws RemoteException {
////        Server server = new Server();
////    public void main() {
////        Registry reg = null;
////        try {
////            reg = LocateRegistry.createRegistry(4444);
////            reg.bind("AddService", new AdderImpl());
////            System.out.println("Server is ready....");
////        } catch (RemoteException e) {
////            throw new RuntimeException(e);
////        } catch (AlreadyBoundException e) {
////            reg.rebind("AddService", new AdderImpl());
////        }
//
////        System.out.println("stopped?");
//    }
