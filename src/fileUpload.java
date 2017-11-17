import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class fileUpload {


    public fileUpload(String completePath, String fileName, String serverIP, int port){

        try {

            System.out.println("In the upload file class");



           Socket fileTransferSocket = new Socket(serverIP, port+1);
           System.out.println("Socket connected to server!");

           File f = new File(completePath);

           FileInputStream fis = new FileInputStream(f);
           OutputStream os = fileTransferSocket.getOutputStream();


           byte buffer[] = new byte[1024];

           int totalsize =(int) f.length();
            int size = 0;
            int sentSize;

           //sending the size of file first
          // os.write(size);

            System.out.println("Sending file to server..");

            JOptionPane.showMessageDialog(null, "Please be patient, sending file to server...", "File sending.", JOptionPane.INFORMATION_MESSAGE);

           while((sentSize= fis.read(buffer)) > 0){
               os.write(buffer);
               size += sentSize;
           }

            fis.close();
            os.close();
            fileTransferSocket.close();

           JOptionPane.showMessageDialog(null, "File upload complete!");


        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Cant upload file.");
        }

    }
}
