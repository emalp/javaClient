import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.util.*;

public class mainGui extends JFrame{

    mainGuiListener mainListener = new mainGuiListener(this);

    // Main frame stuff

    ImageIcon favicon = new ImageIcon(getClass().getResource("home.png"));
    BorderLayout mainLayout = new BorderLayout();
    Font mainFont = new Font("Calibri", Font.PLAIN, 17);




// The top layer
    JToolBar topBar;

    ImageIcon refreshicon = new ImageIcon(getClass().getResource("refresh.png"));
    ImageIcon documentationicon = new ImageIcon(getClass().getResource("documentation.png"));
    ImageIcon abouticon = new ImageIcon(getClass().getResource("about.png"));
    ImageIcon exiticon = new ImageIcon(getClass().getResource("exit.png"));
    ImageIcon swithcusericon = new ImageIcon(getClass().getResource("switch.png"));

    JButton RefreshBtn;
    JButton ExitBtn;
    JButton DocumentationBtn;
    JButton AboutBtn;
    JButton switchUserbtn;

    // The second layer
    JLabel fileLocationLabel;

    // Third  layer

    JPanel tmainPanel;
    JPanel btnPanel;

    GridLayout btnlayout;

    JButton downloadBtn;
    JButton uploadBtn;
    JButton viewLocationBtn;

    JList<String> fileList;
    JScrollPane sp;
    JScrollBar sb;
    DefaultListModel<String> listmodel;

    // The last layer



    public mainGui(){

        super("Main Client GUI");
        this.setSize(600,600);
        this.setVisible(true);
        this.setResizable(false);
        this.setIconImage(favicon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500,200);
        this.setLayout(mainLayout);



        // Now making the top toolbar ---------------------------------
        topBar = new JToolBar("mainBar", JToolBar.HORIZONTAL);
        topBar.setRollover(false);
        topBar.setFloatable(false);

        switchUserbtn = new JButton(swithcusericon);
        switchUserbtn.setToolTipText("Switch user");
        switchUserbtn.addActionListener(mainListener);

        RefreshBtn = new JButton(refreshicon);
        RefreshBtn.setToolTipText("Refresh");
        RefreshBtn.addActionListener(mainListener);

        ExitBtn = new JButton(exiticon);
        ExitBtn.setToolTipText("Exit");
        ExitBtn.addActionListener(mainListener);

        DocumentationBtn = new JButton(documentationicon);
        DocumentationBtn.setToolTipText("Documentation");

        AboutBtn = new JButton(abouticon);
        AboutBtn.setToolTipText("About");
        AboutBtn.addActionListener(mainListener);

        topBar.add(RefreshBtn);
        topBar.add(DocumentationBtn);
        topBar.add(switchUserbtn);
        topBar.add(AboutBtn);
        topBar.add(ExitBtn);


        // Now making the main things inside.-------------------------------

        tmainPanel = new JPanel();
        fileLocationLabel = new JLabel("Working in EM-SERVER file sharing location.", JLabel.CENTER);
        fileLocationLabel.setFont(mainFont);

                     // Now making the main list and btns thingy-------------------------------------


         listmodel = new DefaultListModel<String>();
         listmodel.removeAllElements();
                    // i've set simletransergui's object as stg in serveripgui.


        String fileNames[] = serveripGui.stg.lsCommand();

              for(String a: fileNames){
            listmodel.addElement(a);
        }

        fileList = new JList<String>(listmodel);

        fileList.setPreferredSize(new Dimension(400,450));
        fileList.setFont(mainFont);
        sp = new JScrollPane(fileList);
        sb = new JScrollBar();
        sp.add(sb);


            // List made, now making the buttons

        downloadBtn = new JButton("Download File");
        downloadBtn.setFont(mainFont);
        downloadBtn.addActionListener(mainListener);

        uploadBtn = new JButton("Upload File");
        uploadBtn.setFont(mainFont);
        uploadBtn.addActionListener(mainListener);

        viewLocationBtn = new JButton("View Location");
        viewLocationBtn.setFont(mainFont);
        viewLocationBtn.addActionListener(mainListener);

        btnlayout = new GridLayout(3,1);

        btnPanel = new JPanel(btnlayout);

        btnPanel.add(downloadBtn);
        btnPanel.add(uploadBtn);
        btnPanel.add(viewLocationBtn);


        // adding everything to the tmain panel now-------------------------------------
        tmainPanel.add(fileLocationLabel);
        tmainPanel.add(fileList);
        tmainPanel.add(btnPanel);

        // Now the last FREAKING LABEL!!


        // Final SHOWWWW
        this.add(topBar, BorderLayout.NORTH);
        this.add(tmainPanel, BorderLayout.CENTER);
        //this.add(scroller, BorderLayout.SOUTH);


    }
}
