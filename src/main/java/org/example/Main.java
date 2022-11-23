package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.NotBoundException;

public class Main {

    public static void main(String[] args) throws NotBoundException, IOException {

        RMIClient client = new RMIClient();                         //creates a new RMI client

        client.startClient();                                       //starts the client

        String filePath = "src/main/resources/employees.xml";       //takes the XML file's path

        byte[] bytes = Files.readAllBytes(Paths.get(filePath));     //reads the file and convert it to byte array to send to the server

        client.sendFileToBeProcessed(bytes);                        //sends the file to the server and starts operations

        client.seeStatistics();                                     //calls the statistics method from the server


    }
}