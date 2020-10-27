package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class FeeStructure extends JFrame implements ActionListener{
    
    JComboBox c1;
    JTable t1;
    JButton b1,b2;
    
       FeeStructure() {
       
          JLabel l1 = new JLabel("Fees Structure");
          l1.setBounds(200,10,200,30);
          l1.setForeground(Color.blue);
          l1.setFont(new Font("Tahoma", Font.BOLD,25));
          add(l1);
          
          JLabel l2 = new JLabel("Room Type");
          l2.setBounds(130,90,100,30);
          add(l2);
          
          c1 = new JComboBox(new String[] {"Single","Double Sharing","Triple Sharing"});
          c1.setBounds(220,90,150,25);
          c1.setBackground(Color.white);
          add(c1);
          
          t1 = new JTable();
          t1.setBounds(5,170,575,40);
          add(t1);
          
          JLabel l3 = new JLabel("Room Type");
          l3.setBounds(90,150,100,20);
          add(l3);
          
          JLabel l4 = new JLabel("Fees");
          l4.setBounds(450,150,100,20);
          add(l4);
          
          b1 = new JButton("Search");
          b1.setBounds(300,250,100,30);
          b1.setBackground(Color.BLACK);
          b1.setForeground(Color.white);
          b1.addActionListener(this);
          add(b1);
          
          b2 = new JButton("Back");
          b2.setBounds(170,250,100,30);
          b2.setBackground(Color.BLACK);
          b2.setForeground(Color.white);
          b2.addActionListener(this);
          add(b2);
          
         getContentPane().setBackground(Color.white);
         setLayout(null);
         setVisible(true);
         setBounds(400,200,600,350);
       }
       
       public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()== b1){
             
              try {
                 String type = (String)c1.getSelectedItem();
                 
                 String str = "select * from hostelfees where type = '"+type+"'";
                 conn c = new conn();      
                 ResultSet rs = c.s.executeQuery(str);
                 t1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch(Exception e) {}
          } else if(ae.getSource()== b2) {
               this.setVisible(false);
         }
     }    
       public static void main(String[] args) {
            new FeeStructure();
       }
}
