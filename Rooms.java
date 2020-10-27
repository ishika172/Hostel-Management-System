package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1, b2;
    
    Rooms() {
        
        t1 = new JTable();
        t1.setBounds(5,30,520,300);
        add(t1);
        
        b1 = new JButton("Show Data");
        b1.setBounds(260,360,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(110,360,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/room1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(440,390,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(530,10,440,390);
        add(l1);
        
        JLabel l2 = new JLabel("Room No.");
        l2.setBounds(40,15,70,15);
        add(l2);
        
        JLabel l3 = new JLabel("Availability");
        l3.setBounds(170,15,90,15);
        add(l3);
        
        JLabel l4 = new JLabel("Status");
        l4.setBounds(310,15,70,15);
        add(l4);
        
        JLabel l5 = new JLabel("Room Type");
        l5.setBounds(430,15,70,15);
        add(l5);
        
        getContentPane().setBackground(Color.white);
        
        setBounds(230,140,1000,460);
        setLayout(null);
        setVisible(true);       
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            
            try {
                conn c = new conn();
                String str = "Select * from addroom";
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else if(ae.getSource() == b2) {
            new Reception().setVisible(true);
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Rooms();
    }
}
