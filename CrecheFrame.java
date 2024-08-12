package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import za.ac.tut.child.Child;

/**
 *
 * @author kayte
 */
public class CrecheFrame extends JFrame {
    //panels
    private JPanel namePnl;
    private JPanel genderPnl;
    private JPanel kiddiePnl;
    private JPanel btnsPnl;
    private JPanel displayPnl;
    private JPanel mainPnl;

    //labels
    private JLabel nameLbl;
    private JLabel genderLbl;
    
    //textfields
    private JTextField nameTxtFld;
    
    //radio buttons
    private JRadioButton maleRadBtn;
    private JRadioButton femaleRadBtn;
    
    //button group
    private ButtonGroup btnsGrp;
    
    //text area
    private JTextArea displayTxtArea;
    
    //scroll pane
    private JScrollPane scrollableTxtArea;
    
    //buttons
    private JButton registerBtn;
    private JButton displayBtn;
    
    //list
    private ArrayList<Child> kids;
    
    public CrecheFrame() {
        // create frame
        setTitle("CRECHE 4 YOUR KIDDIE");
        setSize(650, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        JFrame.setDefaultLookAndFeelDecorated(true);
        
        //create list
        kids = new ArrayList<>();
        
        //create panels
        kiddiePnl = new JPanel(new GridLayout(2,1,1,1));
        
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        displayPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        mainPnl = new JPanel(new BorderLayout());
        
        //create labels
        nameLbl = new JLabel("Name: ");
        genderLbl = new JLabel("Gender: ");
        
        //create textfields
        nameTxtFld = new JTextField(10);
        
        //create radio buttons
        maleRadBtn = new JRadioButton("Male");
        femaleRadBtn = new JRadioButton("Female");
        
        //create button group
        btnsGrp = new ButtonGroup();
        btnsGrp.add(maleRadBtn);
        btnsGrp.add(femaleRadBtn);
        
        //create display area
        displayTxtArea = new JTextArea(20, 40);
        displayTxtArea.setBorder(new LineBorder(Color.BLUE, 1));
        displayTxtArea.setEditable(false);
        
        scrollableTxtArea = new JScrollPane(displayTxtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //create buttons
        registerBtn = new JButton("Register kiddie");
        registerBtn.addActionListener(new RegisterKiddieBtnListener());
        
        displayBtn = new JButton("Display kiddies");
        displayBtn.addActionListener(new DisplayKiddiesBtnListener());
        
        //add componets to panels
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        
        genderPnl.add(genderLbl);
        genderPnl.add(maleRadBtn);
        genderPnl.add(femaleRadBtn);
        
        btnsPnl.add(registerBtn);
        btnsPnl.add(displayBtn);
        
        kiddiePnl.add(namePnl);
        kiddiePnl.add(genderPnl);
        
        displayPnl.add(scrollableTxtArea);
        
        mainPnl.add(kiddiePnl, BorderLayout.NORTH);
        mainPnl.add(btnsPnl, BorderLayout.CENTER);
        mainPnl.add(displayPnl, BorderLayout.SOUTH);
        
        add(mainPnl);
        
        pack();
        setVisible(true);
    }
    
    private class RegisterKiddieBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //read data
            String name = nameTxtFld.getText();
            String gender = "female";
            
            if(maleRadBtn.isSelected())
            {
                gender = "male";
            }
            
            //create a child
            Child child = new Child(name, gender);
            
            //add child to list
            kids.add(child);
            
            nameTxtFld.setText("");
            btnsGrp.clearSelection();
        }
    }
    
    private class DisplayKiddiesBtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            displayTxtArea.setText("");
            
            for (Child kid : kids) {
                displayTxtArea.append("Name: " + kid.getName() + ", Gender: " + kid.getGender() + "\n");
            }
        }
    }
}
