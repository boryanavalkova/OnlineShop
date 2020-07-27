import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CardPaymentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField inputCardnumber;
	private JTextField inputCVC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardPaymentFrame frame = new CardPaymentFrame();
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
	public CardPaymentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 219);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Card Payment:");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(6, 6, 438, 16);
		contentPane.add(lblTitle);
		inputCardNumber(contentPane);
		lblCardNumber(contentPane);
		inputCVC(contentPane);
		lblCVC(contentPane);
		btnPayCard(contentPane);
	}
	
	public void inputCardNumber(JPanel contentPane) {
		inputCardnumber = new JTextField();
		inputCardnumber.setBounds(31, 71, 180, 26);
		contentPane.add(inputCardnumber);
		inputCardnumber.setColumns(10);
	}
	
	public void lblCardNumber(JPanel contentPane) {
		JLabel lblCardNumber = new JLabel("Card Number:");
		lblCardNumber.setForeground(Color.WHITE);
		lblCardNumber.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCardNumber.setBounds(31, 54, 94, 16);
		contentPane.add(lblCardNumber);
	}
	
	public void inputCVC(JPanel contentPane) {
		inputCVC = new JTextField();
		inputCVC.setBounds(295, 71, 130, 26);
		contentPane.add(inputCVC);
		inputCVC.setColumns(10);
	}
	
	public void lblCVC(JPanel contentPane) {
		JLabel lblCvc = new JLabel("CVC:");
		lblCvc.setForeground(Color.WHITE);
		lblCvc.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCvc.setBounds(307, 51, 42, 22);
		contentPane.add(lblCvc);
	}
	
	
	public void btnPayCard(JPanel contentPane) {
		JButton btnPayCard = new JButton("Pay");
		btnPayCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cvc = inputCVC.getText();
				String cardNumber = inputCardnumber.getText();
				CardPayment cp = new CardPayment(cardNumber, cvc);
				if (cp.checkCard()) {
					ActivityActions ac = new ActivityActions("ActivityLog.txt");
					ac.writeActivity("purchased");
					ac.writeActivity("Credit Card");
					SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");  
				    Date date = new Date();
				    String dateAsString = format.format(date);
					ac.writeActivity(dateAsString);
					PaymentDone PaymentDone = new PaymentDone();
					PaymentDone.setVisible(true);
				} else {
					inputCardnumber.setText("Not valid");
					inputCVC.setText("Not valid");
				}
			}
		});
		btnPayCard.setBounds(136, 129, 175, 29);
		contentPane.add(btnPayCard);
	}

}
