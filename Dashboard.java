package hostel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

  public class Dashboard extends JFrame implements ActionListener {
         
      JMenuBar mb;
      JMenu m,m1, m2, m3, m4, m5;
      JMenuItem mi,mi1, mi2, mi3, mi4, mi5, mi6, mi7, mi8, mi9;
      JButton b1;
      
      Dashboard() 
       {         
           
          mb = new JMenuBar();
          add(mb);
          mb.setBounds(0,0,1900,30);
          
          m = new JMenu("Hostel Management");
          m.setForeground(Color.red);
          m.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mb.add(m);
          
          m1 = new JMenu("Student Portal");
          m1.setForeground(Color.red);
          m1.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mb.add(m1);
          
          m2 = new JMenu("Room Management");
          m2.setForeground(Color.RED);
          m2.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mb.add(m2);
          
          m3 = new JMenu("Staff Management");
          m3.setForeground(Color.red);
          m3.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mb.add(m3);
          
          m4 = new JMenu("Hostel Fees");
          m4.setForeground(Color.red);
          m4.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mb.add(m4);
          
          mi = new JMenuItem("Reception");
          mi.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi.addActionListener(this);
          m.add(mi);
          
          mi1 = new JMenuItem("Add Student");
          mi1.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mi1.addActionListener(this);
          m1.add(mi1);
          
          mi2 = new JMenuItem("Delete Student");
          mi2.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi2.addActionListener(this);
          m1.add(mi2);
          
          mi3 = new JMenuItem("Add Room");
          mi3.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi3.addActionListener(this);
          m2.add(mi3);
          
          mi4 = new JMenuItem("Delete Room");
          mi4.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mi4.addActionListener(this);
          m2.add(mi4);
          
          mi5 = new JMenuItem("Add Staff");
          mi5.setCursor(new Cursor(Cursor.HAND_CURSOR));
          mi5.addActionListener(this);
          m3.add(mi5);
          
          mi6 = new JMenuItem("Delete Staff");
          mi6.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi6.addActionListener(this);
          m3.add(mi6);
          
          mi7 = new JMenuItem("Show Structure");
          mi7.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi7.addActionListener(this);
          m4.add(mi7);
          
          mi8 = new JMenuItem("Update Fees");
          mi8.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
          mi8.addActionListener(this);
          m4.add(mi8);
 
          
          ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hostel/management/system/icons/d3.jpg"));
          Image i2 = i1.getImage().getScaledInstance(2000,1000, Image.SCALE_DEFAULT);
          ImageIcon i3 = new ImageIcon(i2);
          JLabel l1 = new JLabel(i1);
          l1.setBounds(0,0,1400,800);
          add(l1);
          
          JLabel l2 = new JLabel("HEY!! ADMIN");
          l2.setBounds(545,10,600,100);
          l2.setForeground(Color.getHSBColor(25.8f, 17.9f, 20.6f));
          l2.setFont(new Font("Tahoma",Font.BOLD,46));
          l1.add(l2);
                   
          JLabel l3 = new JLabel("'RECEPTION'");
          l3.setBounds(10,615,1000,90);
          l3.setForeground(Color.white);
          l3.setFont(new Font("serif",Font.ITALIC,80));
          l1.add(l3);
          
          b1 = new JButton("Logout");
          b1.setBounds(1270,30,80,30);
          b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
          b1.addActionListener(this);
          add(b1);
        
          
          setLayout(null);     
          setVisible(true);
          setBounds(-10,0,2000,800);
           
       }
      public void actionPerformed(ActionEvent ae) {
          if(ae.getSource() == b1) {
              int a = JOptionPane.showConfirmDialog(null,"Do you wish to logout!","Select",JOptionPane.YES_NO_OPTION);
              if(a == 0){
                 setVisible(false);
                 new LoginPage().setVisible(true);
              } 
          }
          
          if(ae.getActionCommand().equals("Reception")) {
              new Reception().setVisible(true);
          } else if(ae.getActionCommand().equals("Add Staff")) {
              new AddEmployee().setVisible(true);
          } else if(ae.getActionCommand().equals("Add Student")) {
              new AddStudent().setVisible(true);
          } else if(ae.getActionCommand().equals("Add Room")) {
              new AddRoom().setVisible(true);
          }  else if(ae.getActionCommand().equals("Delete Room")) {
              new DeleteRoom().setVisible(true);
          } else if(ae.getActionCommand().equals("Delete Student")) {
              new DeleteStudent().setVisible(true);
          } else if(ae.getActionCommand().equals("Delete Staff")) {
              new DeleteStaff().setVisible(true);
          } else if(ae.getActionCommand().equals("Show Structure")) {
              new FeeStructure().setVisible(true);
          } else if(ae.getActionCommand().equals("Update Fees")) {
              new UpdateFee().setVisible(true);
          }             
   }
      
        public static void main(String[] args) {
          
          new Dashboard();
      }
 
}
