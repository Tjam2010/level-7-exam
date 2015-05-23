import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Bank {
	private List accounts;

	public Bank(List accounts) {
		this.accounts = accounts;
	}

	public void updateBalances() {
		for (Object object : accounts) {
			double interest = calculateInterest((BankAccount) object);
			BankAccount refreshedAccount = (BankAccount) object;
			refreshedAccount.setBalance(refreshedAccount.getBalance() + interest);
		}

	}

	private double calculateInterest(BankAccount account) {
		double money = account.getBalance();
		double percentIncrease = 2.54 / 100;

		Calendar currentCal = Calendar.getInstance(Locale.US);
		currentCal.setTime(new Date());
		
		Calendar initCal = Calendar.getInstance(Locale.US);
		initCal.setTime(account.getDate());
		
		int timeElapsed = initCal.get(Calendar.YEAR) - currentCal.get(Calendar.YEAR);
		if (currentCal.get(Calendar.MONTH) > initCal.get(Calendar.MONTH)
				|| (currentCal.get(Calendar.MONTH) == initCal.get(Calendar.MONTH) && currentCal
						.get(Calendar.DATE) > initCal.get(Calendar.DATE))) {
			timeElapsed--;
		}

		if (timeElapsed < 0)
			timeElapsed = -timeElapsed;

		return timeElapsed * percentIncrease * money;
	}

}

class BankAccount {

	private Date date;
	private double money;

	BankAccount(Date date, double money) {
		this.setDate(date);
		this.setBalance(money);
	}

	public double getBalance() {
		return money;
	}

	public void setDate(Date d) {
		date = d;
	}

	void setBalance(double money) {
		this.money = money;
	}

	public Date getDate() {
		return date;
	}

}
