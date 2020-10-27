package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField t1, t2, t3, t4, t5, t6;
    JRadioButton r1, r2;
    JComboBox c1;
    JButton b1;
    
    AddEmployee() {
        
        
         JLabel name = new JLabel("NAME");
         name.setBounds(50,30,120,30);
         name.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(name);
         
         t1 = new JTextField();
         t1.setBounds(180,30,180,30);
         add(t1);
         
         JLabel age = new JLabel("AGE");
         age.setBounds(50,80,120,30);
         age.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(age);
         
         t2 = new JTextField();
         t2.setBounds(180,80,180,30);
         add(t2);
         
         JLabel gender = new JLabel("GENDER");
         gender.setBounds(50,130,120,30);
         gender.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(gender);
         
         r1 = new JRadioButton("MALE");
         r1.setBounds(180, 125, 70, 40);
         r1.setFont(new Font("serif", Font.PLAIN, 12));
         r1.setBackground(Color.white);
         add(r1);
         
         r2 = new JRadioButton("FEMALE");
         r2.setBounds(260, 125, 90, 40);
         r2.setFont(new Font("serif", Font.PLAIN, 12));
         r2.setBackground(Color.white);
         add(r2);
         
         JLabel job = new JLabel("JOB");
         job.setBounds(50,180,120,30);
         job.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(job);
         
         String str[] = {"Manager", "Warden", "House Keeping", "Kitchen Staff", "Chef", "Security Guard", "Driver"};
         c1 = new JComboBox(str);
         c1.setBounds(180,180,180,30);
         c1.setBackground(Color.white);
         add(c1);
         
         JLabel salary = new JLabel("SALARY");
         salary.setBounds(50,230,120,30);
         salary.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(salary);
       
         t3 = new JTextField();
         t3.setBounds(180,230,180,30);
         add(t3);
         
         JLabel phone = new JLabel("CONTACT NO.");
         phone.setBounds(50,280,120,30);
         phone.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(phone);
         
         t4 = new JTextField();
         t4.setBounds(180,280,180,30);
         add(t4);
         
         JLabel aadhar = new JLabel("AADHAR NO.");
         aadhar.setBounds(50,330,120,30);
         aadhar.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(aadhar);
         
         t5 = new JTextField();
         t5.setBounds(180,330,180,30);
         add(t5);
         
         JLabel email = new JLabel("EMAIL");
         email.setBounds(50,380,120,30);
         email.setFont(new Font("Tahoma", Font.PLAIN,16));
         add(email);
         
         t6 = new JTextField();
         t6.setBounds(180,380,180,30);
         add(t6);
         
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hostel/Management/System/icons/e1.jpg"));
         Image i2 = i1.getImage().getScaledInstance(520,520, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel l1 = new JLabel(i3);
         l1.setBounds(400,60,400,450);
         add(l1);
         
         JLabel l2 = new JLabel("Add Employee Details");
         l2.setForeground(Color.BLUE);
         l2.setFont(new Font("Tahoma",Font.BOLD,30));
         l2.setBounds(440,20,900,40);
         add(l2);
         
         
         b1 = new JButton("SUBMIT");
         b1.setBackground(Color.BLUE);
         b1.setForeground(Color.WHITE);
         b1.setBounds(200,440,120,30);
         b1.addActionListener(this);
         b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
         add(b1);
         
         getContentPane().setBackground(Color.WHITE);
         
         setLayout(null);
         setBounds(260,125,850,540);
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = t1.getText();
        String age = t2.getText();
        String salary = t3.getText();
        String phone = t4.getText();
        String aadhar = t5.getText();
        String email = t6.getText();
        
        String gender = null;
        if(r1.isSelected()) {
            gender = "Male";
            r2.setSelected(false);
        } else if(r2.isSelected()) {
            gender = "Female";
            r1.setSelected(false);
        }
        
        String job = (String)c1.getSelectedItem();
        conn c = new conn();
        String str = "insert into addemployee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
         
        try {
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added!");
            this.setVisible(false);         
            } 
         catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static void main(String[] args) {
        
        new AddEmployee().setVisible(true);
    }   
}
