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

public class MainFrame extends JFrame implements ActionListener{
	
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	
	MainFrame(){
		
		btn1 = new JButton();
		btn1.setText("Add item to the menu");
		btn1.setBounds(500,150,200,100);
		btn1.addActionListener(this);
		btn2 = new JButton();
		btn2.setText("Delete item from the menu");
		btn2.setBounds(500,300,200,100);
		btn2.addActionListener(this);
		btn3 = new JButton();
		btn3.setText("Take order");
		btn3.setBounds(500,450,200,100);
		btn3.addActionListener(this);
		btn4= new JButton();
		btn4.setText("View order history");
		btn4.setBounds(500,600,200,100);
		btn4.addActionListener(this);
		
		JLabel titleLabel = new JLabel("WELCOME TO THE RESTAURANT BILLING SYSTEM");
		titleLabel.setBounds(350, 30, 550, 100);
		titleLabel.setFont(new Font("MV Boli",Font.BOLD,20));
	
		this.setTitle("Restaurant billing system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(titleLabel);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btn1) {
			AddItem AddItemOb = new AddItem();
			AddItemOb.setVisible(true);
		}
		
		else if(e.getSource() == btn2) {
			DeleteItem DeleteItemOb = new DeleteItem();
			DeleteItemOb.setVisible(true);
		}
		
		else if(e.getSource() == btn3){
			Menu MenuOb = new Menu();
			MenuOb.setVisible(true);
		}
		
		else {
			History HistoryOb = new History();
			HistoryOb.setVisible(true);
		}
		
	}

}

/*
 * public class MyFrame extends JFrame implements ActionListener{
	
	JTextField textField;
	JButton btn;
	
	MyFrame(){
		
		JLabel label = new JLabel();
		label.setText("username");
		label.setBounds(100,50,150,100);
		
		textField = new JTextField();
		textField.setText("enter");
		textField.setBounds(100,140,100,50);
		
		btn = new JButton();
		btn.setText("submit");
		btn.setBounds(100,300,100,50);
		btn.addActionListener(this);
		
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		this.add(label);
		this.add(textField);
		this.add(btn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn) {
			System.out.println(textField.getText());
		}
		
	}
	

}
*/
