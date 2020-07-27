import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BasketActions {
	
	private ArrayList<Item> basketList;
	private JTable table_2;
	private JTable table_3;
	private ArrayList<Item> stockCountList;
	private DefaultTableModel basketStockUpdate;
	
	public BasketActions(ArrayList<Item> basketList) {
		
		this.basketList = basketList;
		
	}
	
	public void addToBasket(ArrayList<Item> basketList, int barcode, JScrollPane scrollPaneBasket) {
		table_2 = new JTable();
		
		stockCountList = new ArrayList<Item>();
		basketStockUpdate = new DefaultTableModel();
		basketStockUpdate.setColumnIdentifiers(new Object[] {"Barcode", "Name", "Type", "Brand", "Colour", "Connectativity", 
				"Stock", "Cost", "Additional Information"});
		basketStockUpdate.setRowCount(0);
		
		FileActions fa = new FileActions("Stock.txt", stockCountList);
		try {
			fa.getStockList();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (barcode >= 100000) {
			fa.findInStockFile(barcode, basketList);
			for (Item item: basketList) {
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
					basketStockUpdate.addRow(rowData);
			}
			table_2.setModel(basketStockUpdate);
			scrollPaneBasket.setViewportView(table_2);
		}
	}
	
	public void refreshBasket(JScrollPane scrollPaneBasket) {
		if(!basketList.isEmpty()){
			table_3 = new JTable();
			basketStockUpdate.setRowCount(0);
			for (Item item: basketList) {
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
				basketStockUpdate.addRow(rowData);
		}
			table_3.setModel(basketStockUpdate);
			scrollPaneBasket.setViewportView(table_3);
	}}
	
	public void emptyBasket() {
		basketStockUpdate.setRowCount(0);
		basketList.clear();
		
	}
	
	public double sumTotal() {
		double sum = 0.0;
		for (Item item: basketList) {
			double itRCost = item.getRetailPrice();
			sum = sum + itRCost;
		} return sum;
	}
}
