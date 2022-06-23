package trials;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteItem extends JFrame implements ActionListener{

	JButton backButton;
	JButton deleteBtn;
	JTextField fID;
	JLabel verifyLabel;
	
	DeleteItem(){
		backButton = new JButton();
		backButton.setText("Back");
		backButton.setBounds(10,20,100,50);
		backButton.addActionListener(this);
		
		JLabel label1 = new JLabel("Delete the item from the menu");
		label1.setBounds(450, 30, 550, 100);
		label1.setFont(new Font("MV Boli",Font.BOLD,20));
		
		JLabel fIDLabel = new JLabel("Enter the Food Item ID : ");
		fIDLabel.setBounds(400, 150, 200, 100);
		
		fID = new JTextField();
		fID.setBounds(600, 150, 200, 80);
		
		deleteBtn = new JButton();
		deleteBtn.setText("Delete Item");
		deleteBtn.setBounds(550,250,120,50);
		deleteBtn.addActionListener(this);
		
		verifyLabel = new JLabel();
		
		this.setTitle("Restaurant billing system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(backButton);
		this.add(label1);
		this.add(fIDLabel);
		this.add(fID);
		this.add(deleteBtn);
		this.add(verifyLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			MainFrame MainFrameOb = new MainFrame();
			MainFrameOb.setVisible(true);
		}
		
		else if(e.getSource() == deleteBtn) {
			if(!fID.getText().equals("")) {
				try {
					System.out.println(fID.getText());
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","1234");
					PreparedStatement ps = con.prepareStatement("Delete from menu where Name=(?)");
					ps.setString(1, fID.getText());
					ps.executeUpdate();
					verifyLabel.setText("Successfuly Deleted");
					verifyLabel.setBounds(530, 320, 200, 80);
					verifyLabel.setFont(new Font("MV Boli",Font.BOLD,15));
				}
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else {
				verifyLabel.setText("Please complete the form");
				verifyLabel.setBounds(510, 320, 200, 80);
				verifyLabel.setFont(new Font("MV Boli",Font.BOLD,15));
			}
		}
		
	}
	
}