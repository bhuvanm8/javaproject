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

public class PlaceOrder extends JFrame implements ActionListener{

	JButton backButton;
	
	PlaceOrder(){
		backButton = new JButton();
		backButton.setText("Back");
		backButton.setBounds(10,20,100,50);
		backButton.addActionListener(this);
		
		JLabel label1 = new JLabel("Order Details:");
		label1.setBounds(525, 30, 550, 100);
		label1.setFont(new Font("MV Boli",Font.BOLD,20));
		
		this.setTitle("Restaurant billing system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(backButton);
		this.add(label1);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			Menu MenuOb = new Menu();
			MenuOb.setVisible(true);
		}
		
	}
	
}