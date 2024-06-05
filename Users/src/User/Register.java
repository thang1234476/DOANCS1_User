package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 204, 255));
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
		
		JLabel lblNewLabel = new JLabel("Đăng ký");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(265, 11, 123, 43);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(305, 75, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(305, 115, 96, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(305, 155, 96, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Wordspace\\ảnh\\icons8-user-30.png"));
		lblNewLabel_1.setBounds(265, 70, 30, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Wordspace\\ảnh\\icons8-key-30.png"));
		lblNewLabel_2.setBounds(265, 110, 30, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("New label");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("D:\\Wordspace\\ảnh\\icons8-tick-30.png"));
		lblNewLabel_2_1_1.setBounds(265, 150, 30, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnRegister = new JButton("OK");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = textField.getText();
				String pass = getMd5(passwordField.getText());
				String passconfirm = getMd5(passwordField_1.getText());
				if (ten.isEmpty() || pass.isEmpty() || passconfirm.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin vào các trường!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else if (!pass.equals(passconfirm)) {
                    JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu không khớp!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                	 try {
                         Socket socket = new Socket("192.168.100.14", 1124);
                         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                         out.println("REGISTER");
                         out.println(ten);
                         out.println(pass);
                         out.println(passconfirm);

                         String response = in.readLine();
                         if (response != null && response.equals("Register successful")) {
                             JOptionPane.showMessageDialog(null, "Đăng ký thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                         } else {
                             JOptionPane.showMessageDialog(null, "Đăng ký không thành công! Vui lòng kiểm tra lại thông tin.", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                         }

                         in.close();
                         out.close();
                         socket.close();
                     } catch (IOException ex) {
                         ex.printStackTrace();
                         JOptionPane.showMessageDialog(null, "Lỗi kết nối đến server!", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
                     }
                }
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnRegister.setBackground(new Color(102, 204, 255));
		btnRegister.setBounds(278, 195, 110, 23);
		contentPane.add(btnRegister);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = new User();
				u.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(102, 204, 255));
		btnNewButton.setBounds(285, 229, 96, 23);
		contentPane.add(btnNewButton);
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
}
