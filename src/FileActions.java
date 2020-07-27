import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileActions {
	
	private String FileName;
	private ArrayList<Item> stockList;
	
	
	
	public FileActions(String FileName, ArrayList<Item> stockList) {
		
		this.FileName = FileName;
		this.stockList = stockList;
		
	}

	public void getStockList() throws IOException {
		
		Scanner fileScanner = null;
		try {
			File inputFile = new File("Stock.txt");
			fileScanner = new Scanner(inputFile);
			Item item = null;
			
			while (fileScanner.hasNextLine()) {
				String[] info = fileScanner.nextLine().split(",") ;
				item = new Item(Integer.parseInt(info[0].trim()), info[1].trim(), 
						info[2].trim(), info[3].trim(), info[4].trim(), info[5].trim(), 
						Integer.parseInt(info[6].trim()), Double.parseDouble(info[7].trim()), 
						Double.parseDouble(info[8].trim()), info[9].trim() );
				stockList.add(item);
			}
		}	catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			fileScanner.close();
		}
		
	}
	
	
	public void writeInStockFile(int Barcode, String Name, String Type, String Brand, String Colour, 
			String Connect, int Quantity, double OGCost, double RetailPrice, String Info) {
		BufferedWriter bw = null;
		try {
			
			bw = new BufferedWriter(new FileWriter("Stock.txt", true));
			bw.write(Barcode + ", " + Name + ", " + Type + ", " + Brand + ", " + Colour + ", " 
			+ Connect + ", " + Quantity + ", " + OGCost + ", " + RetailPrice + ", " + Info + "\n");	

		} catch(IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		finally {
			
			try {
				
				if(bw != null) {
					bw.close();
				}
			
			} catch(IOException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public void findInStockFile(int Barcode, ArrayList<Item> basketList) {
		for (Item item: stockList) {
			if (item.getBarcode() == Barcode) {
				basketList.add(item);
			}
		}
	}
	
	public boolean isItemInStock(int Barcode) {
		for (Item item: stockList) {
			if (item.getBarcode() == Barcode) {
				return true;
			}
		}
		return false;
	}
	
	//not finished does not work
	public void increaseStock(int Barcode, int newQuantity) {
		for (Item item: stockList) {
			if (item.getBarcode() == Barcode) {
				int quantity = item.getQuantityStock();
				item.setQuantityStock(quantity + newQuantity);
				writeInStockFile(item.getBarcode(), item.getDeviceName(), item.getDeviceType(), 
						item.getBrand(), item.getColour(), item.getConnectivity(), quantity, item.getOriginalCost(),
						item.getRetailPrice(), item.getAdditionalInformation());
			}
			}
	}
	
	
	
}
