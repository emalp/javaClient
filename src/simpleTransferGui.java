import java.io.*;
import java.net.*;
import java.util.*;

public class simpleTransferGui {

    final int PORT = 2000;
    String serverIP;
    Socket s;
    BufferedReader br;
    String message;
    PrintWriter writer;

    ArrayList<String> fileNames = new ArrayList<String>();

    boolean currentState;
    boolean a;

    public simpleTransferGui(String server){

        this.serverIP = server;
        try {
            s = new Socket(serverIP, PORT);
            if(s.isConnected()){
                currentState = true;

            }else{
                currentState = false;
                System.exit(1);
            }

            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            writer = new PrintWriter(s.getOutputStream(), true);

        }
        catch (Exception ex){
            System.out.println("Could not send message");
            System.out.println(ex.getMessage());
        }
    }


    public void iniCredGui(String uname, String paswd){
        try {
            writer.println(uname);
            writer.println(paswd);

            String out = br.readLine();

            a = out.equals("accept");

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }



    public String[] lsCommand(){

        writer.println("ls");
        readLs();
        String list[] = {};

        list = fileNames.toArray(new String[fileNames.size()]);

        fileNames.clear();

        for(String b:list){
            System.out.println("Listing files INTERNAL:: "+ b);
        }

        return list;
    }


    public void readLs(){
        try {

            while(!(message  = br.readLine()).equals("null")){
                    System.out.println(message);
                    fileNames.add(message);
            }
            //  s.close(); Still works
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());

        }
    }

    public String pwdCommand(){

        String fileName = "";
        writer.println("pwd");
        try {

            while(!(message  = br.readLine()).equals("null")){
                System.out.println(message);
                fileName = message;
            }
            //  s.close(); Still works
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());

        }

        return fileName;
    }

    public void exitCommand(){
        writer.println("end");

    }

    public void switchuserCommand(){
        writer.println("switch");
    }


    public void uploadCommand(String path, String fileName){

        writer.println("upload "+ fileName);
        fileUpload upload = new fileUpload(path, fileName, serverIP, PORT);

    }

    public void downloadCommand(String fileName){
        writer.println("download "+ fileName);
        fileDownload download = new fileDownload(fileName, serverIP, PORT);

    }

}
