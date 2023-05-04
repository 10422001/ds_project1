package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class Services extends UnicastRemoteObject {
//    protected Services(int port) throws RemoteException {
//        super(port);
//    }
public class MyServices extends UnicastRemoteObject implements Remote, getTime, putString, getZonedDataTime , printItembyProviderIF
{

    protected MyServices() throws RemoteException {
    }

    public long getTime() throws RemoteException {
        return System.nanoTime();
    }
    public void putString(String message) throws RemoteException {
        System.out.println(message);
    }

    public ZonedDateTime getZonedDateTime(String zonedTime) throws RemoteException {
//        n Get current Zoned Date Time of a particular zoned time
                return ZonedDateTime.now(ZoneId.of(zonedTime));
    }

    //connect to Postres database
    @Override
    public String printItembyProvider(String providerName) throws RemoteException {
        final String url = "jdbc:postgresql://localhost:5432/";
        final String user = "postgres";
//        final String password = "<add your password>";
        final String password = System.getenv("DB_PASSWORD");
        try {
            Connection conn = connect(url, user, password);
            return getItemsDB(conn, providerName);
        } catch (Exception e) {
//            e.printStackTrace();
            return "Failed to connect to the PostgreSQL server.";
        }
//        Connection conn = connect(url, user, password);
//        return getItemsDB(conn, providerName);
    }
    private Connection connect(String url, String user, String password){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to connect to the PostgreSQL server.");
        }

        return conn;
    }
    private String getItemsDB(Connection connection, String providerName) throws RemoteException {
        String sql = "SELECT * FROM \"Retail Sales\" WHERE supplier = \'"+providerName+"\'";
//        String sql = "SELECT * FROM \"Retail Sales\" WHERE supplier = \'DOPS INC\'";
        System.out.println("List of items from provider: "+providerName);
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            Map<String, List<String>> valueMap = new HashMap<>();
            Map<String, List<String>> valueMapId = new HashMap<>();

            while (rs.next()) {
                System.out.println(
                        rs.getString("year") + "\t" +
                        rs.getString("month") + "\t" +
                        rs.getString("supplier") + "\t" +
                        rs.getString("item_code") + "\t" +
                        rs.getString("item_type") + "\t" +
                        rs.getString("retail_sales") + "\t" +
                        rs.getString("retail_transfer") + "\t" +
                        rs.getString("warehouse_sales")  + "\t" +
                        rs.getString("item_description")

                );



            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        System.out.println("Listed of items from provider: "+providerName);

        return null;
    }

    public static void main(String[] args) throws RemoteException {
        MyServices myServices = new MyServices();
        System.out.println(myServices.printItembyProvider("DOPS INC"));

    }
}



