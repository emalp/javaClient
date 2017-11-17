import javax.swing.*;
import java.io.*;
import java.net.*;

public class fileDownload {
    public fileDownload( String fileName, String serverIP, int port){

        try {

            System.out.println("In the Download file class");


            Socket fileTransferSocket = new Socket(serverIP, port+1);
            System.out.println("Socket connected to server!");

            File f = new File(fileName);

            FileOutputStream fos = new FileOutputStream(f);
            InputStream is = fileTransferSocket.getInputStream();


            byte buffer[] = new byte[1024];

            //sending the size of file first
            // os.write(size);

            System.out.println("Downloading file from server..");

            JOptionPane.showMessageDialog(null, "Please be patient, downloading file from server...", "File downloading.", JOptionPane.INFORMATION_MESSAGE);

            while(is.read(buffer) > 0){
                fos.write(buffer);
            }

            is.close();
            fos.close();
            fileTransferSocket.close();

            JOptionPane.showMessageDialog(null, "File Download complete!");


        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Cant Download file.");
        }

    }
}
