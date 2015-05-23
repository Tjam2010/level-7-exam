import static org.junit.Assert.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class BankTest {

	@Test
	public void test() {
		Calendar cal = Calendar.getInstance();
		cal.set(2014, Calendar.MAY, 23, 15, 48, 00);
		Date testDate = cal.getTime();
		BankAccount accountTest = new BankAccount(testDate, 100);
		List<BankAccount> accountList = new ArrayList<BankAccount>();
		accountList.add(accountTest);
		Bank bankTest = new Bank(accountList);
		
		assertEquals(100, accountTest.getBalance(),0);
		
		bankTest.updateBalances();
		
		assertEquals(102.54, accountTest.getBalance(),0);
	}
}
