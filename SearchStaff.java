package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchStaff extends JFrame implements ActionListener {
    
    JComboBox c1;
    JCheckBox c2;
    JTable t1;
    JButton b1,b2;
      
    SearchStaff() {
    
          JLabel l1 = new JLabel("Search For Staff");
          l1.setBounds(340,20,300,40);
          l1.setForeground(Color.blue);
          l1.setFont(new Font("Tahoma", Font.BOLD,25));
          add(l1);
          
          JLabel l2 = new JLabel("Job");
          l2.setBounds(100,100,100,30);
          add(l2);
          
          String str[] = {"Manager", "Warden", "House Keeping", "Kitchen Staff", "Chef", "Security Guard", "Driver"};
          c1 = new JComboBox(str);
          c1.setBounds(170,100,150,25);
          c1.setBackground(Color.white);
          add(c1);
          
          c2 = new JCheckBox("Display only Male");
          c2.setBounds(550,100,200,30);
          c2.setBackground(Color.white);
          add(c2);
          
          t1 = new JTable();
          t1.setBounds(5,180,875,210);
          add(t1);
          
          JLabel l3 = new JLabel("Name");
          l3.setBounds(40,155,100,30);
          add(l3);
          
          JLabel l4 = new JLabel("Age");
          l4.setBounds(155,155,100,30);
          add(l4);
          
          JLabel l5 = new JLabel("Gender");
          l5.setBounds(260,155,100,30);
          add(l5);
          
          JLabel l6 = new JLabel("Job");
          l6.setBounds(370,155,100,30);
          add(l6);
          
          JLabel l7 = new JLabel("Salary");
          l7.setBounds(480,155,100,30);
          add(l7);
          
          JLabel l8 = new JLabel("Phone");
          l8.setBounds(580,155,100,30);
          add(l8);
          
          JLabel l9 = new JLabel("Aadhar No.");
          l9.setBounds(680,155,100,30);
          add(l9);
          
          JLabel l10 = new JLabel("Email");
          l10.setBounds(800,155,100,30);
          add(l10);
        
          b1 = new JButton("Search");
          b1.setBounds(480,430,100,30);
          b1.setBackground(Color.BLACK);
          b1.setForeground(Color.white);
          b1.addActionListener(this);
          add(b1);
          
          b2 = new JButton("Back");
          b2.setBounds(300,430,100,30);
          b2.setBackground(Color.BLACK);
          b2.setForeground(Color.white);
          b2.addActionListener(this);
          add(b2);
          
        getContentPane().setBackground(Color.white);
         setLayout(null);
         setVisible(true);
         setBounds(250,130,900,530);
    }
    
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()== b1){
             
              try {
                 String job = (String)c1.getSelectedItem();           
                 String str = "select * from addemployee where job = '"+job+"'";
                 String str2 = "select * from addemployee where gender = 'Male' AND job = '"+job+"'";
                 
                 conn c = new conn();      
                 ResultSet rs;
                 if(c2.isSelected()) {
                   rs = c.s.executeQuery(str2);
                   t1.setModel(DbUtils.resultSetToTableModel(rs));
                 } else {
                    rs = c.s.executeQuery(str);
                    t1.setModel(DbUtils.resultSetToTableModel(rs));
                 }
              } catch(Exception e) {System.out.println(e);}
              
          } else if(ae.getSource()== b2) {
             new Reception().setVisible(true);
             this.setVisible(false);
          }
     }
     
     public static void main(String[] args) {
        new SearchStaff();
     }
}
