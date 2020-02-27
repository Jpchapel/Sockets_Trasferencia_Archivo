/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class Lector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        Socket socket = null;
        try {
            serverSocket = new ServerSocket();

            InetSocketAddress address = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(address);

            socket = serverSocket.accept();
            System.out.println("Conexion establecida");

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String linea = bufferedReader.readLine();

            while (linea != null) {
                System.out.println(linea);
            }
            
            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

}
