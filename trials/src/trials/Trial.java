package trials;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Trial{
	
	static Connection con;
	
	public static void main(String args[]) throws ClassNotFoundException,SQLException{
		
		
		new MainFrame();
	}
	
	
}