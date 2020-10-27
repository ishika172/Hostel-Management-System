package hostel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteStudent extends JFrame implements ActionListener {
    
    Choice c1;
    JTextField t1,t2;
    JButton b1, b2, b3;
    
    DeleteStudent() {
    
        JLabel l1 = new JLabel("Remove Student");
        l1.setFont(new Font("Tahoma", Font.BOLD,25));
        l1.setForeground(Color.blue);
        l1.setBounds(50,20,250,30);
        add(l1); 
        
        JLabel l2 = new JLabel("Student ID");
        l2.setBounds(20,90,100,30);
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
        c1.setBounds(150,90,150,30);
        add(c1);
        
        JLabel l3 = new JLabel("Student Name");
        l3.setBounds(20,140,100,30);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(150,140,150,30);
        add(t1);
        
        JLabel l4=new JLabel("Room Number");
        l4.setBounds(20,200,100,30);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(150,200,150,30);
        add(t2);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/check.jpg"));
        Image i5 = i4.getImage().getScaledInstance(25,23,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b1 = new JButton(i6);
        b1.setBounds(310,90,25,23);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Remove");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(170,290,100,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Cancel");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(40,290,100,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/s3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350,360,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l5 = new JLabel(i3);
        l5.setBounds(340,10,340,360);
        add(l5);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(340,165,700,390);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== b1) {
           String room=null;
           String s1 = c1.getSelectedItem();
           conn c = new conn();
           
           try{
              ResultSet rs = c.s.executeQuery("select * from addstudent where aadhar = '"+s1+"'");
              while(rs.next()){
                 room = rs.getString("room");
              }
              ResultSet rs2 = c.s.executeQuery("select * from addstudent where aadhar = '"+s1+"'");
              while(rs2.next()) {
                 t1.setText(rs2.getString("name"));
                 t2.setText(rs2.getString("room"));
              }
           } catch(Exception e) {System.out.println(e);}
        }  else if(ae.getSource()== b2) {
            try{
               conn c = new conn();
               String  s1 = c1.getSelectedItem();
               String room = t2.getText();
               
               String str = "delete from addstudent where aadhar = '"+s1+"'";
               c.s.executeUpdate(str);
               
               String str2 = "update addroom set available = 'Available' where room = '"+room+"'";
               c.s.executeUpdate(str2);
               
               JOptionPane.showMessageDialog(null,"Student removed successfully!"); 
               this.setVisible(false);
            } catch(Exception e) {System.out.println(e);}
        } else if(ae.getSource()== b3) {
              this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
      new DeleteStudent();
    }
}
