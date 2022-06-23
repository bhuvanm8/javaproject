package trials;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ConfirmOrder extends JFrame implements ActionListener{

	JButton backButton;
	JButton addBtn;
	JTextField totalprice;
	JLabel verifyLabel;
	JTextArea OrderList;
	
	ConfirmOrder(){
		backButton = new JButton();
		backButton.setText("Back");
		backButton.setBounds(10,20,100,50);
		backButton.addActionListener(this);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		
		
		
		if (!PlaceOrder.fn.isEmpty()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","1234");
				PreparedStatement ps = con.prepareStatement("insert into orderHistory(totalPrice,datenow) values(?,?)");
				ps.setInt(1, PlaceOrder.grandtotal);
				ps.setString(2,String.valueOf(dtf.format(now)));
				ps.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		OrderList = new JTextArea();
		String st = ""
;		if(!PlaceOrder.fn.isEmpty()) {
			OrderList.setBounds(480, 210, 200, 500);
			st += "Food Name         " + " " + "Quantity" + "\n";
			while(!PlaceOrder.fn.isEmpty()) {
				st += "   " + PlaceOrder.fn.remove(0) + "               " + PlaceOrder.fq.remove(0) + "\n";
			}
		}
		
		
		OrderList.setText(st);

		JLabel fN = new JLabel("Total Cost : ");
		fN.setBounds(480, 100, 200, 100);
		
		totalprice = new JTextField();
		totalprice.setBounds(600, 100, 200, 80);
		

		
		verifyLabel = new JLabel();
		
		this.setTitle("Restaurant billing system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(backButton);
		this.add(fN);
		this.add(totalprice);
		this.add(verifyLabel);
		this.add(OrderList);
		totalprice.setText(String.valueOf(PlaceOrder.grandtotal));
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			MainFrame MainFrameOb = new MainFrame();
			MainFrameOb.setVisible(true);
			PlaceOrder.grandtotal = 0;
			PlaceOrder.fn.clear();
			PlaceOrder.fq.clear();
		}
	}
}