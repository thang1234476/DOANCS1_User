	package User;
	
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import java.awt.Color;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;
	import javax.swing.SwingUtilities;
	import javax.swing.JPasswordField;
	import javax.swing.JButton;
	import java.awt.Font;
	import javax.swing.ImageIcon;
	import java.awt.event.ActionListener;
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.math.BigInteger;
	import java.net.Socket;
	import java.security.MessageDigest;
	import java.security.NoSuchAlgorithmException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.awt.event.ActionEvent;
	
	public class User extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField textField;
		private JPasswordField passwordField;
	
		private static String user;
		private String pass;
		
		
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						User frame = new User();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
		/**
		 * Create the frame.
		 */
		public User() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(102, 204, 255));
			panel.setBounds(0, 0, 218, 275);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setIcon(new ImageIcon("D:\\Wordspace\\ảnh\\icons8-bus-100.png"));
			lblNewLabel_4.setBounds(44, 80, 100, 100);
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon("D:\\Wordspace\\ảnh\\icons8-ticket-100.png"));
			lblNewLabel_3.setBounds(84, 31, 100, 100);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel = new JLabel("User");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
			lblNewLabel.setBounds(300, 45, 111, 42);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(290, 112, 120, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(290, 154, 120, 20);
			contentPane.add(passwordField);
			
			
			
			JButton btnNewButton = new JButton("Login");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					user = textField.getText();
					pass = getMd5(passwordField.getText());
					
					try {
					    Socket socket = new Socket("192.168.1.66", 1122);
					    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
					    out.println(user);
					    out.println(pass);
	
					    String response = in.readLine();
					    System.out.println("Response from server: " + response);
					    if (response != null) {
			                if (response.equals("Login successful")) {
			                	Chuyendi c = new Chuyendi();
			                	c.setVisible(true);
			                	dispose();
			                } else {
			                    System.out.println("Login failed: " + response); 
			                }
			            } else {
			                System.err.println("No response received from server.");
			            }
					    in.close();
					    out.close();
					    socket.close();
					} catch (IOException ex) {
					    ex.printStackTrace();
					}
				}
			});
			btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
			btnNewButton.setBackground(new Color(102, 204, 255));
			btnNewButton.setBounds(290, 195, 96, 23);
			contentPane.add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("D:\\Wordspace\\ảnh\\icons8-user-30.png"));
			lblNewLabel_1.setBounds(250, 107, 30, 30);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("D:\\Wordspace\\ảnh\\icons8-key-30.png"));
			lblNewLabel_2.setBounds(250, 149, 30, 30);
			contentPane.add(lblNewLabel_2);
			
			JButton btnRegister = new JButton("Register");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Register r = new Register();
					r.setVisible(true);
					dispose();
				}
			});
			btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 19));
			btnRegister.setBackground(new Color(102, 204, 255));
			btnRegister.setBounds(282, 225, 110, 23);
			contentPane.add(btnRegister);
	
		}
		
		public static String getMd5(String input) {
			try {
	
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] messageDigest = md.digest(input.getBytes());
				BigInteger no = new BigInteger(1, messageDigest);
				String hashtext = no.toString(16);
				while (hashtext.length() < 32) {
					hashtext = "0" + hashtext;
				}
				return hashtext;
			}
	
			catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
		}
		
	
		public String getName() {
			return user;
		}
		
	}
