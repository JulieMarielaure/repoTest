package Connexion;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField_login;
	private JTextField textField_name;
	private JTextField textField_password;
	private JTable table;

	String url = "jdbc:mysql://localhost:3306/test_db?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    String user = "root";
    String password = "root";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel dm = MyConnexion.getData();
		        table.setModel(dm);			
	            
			}
			
		});
		
		btnNewButton.setBounds(30, 403, 115, 29);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Select");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				String id = (String) textField_login.getText();
				
				DefaultTableModel dm = MyConnexion.getDataSelect();
				System.out.println(dm);
		        table.setModel(dm);			
	            
			}
		});
		
		
		btnNewButton_1.setBounds(197, 403, 115, 29);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_2.setBounds(378, 403, 115, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btnNewButton_3.setBounds(579, 403, 115, 29);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(50, 299, 69, 20);
		contentPane.add(lblNewLabel);
		
		textField_login = new JTextField();
		textField_login.setBounds(112, 296, 146, 26);
		contentPane.add(textField_login);
		textField_login.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setBounds(362, 296, 146, 26);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(306, 299, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		textField_password = new JTextField();
		textField_password.setBounds(653, 296, 146, 26);
		contentPane.add(textField_password);
		textField_password.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(558, 299, 69, 20);
		contentPane.add(lblPassword);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 30, 637, 227);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
}
