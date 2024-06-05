package User;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ThanhToan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jt ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToan frame = new ThanhToan();
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
	public ThanhToan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Wordspace\\ảnh\\thanhToan1.jpg"));
		lblNewLabel.setBounds(165, 190, 170, 170);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("( Quét để thanh toán ngay! )");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(180, 360, 150, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Trở lại");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Datve datve = new Datve();
				datve.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 153, 51));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 11, 71, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Số vé:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(190, 70, 60, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Số tiền/người:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(139, 100, 100, 20);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Số tiền cần thanh toán:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(82, 130, 160, 20);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton_1 = new JButton("Hoàn Tất");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Chuyendi cd = new Chuyendi();
				cd.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(51, 102, 255));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(200, 390, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label_soVe = new JLabel(getSove());
		label_soVe.setFont(new Font("Arial", Font.PLAIN, 15));
		label_soVe.setBounds(245, 70, 60, 20);
		contentPane.add(label_soVe);
		
		JLabel lblNewLabel_2_3 = new JLabel("Vé");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(299, 70, 60, 20);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel label_tien = new JLabel(getGiaVe());
		label_tien.setFont(new Font("Arial", Font.PLAIN, 15));
		label_tien.setBounds(245, 101, 90, 20);
		contentPane.add(label_tien);
		
		JLabel lblNewLabel_2_5 = new JLabel("VNĐ");
		lblNewLabel_2_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_5.setBounds(344, 100, 60, 20);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel label_tongTien = new JLabel();
		label_tongTien.setText(String.valueOf(getThanhToan()));
		label_tongTien.setFont(new Font("Arial", Font.PLAIN, 15));
		label_tongTien.setBounds(245, 131, 90, 20);
		contentPane.add(label_tongTien);
		
		JLabel lblNewLabel_2_7 = new JLabel("VNĐ");
		lblNewLabel_2_7.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_7.setBounds(344, 130, 60, 20);
		contentPane.add(lblNewLabel_2_7);
	
	}		
	public String getSove() {
		Datve d = new Datve();
		return d.getSoVe();
	}
	public String getGiaVe() {
		Chuyendi d = new Chuyendi();
		return d.getGiaVe();
	}
	
	public double getThanhToan() {
		return Math.round(Double.parseDouble(getSove())*Double.parseDouble(getGiaVe()));
	}

}
