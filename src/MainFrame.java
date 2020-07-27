import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<Account> accountList;
	private ArrayList<Account> currentAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Computer Accessories Shop");
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBackground(new Color(153, 204, 204));
		lblTitle.setBounds(0, 6, 674, 36);
		contentPane.add(lblTitle);
		
		JButton btnAdmin = new JButton("User1");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userID = 101;
				AccountAcitons aa = new AccountAcitons("UserAccounts.txt", accountList);
				ArrayList<Account> accountList = aa.getAccounts();
				ArrayList<Account> currentAccount = aa.storeCurrentAccount(userID, accountList);
				AdminFrame adminFrame = new AdminFrame();
				adminFrame.setVisible(true);
			}
		});
		btnAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAdmin.setBounds(278, 114, 117, 29);
		contentPane.add(btnAdmin);
		
		JButton btnNewButton = new JButton("User2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userID = 102;
				ActivityActions ac = new ActivityActions("ActivityLog.txt");
				AccountAcitons aa = new AccountAcitons("UserAccounts.txt", accountList);
				ArrayList<Account> accountList = aa.getAccounts();
				ArrayList<Account> currentAccount = aa.storeCurrentAccount(userID, accountList);
				ac.writeActivity(Integer.toString(userID));
				ac.writeActivity(currentAccount.get(0).getPostcode());
				UserFrame userFrame = new UserFrame();
				userFrame.setVisible(true);
			}
		});
		btnNewButton.setBounds(278, 199, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("User3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userID = 103;
				ActivityActions ac = new ActivityActions("ActivityLog.txt");
				AccountAcitons aa = new AccountAcitons("UserAccounts.txt", accountList);
				ArrayList<Account> accountList = aa.getAccounts();
				ArrayList<Account> currentAccount = aa.storeCurrentAccount(userID, accountList);
				ac.writeActivity(Integer.toString(userID));
				ac.writeActivity(currentAccount.get(0).getPostcode());
				UserFrame userFrame = new UserFrame();
				userFrame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(278, 288, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("User4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userID = 104;
				ActivityActions ac = new ActivityActions("ActivityLog.txt");
				AccountAcitons aa = new AccountAcitons("UserAccounts.txt", accountList);
				ArrayList<Account> accountList = aa.getAccounts();
				ArrayList<Account> currentAccount = aa.storeCurrentAccount(userID, accountList);
				ac.writeActivity(Integer.toString(userID));
				ac.writeActivity(currentAccount.get(0).getPostcode());
				UserFrame userFrame = new UserFrame();
				userFrame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(278, 373, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblSubTitle = new JLabel("Login as:");
		lblSubTitle.setForeground(new Color(255, 255, 255));
		lblSubTitle.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubTitle.setBounds(0, 48, 674, 31);
		contentPane.add(lblSubTitle);
	}
}
