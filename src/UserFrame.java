import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserFrame extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel allStock;
	private DefaultTableModel filterStock;
	private ArrayList<Item> stockList;
	private ArrayList<Item> basketList = new ArrayList<Item>();
	private JTable table_1;
	private JTextField inputBasket;
	private JTextField sumTotalF;
	BasketActions ba = new BasketActions(basketList);
	private JTextField inputCardnumber;
	private JTextField inputCVC;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrame frame = new UserFrame();
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
	public UserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane(contentPane);
		
		JLabel lblUserTitle = new JLabel("User Panel");
		lblUserTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserTitle.setForeground(new Color(255, 255, 255));
		lblUserTitle.setFont(new Font("Arial", Font.PLAIN, 16));
		lblUserTitle.setBounds(6, 6, 662, 24);
		contentPane.add(lblUserTitle);
	}
	
	public void tabbedPane(JPanel contentPane) {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 33, 674, 451);
		contentPane.add(tabbedPane);
		panelView(tabbedPane);
		panelBasket(tabbedPane);
	}
	
	public void lblSearch(JPanel panel) {
		JLabel lblUserSearch = new JLabel("Filter products:");
		lblUserSearch.setForeground(new Color(255, 255, 255));
		lblUserSearch.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUserSearch.setBounds(6, 6, 111, 16);
		panel.add(lblUserSearch);
		
	}
	
	public void panelView(JTabbedPane tabbedPane) {
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Stock", null, panel_1, null);
		panel_1.setLayout(null);
		scrollPane(panel_1);
		lblFilter(panel_1);
			
	}
	
	public void btnClearFilter(JPanel panel_1, JScrollPane scrollPane) {
		JButton btnClearFilter = new JButton("ClearFilter");
		btnClearFilter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				table(scrollPane);
			}
		});
		btnClearFilter.setBounds(72, 50, 187, 29);
		panel_1.add(btnClearFilter);
	}
	
	public void scrollPane(JPanel panel_1) {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 79, 647, 320);
		panel_1.add(scrollPane);
		table(scrollPane);
		btnClearFilter(panel_1, scrollPane);
		rbtnUK(panel_1, scrollPane);
		rbtnUS(panel_1, scrollPane);
		rbtnRazer(panel_1, scrollPane);
		rbtnLogitech(panel_1, scrollPane);
		
	}
	
	public void table(JScrollPane scrollPane) {
		table_1 = new JTable();
		allStock = new DefaultTableModel();
		allStock.setColumnIdentifiers(new Object[] {"Barcode", "Name", "Type", "Brand", "Colour", "Connectativity", 
				"Stock", "Cost", "Additional Information"});
		allStock.setRowCount(0);
		stockList = new ArrayList<Item>();
		FileActions fa = new FileActions("Stock.txt", stockList);
		try {
			fa.getStockList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Item item: stockList) {
			int itBarcode = item.getBarcode();
			String itName = item.getDeviceName();
			String itType = item.getDeviceType();
			String itBrand = item.getBrand();
			String itColour = item.getColour();
			String itConnect = item.getConnectivity();
			int itStock = item.getQuantityStock();
			//double itOGCost = item.getOriginalCost();
			double itRCost = item.getRetailPrice();
			String itAdd = item.getAdditionalInformation();
			Object[] rowData = new Object[] {itBarcode, itName, itType, itBrand, itColour, itConnect, itStock, 
					 itRCost, itAdd};
			allStock.addRow(rowData);
		}
		table_1.setModel(allStock);
		scrollPane.setViewportView(table_1);
	
	}
	
	public void lblFilter(JPanel panel_1) {
		JLabel lblFilter = new JLabel("Filter by:");
		lblFilter.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFilter.setBounds(6, 6, 61, 16);
		panel_1.add(lblFilter);
	}
	
	public void rbtnUK(JPanel panel_1, JScrollPane scrollPane) {
		JRadioButton rdbtnUKLayout = new JRadioButton("UK Layout");
		rdbtnUKLayout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				filterStock = new DefaultTableModel();
				filterStock.setColumnIdentifiers(new Object[] {"Barcode", "Name", "Type", "Brand", "Colour", "Connectativity", 
						"Stock", "Cost", "Additional Information"});
				filterStock.setRowCount(0);
				FileActions fa = new FileActions("Stock.txt", stockList);
				try {
					fa.getStockList();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Item item: stockList) {
					if (item.getAdditionalInformation().contains("UK")) {
						int itBarcode = item.getBarcode();
						String itName = item.getDeviceName();
						String itType = item.getDeviceType();
						String itBrand = item.getBrand();
						String itColour = item.getColour();
						String itConnect = item.getConnectivity();
						int itStock = item.getQuantityStock();
						double itRCost = item.getRetailPrice();
						String itAdd = item.getAdditionalInformation();
						Object[] rowData = new Object[] {itBarcode, itName, itType, itBrand, itColour, itConnect, itStock, 
								 itRCost, itAdd};
						filterStock.addRow(rowData);
					}
				}
				table_1.setModel(filterStock);
				scrollPane.setViewportView(table_1);
			}
		});
		rdbtnUKLayout.setBounds(72, 2, 95, 23);
		panel_1.add(rdbtnUKLayout);
	}
	
	public void rbtnUS(JPanel panel_1, JScrollPane scrollPane) {
		JRadioButton rdbtnUSLayout = new JRadioButton("US Layout");
		rdbtnUSLayout.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				filterStock = new DefaultTableModel();
				filterStock.setColumnIdentifiers(new Object[] {"Barcode", "Name", "Type", "Brand", "Colour", "Connectativity", 
						"Stock", "Cost", "Additional Information"});
				filterStock.setRowCount(0);
				FileActions fa = new FileActions("Stock.txt", stockList);
				try {
					fa.getStockList();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Item item: stockList) {
					if (item.getAdditionalInformation().contains("US")) {
						int itBarcode = item.getBarcode();
						String itName = item.getDeviceName();
						String itType = item.getDeviceType();
						String itBrand = item.getBrand();
						String itColour = item.getColour();
						String itConnect = item.getConnectivity();
						int itStock = item.getQuantityStock();
						double itRCost = item.getRetailPrice();
						String itAdd = item.getAdditionalInformation();
						Object[] rowData = new Object[] {itBarcode, itName, itType, itBrand, itColour, itConnect, itStock, 
								 itRCost, itAdd};
						filterStock.addRow(rowData);
					}
				}
				table_1.setModel(filterStock);
				scrollPane.setViewportView(table_1);
			}
		});
		rdbtnUSLayout.setBounds(72, 26, 95, 23);
		panel_1.add(rdbtnUSLayout);
	}
	
	public void rbtnRazer(JPanel panel_1, JScrollPane scrollPane ) {
		JRadioButton rdbtnRazer = new JRadioButton("Razer");
		rdbtnRazer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filterStock = new DefaultTableModel();
				filterStock.setColumnIdentifiers(new Object[] {"Barcode", "Name", "Type", "Brand", "Colour", "Connectativity", 
						"Stock", "Cost", "Additional Information"});
				filterStock.setRowCount(0);
				FileActions fa = new FileActions("Stock.txt", stockList);
				try {
					fa.getStockList();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Item item: stockList) {
					if (item.getBrand().contains("Razer")) {
						int itBarcode = item.getBarcode();
						String itName = item.getDeviceName();
						String itType = item.getDeviceType();
						String itBrand = item.getBrand();
						String itColour = item.getColour();
						String itConnect = item.getConnectivity();
						int itStock = item.getQuantityStock();
						double itRCost = item.getRetailPrice();
						String itAdd = item.getAdditionalInformation();
						Object[] rowData = new Object[] {itBarcode, itName, itType, itBrand, itColour, itConnect, itStock, 
								 itRCost, itAdd};
						filterStock.addRow(rowData);
					}
				}
				table_1.setModel(filterStock);
				scrollPane.setViewportView(table_1);
			}
		});
		rdbtnRazer.setBounds(179, 2, 73, 23);
		panel_1.add(rdbtnRazer);
	}
	
	public void rbtnLogitech(JPanel panel_1, JScrollPane scrollPane) {
		JRadioButton rdbtnLogitech = new JRadioButton("Logitech");
		rdbtnLogitech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filterStock = new DefaultTableModel();
				filterStock.setColumnIdentifiers(new Object[] {"Barcode", "Name", "Type", "Brand", "Colour", "Connectativity", 
						"Stock", "Cost", "Additional Information"});
				filterStock.setRowCount(0);
				FileActions fa = new FileActions("Stock.txt", stockList);
				try {
					fa.getStockList();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Item item: stockList) {
					if (item.getBrand().contains("Logitech")) {
						int itBarcode = item.getBarcode();
						String itName = item.getDeviceName();
						String itType = item.getDeviceType();
						String itBrand = item.getBrand();
						String itColour = item.getColour();
						String itConnect = item.getConnectivity();
						int itStock = item.getQuantityStock();
						double itRCost = item.getRetailPrice();
						String itAdd = item.getAdditionalInformation();
						Object[] rowData = new Object[] {itBarcode, itName, itType, itBrand, itColour, itConnect, itStock, 
								 itRCost, itAdd};
						filterStock.addRow(rowData);
					}
				}
				table_1.setModel(filterStock);
				scrollPane.setViewportView(table_1);
			}
		});
		rdbtnLogitech.setBounds(179, 26, 95, 23);
		panel_1.add(rdbtnLogitech);
	}
	
	public void lblBasket(JPanel panel_3) {
		JLabel lblAddBasket = new JLabel("Enter barcode to add to basket:");
		lblAddBasket.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAddBasket.setBounds(6, 208, 206, 16);
		panel_3.add(lblAddBasket);
	}
	
	public void inputBasket(JPanel panel_3) {
		inputBasket = new JTextField();
		inputBasket.setBounds(208, 203, 206, 26);
		panel_3.add(inputBasket);
		inputBasket.setColumns(10);
	}
	
	public void btnAddBasket(JPanel panel_3, JScrollPane scrollPaneBasket) {
		JButton btnAddBasket = new JButton("Add to basket");
		btnAddBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table_2(scrollPaneBasket, panel_3);
				} catch (Exception exc) {
					JLabel lblError = new JLabel("Error: No such item.");
					lblError.setForeground(new Color(153, 0, 0));
					lblError.setBounds(218, 226, 136, 16);
					panel_3.add(lblError);
				}
			}
		});
		btnAddBasket.setBounds(415, 203, 117, 29);
		panel_3.add(btnAddBasket);
	}
	
	public void panelBasket(JTabbedPane tabbedPane) {
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Basket", null, panel_3, null);
		panel_3.setLayout(null);
		scrollPaneBasket(panel_3);
		lblTotal(panel_3);
		btnEmptyBasket(panel_3);
		lblBasket(panel_3);
		inputBasket(panel_3);
		btnPayPal(panel_3);
		btnCard(panel_3);
		btnCalculateTotal(panel_3);
		btnCancel(panel_3);
		
	}
	
	public void scrollPaneBasket(JPanel panel_3) {
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 6, 641, 194);
			panel_3.add(scrollPane);
			btnRefreshBasket(panel_3, scrollPane);
			btnAddBasket(panel_3, scrollPane);
	}
	
	public void lblTotal(JPanel panel_3) {
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(6, 239, 42, 16);
		panel_3.add(lblTotal);
	}
	
	public void sumTotal(JPanel panel_3) {
		sumTotalF = new JTextField();
		sumTotalF.setEnabled(false);
		sumTotalF.setBounds(44, 234, 67, 26);
		panel_3.add(sumTotalF);
		sumTotalF.setColumns(10);
		Double sumDouble = ba.sumTotal();
		String sum = String.valueOf(sumDouble);
		sumTotalF.setText(sum);
		ActivityActions ac = new ActivityActions("ActivityLog.txt");
		ac.writeActivity(inputBasket.getText());
		ac.writeActivity(sumTotalF.getText());
		ac.writeActivity("1");
		
	}
	
	public void btnCalculateTotal (JPanel panel_3) {
		JButton btnCalculateTotal = new JButton("Calculate");
		btnCalculateTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!basketList.isEmpty()) {
					sumTotal(panel_3);
				}
			}
		});
		btnCalculateTotal.setBounds(33, 256, 117, 29);
		panel_3.add(btnCalculateTotal);
	}
	
	public void btnEmptyBasket(JPanel panel_3) {
		JButton btnEmpty = new JButton("Empty basket");
		btnEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ba.emptyBasket();
					sumTotalF.setText("");
				} catch(Exception excp) {
					inputBasket.setText("Basket already empty");
				}
				
			}
		});
		btnEmpty.setBounds(530, 203, 117, 29);
		panel_3.add(btnEmpty);
	}
	
	
	public void btnRefreshBasket(JPanel panel_3, JScrollPane scrollPaneBasket) {
		JButton btnRefreshBasket = new JButton("Refresh");
		btnRefreshBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ba.refreshBasket(scrollPaneBasket);
				sumTotal(panel_3);
			}
		});
		btnRefreshBasket.setBounds(415, 234, 117, 29);
		panel_3.add(btnRefreshBasket);
	}
	
	public void table_2(JScrollPane scrollPaneBasket, JPanel panel_3) {
		try {
			int barcode = Integer.parseInt(inputBasket.getText());
			if (inputBasket.getText().length() == 6) {
				ActivityActions ac = new ActivityActions("ActivityLog.txt");
				ac.writeActivity(inputBasket.getText());
				inputBasket.setText("");
				ba.addToBasket(basketList, barcode, scrollPaneBasket);
			} else {
				inputBasket.setText("Error: item not found");
			}
		} catch(Exception exp){
			inputBasket.setText("Error: item not found");
		}
		
	}
	
	public void btnPayPal(JPanel panel_3) {
		JButton btnPayPal = new JButton("PayPal");
		btnPayPal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!basketList.isEmpty()) {
					PayPalPaymentFrame PayPalPaymentFrame = new PayPalPaymentFrame();
					PayPalPaymentFrame.setVisible(true);
				}
			}
		});
		btnPayPal.setBounds(33, 286, 117, 29);
		panel_3.add(btnPayPal);
	}
	
	public void btnCard(JPanel panel_3) {
		JButton btnCard = new JButton("Card");
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!basketList.isEmpty()) {
					CardPaymentFrame CardPaymentFrame = new CardPaymentFrame();
					CardPaymentFrame.setVisible(true);
				}
			}
		});
		btnCard.setBounds(33, 317, 117, 29);
		panel_3.add(btnCard);
	}
	
	public void btnCancel(JPanel panel_3) {
		JButton btnCancel = new JButton("Cancel order");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActivityActions ac = new ActivityActions("ActivityLog.txt");
				ac.writeActivity("canceled");
				ac.writeActivity(" ");
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");  
			    Date date = new Date();
			    String dateAsString = format.format(date);
				ac.writeActivity(dateAsString);
			}
		});
		btnCancel.setBounds(33, 346, 117, 29);
		panel_3.add(btnCancel);
	}
	

}
