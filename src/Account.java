
public class Account {
	
	private int userID;
	private String username;
	private String surname;
	private int houseNumber;
	private String postcode; 
	private String city;
	private String role;
	
	
	public Account(int userID, String username, String surname, int houseNumber, String postcode, String city, String role) {
		this.userID = userID; 
		this.username = username; 
		this.surname = surname;
		this.houseNumber = houseNumber;
		this.postcode = postcode; 
		this.city = city; 
		this.role = role;
	}

	public int getuserID() {
		return(this.userID);
	}
	
	public String getUsername() {
		return(this.username);
	}
	
	public String getSurname() {
		return(this.surname);
	}
	
	public int gethouseNumber() {
		return(this.houseNumber);
	}
	
	public String getPostcode() {
		return(this.postcode);
	}
	
	public String getCity() {
		return(this.city);
	}
	
	public String getRole() {
		return(this.role);
	}

}
