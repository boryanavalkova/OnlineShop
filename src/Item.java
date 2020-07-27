
public class Item {
	
	private int barcode; 
	private String deviceName;
	private String deviceType;
	private String brand;
	private String colour; 
	private String connectivity;
	private int quantityStock; 
	private double originalCost; 
	private double retailPrice;
	private String additionalInformation;
	
	public Item(int barcode, String deviceName, String deviceType, String brand, String colour, String connectivity,
			int quantityStock, double originalCost, double retailPrice, String additionalInformation) {
		
		this.barcode = barcode;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.brand = brand; 
		this.colour = colour;
		this.connectivity = connectivity; 
		this.quantityStock = quantityStock;
		this.originalCost = originalCost; 
		this.retailPrice = retailPrice;
		this.additionalInformation = additionalInformation; 
		
	}
	
	public int getBarcode() {
		return(this.barcode);
	}
	
	public String getDeviceName() {
		return(this.deviceName);
	}
	
	public String getDeviceType() {
		return(this.deviceType);
	}
	
	public String getBrand() {
		return(this.brand);
	}
	
	public String getColour() {
		return(this.colour);
	}
	
	public String getConnectivity() {
		return(this.connectivity);
	}
	
	public int getQuantityStock() {
		return(this.quantityStock);
	}
	
	public double getOriginalCost() {
		return(this.originalCost);
	}
	
	public double getRetailPrice() {
		return(this.retailPrice);
	}
	
	public String getAdditionalInformation() {
		return(this.additionalInformation);
	}
	
	public void setQuantityStock(int newQuantity) {
		this.quantityStock = newQuantity;
	}

}