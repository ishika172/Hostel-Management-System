package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
    
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    
    Reception() {
        
        b1 = new JButton("All Student Info");
        b1.setBounds(30,10,150,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Manager Info");
        b2.setBounds(30,60,150,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("All Employee Info");
        b3.setBounds(30,110,150,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.addActionListener(this); 
        add(b3);
        
        b4 = new JButton("Rooms");
        b4.setBounds(30,160,150,30);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b4.addActionListener(this); 
        add(b4);
        
        b5 = new JButton("Update Room");
        b5.setBounds(30,210,150,30);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b5.addActionListener(this); 
        add(b5);
        
        b6 = new JButton("Update Check-In");
        b6.setBounds(30,260,150,30);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b6.addActionListener(this); 
        add(b6);
        
        b7 = new JButton("Search Student");
        b7.setBounds(30,310,150,30);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b7.addActionListener(this); 
        add(b7);
        
        b8 = new JButton("Search Room");
        b8.setBounds(30,360,150,30);
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        b8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b8.addActionListener(this); 
        add(b8);
        
        b9 = new JButton("Search Employee");
        b9.setBounds(30,410,150,30);
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        b9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b9.addActionListener(this); 
        add(b9);
        
        b10 = new JButton("Back");
        b10.setBounds(30,460,150,30);
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        b10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b10.addActionListener(this); 
        add(b10);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/reception1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(510,480,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(200,10,510,480);
        add(l1);
        
        getContentPane().setBackground(Color.white);
        
        setBounds(330,115,750,550);
        setLayout(null);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            new AllStudentInfo().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b2) {
            new ManagerInfo().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b3) {
            new AllEmployeeInfo().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b4) {
            new Rooms().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b5) {
            new UpdateRoom().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b6) {
            new UpdateCheckin().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b7) {
            new SearchStudent().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b8) {
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        } else if(ae.getSource() == b9) {
           new SearchStaff().setVisible(true);
           this.setVisible(false);
        } else if(ae.getSource() == b10) {
            setVisible(false);
        }
        
    }
    
    public static void main(String [] args) {
        
        new Reception().setVisible(true);
    }
}
