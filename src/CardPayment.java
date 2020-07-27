
public class CardPayment {
	private String cardNumber;
	private String CVC; 
	
	public CardPayment(String cardNumber, String CVC) {
		this.cardNumber = cardNumber; 
		this.CVC = CVC;
	}
	
	public boolean checkCard() {
		if (cardNumber.length() == 16 && CVC.length() == 3) {
			return true;
		}
		return false;
	}
}
