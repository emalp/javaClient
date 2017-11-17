import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.awt.datatransfer.*;
import java.util.ArrayList;

public class mainGuiListener implements ActionListener{

    mainGui main;


    public mainGuiListener(mainGui mg) {
        this.main = mg;
    }

    public void actionPerformed(ActionEvent eve) {

        Object o = eve.getSource();

        if (o == main.viewLocationBtn) {
            String a = serveripGui.stg.pwdCommand();
            JOptionPane.showMessageDialog(null, a);
        } else if (o == main.RefreshBtn) {

            main.setVisible(false);
            main.dispose();

            main = new mainGui();

        } else if (o == main.AboutBtn) {
            JOptionPane.showMessageDialog(null, "Simple java client which downloads or uploads files to and from server.");

        } else if (o == main.ExitBtn) {
            serveripGui.stg.exitCommand();
            main.setVisible(false);
            main.dispose();

        } else if (o == main.switchUserbtn) {
            serveripGui.stg.switchuserCommand();
            loginGui login = new loginGui();
            main.setVisible(false);
            main.dispose();

        } else if (o == main.uploadBtn) {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Upload to server");
                chooser.setMultiSelectionEnabled(false);

                int val = chooser.showOpenDialog(chooser);

                if (val == JFileChooser.APPROVE_OPTION) {
                        String fileLocation = chooser.getSelectedFile().getAbsolutePath();
                        String fileName = chooser.getSelectedFile().getName();
                        JOptionPane.showMessageDialog(null, "You chose to upload: " + fileLocation);

                    serveripGui.stg.uploadCommand(fileLocation, fileName);
                }


            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No file selected to upload.");
            }

        } else if (o == main.downloadBtn) {

            try {
                String filename = main.fileList.getSelectedValue();
                boolean isFile = false;

                String inistr[] = filename.split("\\s");

                int leng = inistr.length;

                if (inistr[0].equals("FIL")) {
                    isFile = true;
                } else {
                    JOptionPane.showMessageDialog(null, "The selected item is not a file!", "Not FILE", JOptionPane.ERROR_MESSAGE);
                }

                if (isFile) {
                    serveripGui.stg.downloadCommand(inistr[leng - 1]);
                }
            } catch (Exception exdf) {

            }


        }

    }





}
