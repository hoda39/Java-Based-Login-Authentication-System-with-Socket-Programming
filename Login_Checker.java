/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login_checker;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/**
 *
 * @author Hoda
 */
public class Login_Checker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int PortNum = 9090;
        int counter = 0;
        String userName, password;
        try {
            ServerSocket server = new ServerSocket(PortNum);
            System.out.println("Waiting for client on port " + server.getLocalPort() + "...");
            Client1 clientFrame = new Client1();
            Client1.main(args);
            while (true) {
                counter++;
                Socket serverClient = server.accept();
                System.out.println("Just connected to " + serverClient.getRemoteSocketAddress());
                System.out.println(" >> " + "Client No:" + counter + " started!");
                userName = "hoda mohamed";
                password = "sec4_33243093";
               
                Thread t = new Thread(new Server(serverClient, counter, userName, password));
         
                t.start();
 
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    }
    