package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

   public class LoginPage extends JFrame implements ActionListener {
     JLabel l1,l2,l3;
	  JTextField t1;
	  JPasswordField t2;
	  JButton b1, b2;
	  
	   LoginPage() {
		   
		   l1 = new JLabel("USERNAME");
		   l1.setBounds(40,120,100,30);
		   add(l1);
		   
		   l2 = new JLabel("PASSWORD");
		   l2.setBounds(40,180,100,30);
		   add(l2);
		   
		   t1 = new JTextField();
		   t1.setBounds(150,120,150,30);
		   add(t1);
		   
		   t2 = new JPasswordField();
		   t2.setBounds(150,180,150,30);
		   add(t2);
		   
		   
		   b1 = new JButton("Cancel");
		   b1.setBackground(Color.black);
		   b1.setForeground(Color.white);
		   b1.setBounds(50,260,100,30);
                   b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
                   b1.addActionListener(this);
		   add(b1);
		   		  		   
		   b2 = new JButton("Sign In");
		   b2.setBackground(Color.black);
		   b2.setForeground(Color.white);
		   b2.setBounds(190,260,100,30);
                   b2.setToolTipText("'Dashboard'");
                   b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
                   b2.addActionListener(this);
		   add(b2);
		   
		   ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/second.jpeg"));
		   Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		   ImageIcon i3 = new ImageIcon(i2);
		   JLabel l3 = new JLabel(i3);
		   l3.setBounds(350,100,200,200);
		   add(l3);
		     
		   ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/third.jpeg"));
		   Image i5 = i4.getImage().getScaledInstance(400,100,Image.SCALE_DEFAULT);
		   ImageIcon i6 = new ImageIcon(i5);
		   JLabel l4 = new JLabel(i6);
		   l4.setBounds(40,10,400,100);
		   add(l4);
		    
		   getContentPane().setBackground(Color.white);
		   
		   setLayout(null);
		   setBounds(400,180,600,370);
		   setVisible(true);
	   }
           
           public void actionPerformed(ActionEvent ae) {
               if(ae.getSource()== b2)
               {                  
                   String username = t1.getText();
                   String password = t2.getText();
                   conn c = new conn();
     
                   String str = "select * from loginpage where username = '"+username+"' and password = '"+password+"'";
                   try {                     
                       ResultSet rs = c.s.executeQuery(str);
                       if(rs.next()) {
                           new Dashboard().setVisible(true);
                           this.setVisible(false);
                       } 
                       else 
                       {
                           JOptionPane.showMessageDialog(null,"Invalid username or password");
                           this.setVisible(false);
                         }                   
                   } catch(Exception e) {
                       JOptionPane.showMessageDialog(null, "ERROR! while establishing connection");
                   }        
               } else if(ae.getSource()== b1){
                   System.exit(0);
               }
           }
           
	   public static void main(String[] args) {	
           new LoginPage();
	}

} 

 	 

