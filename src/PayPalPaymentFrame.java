import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class PayPalPaymentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField inputEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayPalPaymentFrame frame = new PayPalPaymentFrame();
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
	public PayPalPaymentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 169);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTitle(contentPane);
		lblEmail(contentPane);
		inputEmail(contentPane);
		btnPay(contentPane);
	}
	
	public void lblTitle(JPanel contentPane) {
		JLabel lblTitle = new JLabel("PayPal Payment:");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTitle.setBounds(6, 6, 436, 16);
		contentPane.add(lblTitle);
	}
	
	public void lblEmail(JPanel contentPane) {
		JLabel lblEmail = new JLabel("Enter email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmail.setBounds(181, 34, 94, 16);
		contentPane.add(lblEmail);
	}
	
	public void inputEmail(JPanel contentPane) {
		inputEmail = new JTextField();
		inputEmail.setBounds(121, 62, 195, 26);
		contentPane.add(inputEmail);
		inputEmail.setColumns(10);
	}
	
	public void btnPay(JPanel contentPane) {
		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = inputEmail.getText();
				PayPalPayment pp = new PayPalPayment(email);
				if (pp.checkEmail()) {
					ActivityActions ac = new ActivityActions("ActivityLog.txt");
					ac.writeActivity("purchased");
					ac.writeActivity("PayPal");
					SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");  
				    Date date = new Date();
				    String dateAsString = format.format(date);
					ac.writeActivity(dateAsString);
					PaymentDone PaymentDone = new PaymentDone();
					PaymentDone.setVisible(true);
				} else {
					inputEmail.setText("Not valid");
				}
			}
		});
		btnPay.setBounds(158, 100, 117, 29);
		contentPane.add(btnPay);
	}

}
