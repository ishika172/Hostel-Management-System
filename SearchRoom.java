package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
    
    JComboBox c1;
    JCheckBox c2;
    JTable t1;
    JButton b1,b2;
      
      SearchRoom() {
      
          JLabel l1 = new JLabel("Search For Rooms");
          l1.setBounds(270,20,300,40);
          l1.setForeground(Color.blue);
          l1.setFont(new Font("Tahoma", Font.BOLD,25));
          add(l1);
          
          JLabel l2 = new JLabel("Room Type");
          l2.setBounds(100,100,100,30);
          add(l2);
          
          c1 = new JComboBox(new String[] {"Single","Double Sharing","Triple Sharing"});
          c1.setBounds(200,100,150,25);
          c1.setBackground(Color.white);
          add(c1);
          
          c2 = new JCheckBox("Display only Available");
          c2.setBounds(500,100,150,30);
          c2.setBackground(Color.white);
          add(c2);
          
          t1 = new JTable();
          t1.setBounds(5,180,775,210);
          add(t1);
          
          b1 = new JButton("Search");
          b1.setBounds(410,430,100,30);
          b1.setBackground(Color.BLACK);
          b1.setForeground(Color.white);
          b1.addActionListener(this);
          add(b1);
          
          b2 = new JButton("Back");
          b2.setBounds(240,430,100,30);
          b2.setBackground(Color.BLACK);
          b2.setForeground(Color.white);
          b2.addActionListener(this);
          add(b2);
          
          JLabel l3 = new JLabel("Room Number");
          l3.setBounds(60,160,150,20);
          add(l3);
          
          JLabel l4 = new JLabel("Availability");
          l4.setBounds(260,160,150,20);
          add(l4);
          
          JLabel l5 = new JLabel("Room Status");
          l5.setBounds(450,160,150,20);
          add(l5);
          
          JLabel l6 = new JLabel("Room Type");
          l6.setBounds(650,160,150,20);
          add(l6);
          
          getContentPane().setBackground(Color.white);
          
          setLayout(null);
          setVisible(true);
          setBounds(300,130,800,530);
              
      }
      
      public void actionPerformed(ActionEvent ae) {
         
          if(ae.getSource()== b1){
             
              try {
                 String type = (String)c1.getSelectedItem();
                 
                 String str = "select * from addroom where type = '"+type+"'";
                 String str2 = "select * from addroom where available = 'Available' AND type = '"+type+"'";
                 
                 conn c = new conn();
                 
                 ResultSet rs;
                 if(c2.isSelected()) {
                   rs = c.s.executeQuery(str2);
                   t1.setModel(DbUtils.resultSetToTableModel(rs));
                 } else {
                    rs = c.s.executeQuery(str);
                 t1.setModel(DbUtils.resultSetToTableModel(rs));
                 }
              } catch(Exception e) {}
              
          } else if(ae.getSource()== b2) {
             new Reception().setVisible(true);
             this.setVisible(false);
          }
      }
      
      public static void main (String[] args) {
            new SearchRoom();   
      }
    
}
