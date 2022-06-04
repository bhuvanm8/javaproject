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

public class AddItem extends JFrame implements ActionListener{

	JButton backButton;
	JButton addBtn;
	JTextField foodName;
	JTextField foodPrice;
	JLabel verifyLabel;
	
	AddItem(){
		backButton = new JButton();
		backButton.setText("Back");
		backButton.setBounds(10,20,100,50);
		backButton.addActionListener(this);
		
		
		JLabel label1 = new JLabel("Add the item to the menu");
		label1.setBounds(490, 30, 550, 100);
		label1.setFont(new Font("MV Boli",Font.BOLD,20));
		
		JLabel fN = new JLabel("Food Name : ");
		fN.setBounds(480, 150, 200, 100);
		
		foodName = new JTextField();
		foodName.setBounds(600, 150, 200, 80);
		
		JLabel fP = new JLabel("Food Price : ");
		fP.setBounds(480, 250, 200, 100);
		
		foodPrice = new JTextField();
		foodPrice.setBounds(600, 250, 200, 80);
		
		addBtn = new JButton();
		addBtn.setText("Add Item");
		addBtn.setBounds(560,350,80,50);
		addBtn.addActionListener(this);
		
		verifyLabel = new JLabel();
		
		this.setTitle("Restaurant billing system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(backButton);
		this.add(label1);
		this.add(fN);
		this.add(foodName);
		this.add(fP);
		this.add(foodPrice);
		this.add(addBtn);
		this.add(verifyLabel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			
			MainFrame MainFrameOb = new MainFrame();
			MainFrameOb.setVisible(true);
		}
		
		else if(e.getSource() == addBtn) {
			if(!foodName.getText().equals("") && !foodPrice.getText().equals("")) {
				try {
					System.out.println(foodName.getText());
					System.out.println(Integer.parseInt(foodPrice.getText()));
					verifyLabel.setText("Successfuly added");
					verifyLabel.setBounds(530, 420, 200, 80);
					verifyLabel.setFont(new Font("MV Boli",Font.BOLD,15));
				}
				catch (NumberFormatException e1) {
					verifyLabel.setText("Please provide an Integer for food price");
					verifyLabel.setBounds(470, 420, 400, 80);
					verifyLabel.setFont(new Font("MV Boli",Font.BOLD,15));
				}
			}
			else {
				verifyLabel.setText("Please complete the form");
				verifyLabel.setBounds(510, 420, 200, 80);
				verifyLabel.setFont(new Font("MV Boli",Font.BOLD,15));
			}
		}
		
	}
	
}
