package trials;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class PlaceOrder extends JFrame implements ActionListener{
	JButton backButton;
	JButton addBtn;
	JButton pricebtn;
	JTextField foodName;
	JTextField foodAmount;
	JLabel verifyLabel;
	static ArrayList<String> fn = new ArrayList<>();
	static ArrayList<Integer> fq = new ArrayList<>();
	
	static int grandtotal=0;
	
	
	PlaceOrder(){
		backButton = new JButton();
		backButton.setText("Back");
		backButton.setBounds(10,20,100,50);
		backButton.addActionListener(this);
		
		pricebtn = new JButton();
		pricebtn.setText("Amount");
		pricebtn.setBounds(100,200,100,50);
		pricebtn.addActionListener(this);
		
		
		
		JLabel fN = new JLabel("Food Name : ");
		fN.setBounds(480, 150, 200, 100);
		
		foodName = new JTextField();
		foodName.setBounds(600, 150, 200, 80);
		
		JLabel fP = new JLabel("Quantity :");
		fP.setBounds(490, 250, 200, 100);
		
		foodAmount = new JTextField();
		foodAmount.setBounds(600, 250, 200, 80);
		
		addBtn = new JButton();
		addBtn.setText("Add Item");
		addBtn.setBounds(560,350,100,50);
		addBtn.addActionListener(this);
		
		verifyLabel = new JLabel();
		
		this.setTitle("Order");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(backButton);
		this.add(fN);
		this.add(foodName);
		this.add(foodAmount);
		this.add(fP);
		this.add(addBtn);
		this.add(verifyLabel);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int price = 0;
		int itemamt = 0;
		int total = 0;
		int i=0;
		
		if(e.getSource()==backButton) {
			Menu MenuOb = new Menu();
			MenuOb.setVisible(true);
		}
		else if(e.getSource() == addBtn) {
			if(!foodName.getText().equals("") && !foodAmount.getText().equals("")) {
				try {
					System.out.println(foodName.getText());
					System.out.println(Integer.parseInt(foodAmount.getText()));
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","1234");

					
					PreparedStatement pstmt = con.prepareStatement("Select price from menu where name = (?)");
					pstmt.setString(1, foodName.getText());
					
					ResultSet rs = pstmt.executeQuery();
					
					
					while (rs.next()) {
						itemamt=Integer.parseInt(foodAmount.getText());
						fq.add(itemamt);
						fn.add(foodName.getText());
						price=Integer.parseInt(rs.getString(1));
						total = price * itemamt;
					}

					grandtotal=grandtotal+total;
					
					
					JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,grandtotal);  
					
				    Menu MenuOb = new Menu();
				    MenuOb.setVisible(true);
					
					
					
					
				}
				catch (NumberFormatException e1) {
					verifyLabel.setText("Please provide an Integer for food amount");
					verifyLabel.setBounds(470, 420, 400, 80);
					verifyLabel.setFont(new Font("MV Boli",Font.BOLD,15));
				}
				catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}
		}
		}
	}
	