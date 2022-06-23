package trials;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.sql.*;

public class History extends JFrame implements ActionListener{

	JButton backButton;
	JTextArea historyList;
	
	History(){
		backButton = new JButton();
		backButton.setText("Back");
		backButton.setBounds(10,20,100,50);
		backButton.addActionListener(this);
		historyList = new JTextArea();
		historyList.setBounds(500, 110, 200, 600);
		JLabel label1 = new JLabel("Order History:");
		label1.setBounds(525, 30, 550, 100);
		label1.setFont(new Font("MV Boli",Font.BOLD,20));
		
		String st = "OrderID  Total_Price  Date\n";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","1234");
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from orderHistory");
			while(rs.next()) {
				st += rs.getInt(1) + "               " + rs.getInt(2) + "           " + rs.getString(3) + "\n";
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		historyList.setText(st);
		
		this.setTitle("Restaurant billing system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(backButton);
		this.add(label1);
		this.add(historyList);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			MainFrame MainFrameOb = new MainFrame();
			MainFrameOb.setVisible(true);
		}
		
	}
	
}