/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emisor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class Emisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Socket socket = new Socket();

        try {
            InetSocketAddress address = new InetSocketAddress("localhost", 5555);
            socket.connect(address);
            
            OutputStream outputStream = socket.getOutputStream();
            
            BufferedReader bufferedReader = new BufferedReader(new FileReader("../fichero.txt"));
            
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            
            while(bufferedReader.ready()){
                String linea = bufferedReader.readLine();
                
                printWriter.println(linea);
            }
            
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Emisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
