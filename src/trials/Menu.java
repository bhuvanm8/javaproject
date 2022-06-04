package trials;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Menu extends JFrame implements ActionListener{

	JButton backButton;
	JButton printBill;
	
	Menu(){
		backButton = new JButton();
		backButton.setText("Back");
		backButton.setBounds(10,20,100,50);
		backButton.addActionListener(this);
		printBill = new JButton();
		printBill.setText("Place Order");
		printBill.setBounds(1080,20,100,50);
		printBill.addActionListener(this);
		
		JLabel label1 = new JLabel("Please select the item from the Menu");
		label1.setBounds(400, 30, 550, 100);
		label1.setFont(new Font("MV Boli",Font.BOLD,20));
		
		this.setTitle("Restaurant billing system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(backButton);
		this.add(printBill);
		this.add(label1);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			MainFrame MainFrameOb = new MainFrame();
			MainFrameOb.setVisible(true);
		}
		
		else if(e.getSource() == printBill) {
			PlaceOrder PlaceOrderOb = new PlaceOrder();
			PlaceOrderOb.setVisible(true);
		}
		
	}
	
}