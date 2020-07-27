import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountAcitons {
	
	private String FileName;
	private ArrayList<Account> accountList;
	
	public AccountAcitons(String FileName, ArrayList<Account> accountList) {
		
		this.FileName = FileName;
		this.accountList = accountList;
		
	}
	
	public ArrayList<Account> getAccounts() {
		Scanner fileScanner = null;
		ArrayList<Account> accountList = new ArrayList<Account>();
		try {
			File inputFile = new File(FileName);
			fileScanner = new Scanner(inputFile);
			Account account = null;
			
			while (fileScanner.hasNextLine()) {
				String[] info = fileScanner.nextLine().split(",") ;
				account = new Account(Integer.parseInt(info[0].trim()), info[1].trim(), info[2].trim(), 
						Integer.parseInt(info[3].trim()), info[4].trim(), info[5].trim(), info[6].trim());
				accountList.add(account);
			}
		}	catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			fileScanner.close();
		}
		return accountList;
	}
	
	public ArrayList<Account> storeCurrentAccount(int userID, ArrayList<Account> accountList) {
		ArrayList<Account> currentAccount = new ArrayList<Account>();
		for (Account account: accountList) {
			if (account.getuserID() == userID) {
				currentAccount.add(account);
			}
		}
		return currentAccount;
	}
}
