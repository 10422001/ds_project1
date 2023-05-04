package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class getZonedDataTimeImpl extends UnicastRemoteObject implements getZonedDataTime {
    protected getZonedDataTimeImpl() throws RemoteException {
    }
@Override
    public ZonedDateTime getZonedDateTime(String zonedTime) throws RemoteException {
//        n Get current Zoned Date Time of a particular zoned time
        return ZonedDateTime.now(ZoneId.of(zonedTime));
    }


}