package User;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class lienHe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lienHe frame = new lienHe();
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
	public lienHe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 680);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.LIGHT_GRAY);

        JButton btnNewButton_1 = new JButton("Đặt vé");
        btnNewButton_1.setBackground(SystemColor.activeCaptionBorder);
        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
        menuBar.add(btnNewButton_1);

        JMenu mnNewMenu_2 = new JMenu("Hỗ trợ");
        mnNewMenu_2.setBackground(new Color(255, 255, 255));
        mnNewMenu_2.setFont(new Font("Arial", Font.BOLD, 16));
        mnNewMenu_2.setForeground(new Color(0, 0, 0));
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("CSKH");
        mnNewMenu_2.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Liên hệ");
        mnNewMenu_2.add(mntmNewMenuItem_4);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1283, 614);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Call me now!!");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(478, 199, 332, 62);
        panel.add(lblNewLabel);
	}
}
