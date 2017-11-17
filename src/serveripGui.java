import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class serveripGui extends JFrame implements ActionListener {

    JTextField ipField;
    JLabel ipLabel;
    JButton setIpbtn;
    Font f;
   JPanel panel;
    BorderLayout bl;

    ImageIcon favicon = new ImageIcon(getClass().getResource("home.png"));

    static simpleTransferGui stg;

    public serveripGui(){
        super("Enter server IP");
        this.setSize(400,270);
        //this.setVisible(true);
        this.setIconImage(favicon.getImage());
        this.setResizable(false);
        bl = new BorderLayout();
        this.setLayout(bl);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(250, 200);

        f= new Font("Calibri", Font.PLAIN,22);
        ipField = new JTextField("localhost",15);
        ipLabel = new JLabel("Server IP: ");
        ipField.setFont(f);
        ipLabel.setFont(f);

        panel = new JPanel();
        setIpbtn = new JButton("Set Server IP");
        setIpbtn.setPreferredSize(new Dimension(150,150));
        setIpbtn.addActionListener(this);

        panel.add(ipLabel);
        panel.add(ipField);


        this.add(panel, bl.NORTH);
        this.add(setIpbtn, bl.SOUTH);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent event){

        String ip;

        if(event.getActionCommand().equals("Set Server IP")){

            ip = ipField.getText();

            if(!(ip.equals(""))) {
                stg = new simpleTransferGui(ip);
                if(stg.currentState == true){
                    loginGui login = new loginGui();
                    this.setVisible(false);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "No server at this IP!, try again.");
                }

            }
            else{
                JOptionPane.showMessageDialog(null, "You can't enter null IP");
            }

        }
    }
}
