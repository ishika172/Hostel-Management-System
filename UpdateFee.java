package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateFee extends JFrame implements ActionListener {
    
     Choice c1;
     JTextField t1;
     JButton b1,b2,b3;
    
     UpdateFee() {
     
        JLabel l1 = new JLabel("Update Fees");
        l1.setFont(new Font("Tahoma", Font.BOLD,25));
        l1.setForeground(Color.blue);
        l1.setBounds(100,10,250,30);
        add(l1); 
        
        JLabel l2 = new JLabel("Room Type");
        l2.setBounds(40,100,80,30);
        add(l2);
        
        c1= new Choice();
        try{
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from hostelfees");
           
           while(rs.next()) {
              c1.add(rs.getString("type"));
           }
        }catch(Exception e){}
        
        c1.setBackground(Color.white);
        c1.setBounds(130,100,150,30);
        add(c1);
        
        JLabel l3 = new JLabel("Fees");
        l3.setBounds(40,160,80,30);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(130,160,150,30);
        add(t1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/fees.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(250,280,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(320,10,250,280);
        add(l4);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/check.jpg"));
        Image i5 = i4.getImage().getScaledInstance(25,23,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b1 = new JButton(i6);
        b1.setBounds(290,100,25,23);
        b1.addActionListener(this);
        add(b1);
          
          b2 = new JButton("Update");
          b2.setBounds(180,250,100,30);
          b2.setBackground(Color.BLACK);
          b2.setForeground(Color.white);
          b2.addActionListener(this);
          add(b2);
          
          b3 = new JButton("Back");
          b3.setBounds(50,250,100,30);
          b3.setBackground(Color.BLACK);
          b3.setForeground(Color.white);
          b3.addActionListener(this);
          add(b3);
          
         getContentPane().setBackground(Color.white);
         setLayout(null);
         setVisible(true);
         setBounds(400,200,600,350);
     }
     
     public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()== b1) {
           String s1 = c1.getSelectedItem();
           conn c = new conn();
           
           try{
              ResultSet rs = c.s.executeQuery("select * from hostelfees where type = '"+s1+"'");
              while(rs.next()){
                 t1.setText(rs.getString("fee"));
              }
           } catch(Exception e) {System.out.println(e);}
        } else if(ae.getSource()== b2) {
            try{
               conn c = new conn();
               String type = c1.getSelectedItem();
               String fee = t1.getText();
               
               String str = "update hostelfees set fee = '"+fee+"' where type = '"+type+"'";
               c.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"Fees updated successfully!");
               this.setVisible(false);
            } catch(Exception e) {System.out.println(e);}
        } else if(ae.getSource()== b3) {
              this.setVisible(false);
        }
     }
     
     public static void main(String[] args) {
          new UpdateFee();
     }
}
