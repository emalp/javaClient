/**
 * Created by EMALP on 8/25/2017.
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class simpleTransfer {

    final int PORT = 2000;
    String serverIP;
    Socket s;
    String command = "";
    BufferedReader br;
    String message;
    PrintWriter writer;


    public simpleTransfer(){

        String sip = "localhost";

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the server ip or domain:");
//        sip = scanner.nextLine();
          this.serverIP = sip;

        try {
                s = new Socket(this.serverIP, PORT);
                if(s.isConnected()){
                    System.out.println("Connected to server " + serverIP);
                }else{

                    s = new Socket(this.serverIP, PORT);
                }

                br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                writer = new PrintWriter(s.getOutputStream(), true);

                // The main login screen.
                login();
                //writeMessage();


        }
        catch (Exception ex){
            System.out.println("Could not send message");
            System.out.println(ex.getMessage());
        }
    }

    public void login(){

        System.out.println("** Welcome to EM-Client\n");
        System.out.println("Please login to your account");
        Scanner scan = new Scanner(System.in);
        System.out.println("Username:\t");
        String iniUname = scan.nextLine();
        System.out.println("Password:\n");
        String iniPwd = scan.nextLine();
        iniCred(iniUname, iniPwd);

    }

    public void iniCred(String uname, String paswd){
        try {
            writer.println(uname);
            writer.println(paswd);

            String out = br.readLine();

            boolean a = out.equals("accept");

            if(a){

                System.out.println("Logged in! :)\n");
                writeMessage();
            }
            else{
                System.out.println("Incorrect credentials :(\n ");
                login();
            }

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }


    public void readMessage(){
        try {

            while(!(message  = br.readLine()).equals("null")){
                System.out.println(message);
            }
            writeMessage();
         //  s.close(); Still works
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());

        }
    }

    public void writeMessage(){
        try {

                       System.out.println("EM-SERVER >>\n");
            Scanner scan = new Scanner(System.in);

            command = scan.nextLine();

            if(command.equals("switch")){
                login();
                writer.println(command);
            }

            writer.println(command);

            readMessage();

        }
        catch(Exception excep){
            System.out.println(excep.getMessage());
        }

    }
}
