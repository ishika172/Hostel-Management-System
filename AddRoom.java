package hostel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener{
    
    JTextField t1;
    JComboBox c1, c2, c3;
    JButton b1,b2;
    
    AddRoom() {
        
        JLabel l1 = new JLabel("Add Room");
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100,10,180,30);
        add(l1);
        
        JLabel room = new JLabel("ROOM NO.");
        room.setFont(new Font("serif",Font.PLAIN,16));
        room.setBounds(40,90,120,30);
        add(room);
        
        t1 = new JTextField();
        t1.setBounds(180,90,160,30);
        add(t1);
        
        JLabel available = new JLabel("AVAILABLE");
        available.setFont(new Font("serif",Font.PLAIN,16));
        available.setBounds(40,150,120,30);
        add(available);
        
        c1 = new JComboBox(new String[] {"Available","Occupied"});
        c1.setBounds(180,150,160,30);
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel status = new JLabel("ROOM STATUS");
        status.setFont(new Font("serif",Font.PLAIN,16));
        status.setBounds(40,210,120,30);
        add(status);
        
        c2 = new JComboBox(new String[] {"Clean","Filthy"});
        c2.setBounds(180,210,160,30);
        c2.setBackground(Color.white);
        add(c2);
        
        JLabel type = new JLabel("ROOM TYPE");
        type.setFont(new Font("serif",Font.PLAIN,16));
        type.setBounds(40,270,120,30);
        add(type);
        
        c3 = new JComboBox(new String[] {"Single","Double sharing","Triple sharing"});
        c3.setBounds(180,270,160,30);
        c3.setBackground(Color.white);
        add(c3);
        
        b1 = new JButton("Add");
        b1.setBounds(200,360,120,30);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("CANCEL");
        b2.setBounds(50,360,120,30);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hostel/management/system/icons/r1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(410, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(360,30,410,380);
        add(l2);
        
        getContentPane().setBackground(Color.white);
        
        setBounds(310,145,820,480);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == b1) {
            String room = t1.getText();
            String available = (String)c1.getSelectedItem();
            String status = (String)c2.getSelectedItem();
            String type = (String)c3.getSelectedItem();
            
            conn c = new conn();
            
            try {
                String str = "insert into addroom values('"+room+"','"+available+"','"+status+"','"+type+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added!");
                this.setVisible(false);
                
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null,""+e);
            }
        } else if(ae.getSource() == b2) {
            this.setVisible(false);
        }
            
    }
    
    public static void main(String[] args) {
        new AddRoom();
    }
}
