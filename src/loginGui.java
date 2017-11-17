import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;


public class loginGui extends JFrame{

    JButton loginbtn;
    JButton exitbtn;
    JTextField unameField;
    JPasswordField pswdField;
    JTextField ipField;

    JPanel panel11;
    JPanel panel12;
    //JPanel panel13;

    JPanel panel1;
    JPanel panel2;

    BorderLayout bl1;
    BorderLayout mainLayout;
    GridLayout gl;
    FlowLayout fl1;

    Font f;
    //ImageIcon ic = new ImageIcon("Z:\\INtern\\client.jpg");
    ImageIcon ic = new ImageIcon(getClass().getResource("client.jpg"));
    ImageIcon favicon = new ImageIcon(getClass().getResource("home.png"));

    JLabel image;
    loginListener listener = new loginListener(this);

    JLabel Username;
    JLabel Password;
    //JLabel serverIp;

    public loginGui(){
            super("EM-Client Login");
            this.setVisible(true);
            this.setIconImage(favicon.getImage());
            this.setSize(500,500);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLocation(500,250);
            mainLayout = new BorderLayout();
            this.setLayout(mainLayout);

            image = new JLabel(ic);
            f = new Font("Calibri", Font.PLAIN, 25);
            gl = new GridLayout(0,2);
            bl1 = new BorderLayout();
            fl1 = new FlowLayout();

            panel11 = new JPanel();
            panel12 = new JPanel();
      //      panel13 = new JPanel();
            panel1=new JPanel(bl1);
            panel2 = new JPanel(gl);

            unameField = new JTextField("root", 20);
            unameField.setFont(f);
            pswdField = new JPasswordField("toor", 20);
            pswdField.setFont(f);
            ipField = new JTextField("", 20);
            ipField.setFont(f);

            Username = new JLabel("Username: ");
            Password = new JLabel("Password: ");
        //    serverIp = new JLabel("Server IP: ");


            loginbtn = new JButton("Login");
            loginbtn.setPreferredSize(new Dimension(180,200));
            loginbtn.setFont(f);
            loginbtn.addActionListener(listener);

            exitbtn = new JButton("Exit");
            exitbtn.setPreferredSize(new Dimension(180,200));
            exitbtn.setFont(f);
            exitbtn.addActionListener(listener);

            panel11.add(Username);
            panel11.add(unameField);

            panel12.add(Password);
            panel12.add(pswdField);

          //  panel13.add(serverIp);
            //panel13.add(ipField);

            panel1.add(panel11, bl1.NORTH);
            panel1.add(panel12, bl1.CENTER);
           // panel1.add(panel13, bl1.SOUTH);

            panel2.add(loginbtn);
            panel2.add(exitbtn);
//
//            getContentPane().add(panel1, mainLayout.NORTH);
//            getContentPane().add(panel2, mainLayout.SOUTH);
//
            this.add(panel1, mainLayout.NORTH);
            this.add(panel2, mainLayout.SOUTH);
            this.add(image, mainLayout.CENTER);

    }

}
