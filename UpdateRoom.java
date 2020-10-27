package hostel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

  public class UpdateRoom extends JFrame implements ActionListener {
    Choice c1;
    JTextField t1, t2,t3;
    JButton b1, b2, b3;
    
    UpdateRoom() {
        JLabel l1 = new JLabel("Update room status");
        l1.setFont(new Font("Tahoma", Font.BOLD,25));
        l1.setForeground(Color.blue);
        l1.setBounds(50,20,250,30);
        add(l1); 

//        JLabel l2=new JLabel("Student ID");
//        l2.setBounds(20,100,80,30);
//        add(l2);
        

        JLabel l2 = new JLabel("Room Number");
        l2.setBounds(20,100,100,30);
        add(l2);
        
        c1= new Choice();
        try{
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from addroom");
           
           while(rs.next()) {
              c1.add(rs.getString("room"));
           }
        }catch(Exception e){}
        c1.setBackground(Color.white);
        c1.setBounds(150,100,150,30);
        add(c1);
        
        JLabel l3 = new JLabel("Type");
        l3.setBounds(20,150,100,30);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(150,150,150,30);
        add(t1);
        
        JLabel l4=new JLabel("Availability");
        l4.setBounds(20,200,100,30);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(150,200,150,30);
        add(t2);
        
        JLabel l5=new JLabel("Clean Status");
        l5.setBounds(20,250,80,30);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(150,250,150,30);
        add(t3);
        
        b1= new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(110,310,110,30);
        b1.addActionListener(this);
        add(b1);
        
        b2= new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(170,360,110,30);
        b2.addActionListener(this);
        add(b2);
        
        b3= new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white); 
        b3.setBounds(30,360,110,30);
        b3.addActionListener(this); 
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/r1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,480,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(320,10,350,380);
        add(l6);
        
        getContentPane().setBackground(Color.white);
        setBounds(340,135,700,450);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== b1) {
           String room=null;
           String s1 = c1.getSelectedItem();
           conn c = new conn();
           
           try{
              ResultSet rs = c.s.executeQuery("select * from addroom where room = '"+s1+"'");
              while(rs.next()){
                 t1.setText(rs.getString("type"));
                 room = rs.getString("room");
              }
              ResultSet rs2 = c.s.executeQuery("select * from addRoom where room = '"+room+"'");
              while(rs2.next()) {
                 t2.setText(rs2.getString("available"));
                 t3.setText(rs2.getString("status"));
              }
           } catch(Exception e) {System.out.println(e);}
        } else if(ae.getSource()== b2) {
            try{
               conn c = new conn();
               String room = c1.getSelectedItem();
               String type = t1.getText();
               String available = t2.getText();
               String status = t3.getText();
               
               String str = "update addroom set type = '"+type+"' , available = '"+available+"', status = '"+status+"' where room = '"+room+"'";
               c.s.executeUpdate(str);
               JOptionPane.showMessageDialog(null,"Room updated successfully!");
               
               new Reception().setVisible(true);
               this.setVisible(false);
            } catch(Exception e) {System.out.println(e);}
        } else if(ae.getSource()== b3) {
              new Reception().setVisible(true);
              this.setVisible(false);
        }
    }


public static void main(String[] args) {
        new UpdateRoom();                      
    }
}