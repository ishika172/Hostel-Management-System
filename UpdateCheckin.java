package hostel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheckin extends JFrame implements ActionListener {
    
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    
    UpdateCheckin() {
    
       JLabel l1 = new JLabel("Update Check-In");
       l1.setBounds(50,10,250,30);
       l1.setFont(new Font("Tahoma", Font.BOLD,25));
       l1.setForeground(Color.blue);
       add(l1);
       
       JLabel l2 = new JLabel("Student ID");
       l2.setBounds(20,80,100,30);
       add(l2);
        
        c1 = new Choice();
        try{
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from addstudent");
           
           while(rs.next()) {
              c1.add(rs.getString("aadhar"));
           }
        } catch(Exception e){}
        c1.setBackground(Color.white);
        c1.setBounds(150,80,150,30);
        add(c1);
        
        JLabel l3 = new JLabel("Student Name");
        l3.setBounds(20,130,100,30);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(150,130,150,30);
        add(t1);
        
        JLabel l4=new JLabel("Room Number");
        l4.setBounds(20,180,100,30);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(150,180,150,30);
        add(t2);
        
        JLabel l5=new JLabel("Fees");
        l5.setBounds(20,230,100,30);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(150,230,150,30);
        add(t3);
        
        JLabel l6=new JLabel("Amount Paid");
        l6.setBounds(20,280,100,30);
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(150,280,150,30);
        add(t4);
        
        JLabel l7=new JLabel("Pending");
        l7.setBounds(20,330,100,30);
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(150,330,150,30);
        add(t5);
       
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/check.jpg"));
        Image i5 = i4.getImage().getScaledInstance(25,23,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b1 = new JButton(i6);
        b1.setBounds(310,80,25,23);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(170,400,100,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Cancel");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(40,400,100,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/checkin.jpg"));
        Image i2 = i1.getImage().getScaledInstance(370,370,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8 = new JLabel(i3);
        l8.setBounds(350,60,370,370);
        add(l8);
        
       getContentPane().setBackground(Color.white);
       setLayout(null);
       setBounds(310,130,750,490);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
      
        if(ae.getSource()== b1) {
            
           String room=null;
           String paid=null;
           int pending;
           String fees=null;
           
           String s1 = c1.getSelectedItem();
           conn c = new conn();
           
           try{
              ResultSet rs = c.s.executeQuery("select * from addstudent where aadhar = '"+s1+"'");
              while(rs.next()){
                 t1.setText(rs.getString("name"));
                 t2.setText(rs.getString("room"));
                 t3.setText(rs.getString("fees"));
                 t4.setText(rs.getString("paid"));
                 
                 room = rs.getString("room");
                 paid = rs.getString("paid");
                 fees = rs.getString("fees");
                 
                 pending = Integer.parseInt(fees)- Integer.parseInt(paid);
                 
                 t5.setText(Integer.toString(pending));
              }
           } catch(Exception e) {System.out.println(e);}
        } else if(ae.getSource()== b2) {
            try {
              conn c = new conn();
               String s1 = c1.getSelectedItem();
               
                 String name = t1.getText();
                 String room = t2.getText();
                 String fees = t3.getText();
                 String paid = t4.getText();
                 String pending = t5.getText();
               
               String str = "update addstudent set name = '"+name+"', room = '"+room+"', fees = '"+fees+"', paid = '"+paid+"', pending = '"+pending+"' where aadhar = '"+s1+"'";
               c.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"Information Updated successfully!");
               new Reception().setVisible(true);
               this.setVisible(false);
            } catch(Exception e) {System.out.println(e);}
        } else if(ae.getSource()== b3) {
             new Reception().setVisible(true);
             this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateCheckin();
    }


}
