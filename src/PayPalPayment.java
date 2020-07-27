
public class PayPalPayment {
	
	private String email;
	
	public PayPalPayment(String email) {
		this.email = email;
	}
	
	public boolean checkEmail() {
		if (email.contains("@")) {
			return true;
		}
		return false;
	}
}
