package org.example;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    private RMIServer server;

    public RMIClient(){

    }

    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);  //creates a registry on the same port as the server

        server = (RMIServer) registry.lookup("Server");                         //looks up the server name and assigns it to the RMI server
    }

    public void sendFileToBeProcessed(byte[] byteArr) throws IOException {
        server.parseXMLandWriteToDatabase(byteArr);                                   //sends the XML file to the server as a byte array
    }

    public void seeStatistics() throws RemoteException {
        server.getNumberOfOperationsAndStatusInformation();                           //calls the statistics method from the server
    }
}
