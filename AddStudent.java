package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener{
    
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    JRadioButton r1, r2;
    JComboBox c1;
    JButton b1;
    Choice c2;
    
    AddStudent() {
        
        JLabel name = new JLabel("NAME");
         name.setBounds(30,90,120,30);
         name.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(name);
         
         t1 = new JTextField();
         t1.setBounds(120,90,160,30);
         add(t1);
         
         JLabel age = new JLabel("AGE");
         age.setBounds(30,150,120,30);
         age.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(age);
         
         t2 = new JTextField();
         t2.setBounds(120,150,160,30);
         add(t2);
         

         JLabel dob = new JLabel("DOB");
         dob.setBounds(30,210,120,30);
         dob.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(dob);
       
         t3 = new JTextField();
         t3.setBounds(120,210,160,30);
         add(t3);
         
         JLabel gender = new JLabel("GENDER");
         gender.setBounds(30,270,120,30);
         gender.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(gender);
         
         r1 = new JRadioButton("MALE");
         r1.setBounds(120,270,60,30);
         r1.setFont(new Font("serif", Font.PLAIN, 12));
         r1.setBackground(Color.white);
         add(r1);
         
         r2 = new JRadioButton("FEMALE");
         r2.setBounds(190,270,80,30);
         r2.setFont(new Font("serif", Font.PLAIN, 12));
         r2.setBackground(Color.white);
         add(r2);
         
         
         JLabel college = new JLabel("COLLEGE");
         college.setBounds(30,330,120,30);
         college.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(college);
         
         String str[] = {"GCET","GU"};
         c1 = new JComboBox(str);
         c1.setBounds(120,330,160,30);
         c1.setBackground(Color.white);
         add(c1);
         
         JLabel phone = new JLabel("CONTACT NO.");
         phone.setBounds(490,90,120,30);
         phone.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(phone);
         
         t4 = new JTextField();
         t4.setBounds(630,90,160,30);
         add(t4);
         
         JLabel aadhar = new JLabel("AADHAR NO.");
         aadhar.setBounds(490,150,120,30);
         aadhar.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(aadhar);
         
         t5 = new JTextField();
         t5.setBounds(630,150,160,30);
         add(t5);
         
         JLabel room = new JLabel("ROOM NO.");
         room.setBounds(490,210,120,30);
         room.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(room);
         
         c2 = new Choice();
         try {
             conn c = new conn();
             String str2 = "select * from addroom where available = 'Available'";
             ResultSet rs = c.s.executeQuery(str2);
             
             while(rs.next()) {
                 c2.add(rs.getString("room"));
             }
         } catch(Exception e) {
             
         }
         c2.setBounds(630,210,160,40);
         add(c2);
     
         
         JLabel fees = new JLabel("FEES");
         fees.setBounds(490,270,120,30);
         fees.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(fees);
         
         t6 = new JTextField();
         t6.setBounds(630,270,160,30);
         add(t6);
         
         JLabel paid = new JLabel("PAID");
         paid.setBounds(490,330,120,30);
         paid.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(paid);
         
         t7 = new JTextField();
         t7.setBounds(630,330,160,30);
         add(t7);
   
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hostel/Management/System/icons/s2.png"));
         Image i2 = i1.getImage().getScaledInstance(200,330, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel l1 = new JLabel(i3);
         l1.setBounds(280,70,200,320);
         add(l1);
         
         JLabel l2 = new JLabel("Add Student Details");
         l2.setForeground(Color.BLUE);
         l2.setFont(new Font("Tahoma",Font.BOLD,30));
         l2.setBounds(260,05,900,40);
         add(l2);
         
         
         b1 = new JButton("SUBMIT");
         b1.setBackground(Color.BLUE);
         b1.setForeground(Color.WHITE);
         b1.setBounds(330,410,120,30);
         b1.addActionListener(this);
         b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
         add(b1);
         
         getContentPane().setBackground(Color.WHITE);
         
         setLayout(null);
         setBounds(280,135,830,500);
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = t1.getText();
        String age = t2.getText();
        String dob = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String fees = t6.getText();
        String paid = t7.getText();
        String pending = null;
        String room = c2.getSelectedItem();
        
        String gender = null;
        if(r1.isSelected()) {
            gender = "Male";
            r2.setSelected(false);
        } else if(r2.isSelected()) {
            gender = "Female";
            r1.setSelected(false);
        }
        
        String college = (String)c1.getSelectedItem();
        conn c = new conn();
        String str = "insert into addstudent values('"+name+"','"+age+"','"+dob+"','"+gender+"','"+college+"','"+phone+"','"+aadhar+"','"+room+"','"+fees+"','"+paid+"','"+pending+"')";
        String str3 = "Update addroom set available = 'Occupied' where room = '"+room+"'"; 
        
        try {
            c.s.executeUpdate(str);
            c.s.executeUpdate(str3);
            JOptionPane.showMessageDialog(null,"New Student Added!");
            this.setVisible(false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
         public static void main(String[] args) {
        
        new AddStudent().setVisible(true);
    }   
}
    
   
