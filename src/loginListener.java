import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class loginListener implements ActionListener {


    String username;
    String password;
    String serverIp;

   loginGui lg;


   loginListener(loginGui lg){
       this.lg = lg;
   }

    @Override
    public void actionPerformed(ActionEvent event){



        if (event.getActionCommand().equals("Exit")) {

            //JOptionPane.showMessageDialog(null, "Exit selected");
            lg.setVisible(false);
            lg.dispose();

        }

        else if((event.getActionCommand().equals("Login"))){

            username = lg.unameField.getText();
            password = String.valueOf(lg.pswdField.getPassword());
            //serverIp = lg.serverIp.getText();


            serveripGui.stg.iniCredGui(username, password);

            if(serveripGui.stg.a){

                mainGui main = new mainGui();
                lg.setVisible(false);
                lg.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Username or Password incorrect.");

            }
            //JOptionPane.showMessageDialog(null, "LOgin button selected");


        }

    }
}
