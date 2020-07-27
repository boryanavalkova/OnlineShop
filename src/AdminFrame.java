import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class AdminFrame extends JFrame{

	private JPanel contentPane;
	private JTextField searchAdminInput;
	private DefaultTableModel allStock;
	private ArrayList<Item> stockList;
	private JTable table_1;
	private JTabbedPane tabbedPane;
	private JPanel panel_4;
	private JTextField inputBarcode;
	private JTextField inputType;
	private JTextField inputBrand;
	private JTextField inputColour;
	private JTextField inputConnect;
	private JTextField inputQuantity;
	private JTextField inputOGCost;
	private JTextField inputRetailPrice;
	private JTextField inputInfo;
	private JTextField inputMBarcode;
	private JTextField inputDevice;
	private JTextField inputProgress;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane(contentPane);
		lblAdminPanel(contentPane);
				
	}
	
	public void tabbedPane(JPanel contentPane) {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(95, 158, 160));
		tabbedPane.setBounds(0, 23, 674, 455);
		contentPane.add(tabbedPane);
		panelStock(tabbedPane);
		panelProduct(tabbedPane);

		
	}

	public void panelProduct(JTabbedPane tabbedPane) {
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		tabbedPane.addTab("Add a product", null, panel_1, null);
		panel_1.setLayout(null);
		lblBarcode(panel_1);
		inputBarcode(panel_1);
		lblDevice(panel_1);
		inputDevice(panel_1);
		lblType(panel_1);
		inputType(panel_1);
		lblBrand(panel_1);
		inputBrand(panel_1);
		lblColour(panel_1);
		inputColour(panel_1);
		lblConnect(panel_1);
		inputConnect(panel_1);
		lblQunatity(panel_1);
		inputQuantity(panel_1);
		lblOriginalCost(panel_1);
		inputOGCost(panel_1);
		lblRegularPrice(panel_1);
		inputRegularPrice(panel_1);
		lblInfo(panel_1);
		inputInfo(panel_1);
		btnAdd(panel_1);
		inputProgress(panel_1);
	}
	
	public void lblBarcode(JPanel panel_1) {
		JLabel lblBarcode = new JLabel("Enter barcode:");
		lblBarcode.setForeground(Color.WHITE);
		lblBarcode.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBarcode.setBounds(52, 11, 100, 16);
		panel_1.add(lblBarcode);
	}
	
	public void inputBarcode(JPanel panel_1) {
		inputBarcode = new JTextField();
		inputBarcode.setBounds(152, 6, 130, 26);
		panel_1.add(inputBarcode);
		inputBarcode.setColumns(10);
	}
	
	public void lblDevice(JPanel panel_1) {
		JLabel lblDevice = new JLabel("Enter name:");
		lblDevice.setForeground(Color.WHITE);
		lblDevice.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDevice.setBounds(62, 39, 90, 16);
		panel_1.add(lblDevice);
	}
	
	public void inputDevice (JPanel panel_1) {
		inputDevice = new JTextField();
		inputDevice.setBounds(152, 34, 130, 26);
		panel_1.add(inputDevice);
		inputDevice.setColumns(10);
	}
	
	public void lblType(JPanel panel_1) {
		JLabel lblType = new JLabel("Enter dev type:");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Arial", Font.PLAIN, 14));
		lblType.setBounds(52, 67, 100, 16);
		panel_1.add(lblType);
	}
	
	public void inputType(JPanel panel_1) {
		inputType = new JTextField();
		inputType.setColumns(10);
		inputType.setBounds(152, 62, 130, 26);
		panel_1.add(inputType);
	}
	
	public void lblBrand(JPanel panel_1) {
		JLabel lblBrand = new JLabel("Enter brand:");
		lblBrand.setForeground(Color.WHITE);
		lblBrand.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBrand.setBounds(65, 100, 90, 16);
		panel_1.add(lblBrand);
	}
	
	public void inputBrand(JPanel panel_1) {
		inputBrand = new JTextField();
		inputBrand.setColumns(10);
		inputBrand.setBounds(152, 95, 130, 26);
		panel_1.add(inputBrand);
	}
	
	public void lblColour(JPanel panel_1) {
		JLabel lblColour = new JLabel("Enter colour:");
		lblColour.setForeground(Color.WHITE);
		lblColour.setFont(new Font("Arial", Font.PLAIN, 14));
		lblColour.setBounds(65, 133, 87, 16);
		panel_1.add(lblColour);
	}
	
	public void inputColour(JPanel panel_1) {
		inputColour = new JTextField();
		inputColour.setColumns(10);
		inputColour.setBounds(152, 128, 130, 26);
		panel_1.add(inputColour);
	}
	
	public void lblConnect(JPanel panel_1) {
		JLabel lblConnect = new JLabel("Enter connectivity:");
		lblConnect.setForeground(Color.WHITE);
		lblConnect.setFont(new Font("Arial", Font.PLAIN, 14));
		lblConnect.setBounds(29, 166, 123, 16);
		panel_1.add(lblConnect);
	}
	
	public void inputConnect(JPanel panel_1) {
		inputConnect = new JTextField();
		inputConnect.setColumns(10);
		inputConnect.setBounds(152, 161, 130, 26);
		panel_1.add(inputConnect);
	}
	
	public void lblQunatity(JPanel panel_1) {
		JLabel lblQunatity = new JLabel("Enter quantity:");
		lblQunatity.setForeground(Color.WHITE);
		lblQunatity.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQunatity.setBounds(52, 199, 100, 16);
		panel_1.add(lblQunatity);
	}
	
	public void inputQuantity(JPanel panel_1) {
		inputQuantity = new JTextField();
		inputQuantity.setColumns(10);
		inputQuantity.setBounds(152, 194, 130, 26);
		panel_1.add(inputQuantity);
	}
	
	public void lblOriginalCost(JPanel panel_1) {
		JLabel lblOriginalCost = new JLabel("Enter original cost:");
		lblOriginalCost.setForeground(Color.WHITE);
		lblOriginalCost.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOriginalCost.setBounds(29, 231, 123, 16);
		panel_1.add(lblOriginalCost);
	}
	
	public void inputOGCost(JPanel panel_1) {
		inputOGCost = new JTextField();
		inputOGCost.setColumns(10);
		inputOGCost.setBounds(152, 226, 130, 26);
		panel_1.add(inputOGCost);
	}
	
	public void lblRegularPrice(JPanel panel_1) {
		JLabel lblRetailPrice = new JLabel("Enter retail price:");
		lblRetailPrice.setForeground(Color.WHITE);
		lblRetailPrice.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRetailPrice.setBounds(39, 264, 113, 16);
		panel_1.add(lblRetailPrice);
	}
	
	public void inputRegularPrice(JPanel panel_1) {
		inputRetailPrice = new JTextField();
		inputRetailPrice.setColumns(10);
		inputRetailPrice.setBounds(152, 259, 130, 26);
		panel_1.add(inputRetailPrice);
	}
	
	public void lblInfo(JPanel panel_1) {
		JLabel lblInfo = new JLabel("Additional information:");
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblInfo.setBounds(6, 298, 146, 16);
		panel_1.add(lblInfo);
	}
	
	public void inputInfo(JPanel panel_1) {
		inputInfo = new JTextField();
		inputInfo.setColumns(10);
		inputInfo.setBounds(152, 293, 130, 26);
		panel_1.add(inputInfo);
	}
	
	public void inputProgress(JPanel panel_1) {
		inputProgress = new JTextField();
		inputProgress.setEditable(false);
		inputProgress.setBounds(152, 362, 130, 26);
		panel_1.add(inputProgress);
		inputProgress.setColumns(10);
	}
	
	public void btnAdd(JPanel panel_1) {
		JButton btnKAdd = new JButton("Add item");
		btnKAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileActions fa = new FileActions("Stock.txt", stockList);
					fa.getStockList();
					int Barcode = Integer.parseInt(inputBarcode.getText());
					int Quantity = Integer.parseInt(inputQuantity.getText());
					if (fa.isItemInStock(Barcode)) {
						inputProgress.setText("Item already exists");
					} else {
						String Name = inputDevice.getText();
						String Type = inputType.getText();
						String Brand = inputBrand.getText();
						String Colour = inputColour.getText();
						String Connect = inputConnect.getText();
						double OGCost = Double.parseDouble(inputOGCost.getText());
						double RetailPrice = Double.parseDouble(inputRetailPrice.getText());
						String Info = inputInfo.getText();
						fa.writeInStockFile(Barcode, Name, Type, Brand, Colour, Connect, Quantity, OGCost, RetailPrice, Info);
						inputProgress.setText("Item added");
					}
					
				} catch (Exception exp) {
					inputProgress.setText("Error: invalid item");
				}
				
			}
		});
		btnKAdd.setBounds(152, 331, 130, 29);
		panel_1.add(btnKAdd);
	}
	
	public void panelStock(JTabbedPane tabbedPane) {
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(32, 178, 170));
		tabbedPane.addTab("Stock", null, panel_4, null);
		scrollPane(panel_4);	
	}
	
	public void scrollPane(JPanel panel_3) {
		panel_4.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 6, 653, 354);
		panel_3.add(scrollPane);
		table(scrollPane);
		btnRefresh(scrollPane);
	}
	
	public void btnRefresh(JScrollPane scrollPane) {
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table(scrollPane);
			}
		});
		btnRefresh.setBounds(536, 372, 117, 29);
		panel_4.add(btnRefresh);
	}
	
	public void table(JScrollPane scrollPane) {
		table_1 = new JTable();
		allStock = new DefaultTableModel();
		allStock.setColumnIdentifiers(new Object[] {"Barcode", "Name", "Type", "Brand", "Colour", "Connectativity", 
				"Stock", "Original Cost", "Retail Cost", "Additional Information"});
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
			double itOGCost = item.getOriginalCost();
			double itRCost = item.getRetailPrice();
			String itAdd = item.getAdditionalInformation();
			Object[] rowData = new Object[] {itBarcode, itName, itType, itBrand, itColour, itConnect, itStock, 
					itOGCost, itRCost, itAdd};
			allStock.addRow(rowData);
		}
		table_1.setModel(allStock);
		scrollPane.setViewportView(table_1);
		
	}
	
	public void lblAdminPanel(JPanel contentPane) {
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setForeground(new Color(255, 255, 255));
		lblAdminPanel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAdminPanel.setBounds(0, 6, 674, 16);
		contentPane.add(lblAdminPanel);
	}
}
