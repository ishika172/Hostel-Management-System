package hostel.management.system;

        import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

 public class HostelManagementSystem extends JFrame implements ActionListener {
      HostelManagementSystem() {
			  setBounds(-10,0,2000,800);
//			  setSize(400,400);       setBounds works both as setSize as well as setLocation 		  
//			  setLocation(300,300);
		  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hostel/management/system/icons/fourth (2).jpg"));
		  Image i2 = i1.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
		  ImageIcon i3 = new ImageIcon(i2);
		  JLabel l1 = new JLabel(i3);
		  l1.setBounds(0,0,1500,800);
		  add(l1);
		  
		  JLabel l2 = new JLabel("'Welcome to the Galgotias'");
		  l2.setBounds(20,600,1000,100);
		  l2.setForeground(Color.black);
		  l2.setFont(new Font("serif", Font.BOLD,60));
		  l1.add(l2);
		  
		  JLabel l3 = new JLabel("HOSTEL MANAGEMENT SYSTEM");
		  l3.setBounds(170,20,1000,180);
		  l3.setForeground(Color.black);
		  l3.setFont(new Font("serif", Font.BOLD,60));
		  l1.add(l3);
		  
		  JButton b1 = new JButton("Next");
		   b1.setFont(new Font("serif", Font.BOLD,20));
		   b1.setBackground(Color.WHITE);
		   b1.setForeground(Color.BLACK);
		   b1.setBounds(630,380,110,30);
		   b1.addActionListener(this);
                   b1.setToolTipText("'Next Page'");
                   b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		   l1.add(b1);
		  
		  setLayout(null);
		  setVisible(true);
		  
		  while(true) {
			  l2.setVisible(false);
			  try {
				  Thread.sleep(600);
			  }
			  catch(Exception e) {
			  }
			   l2.setVisible(true);
			   try {
				   Thread.sleep(800);
			   }
			   catch(Exception e) {  
			   }
		    }
		  }
		   
		  public void actionPerformed(ActionEvent ae) {  
			  new LoginPage().setVisible(true);
                          this.setVisible(false);
		  }
	  

    public static void main(String[] args) {
      
        new HostelManagementSystem().setVisible(true);
    }
    
}
 