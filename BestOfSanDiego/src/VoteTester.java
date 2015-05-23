import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class VoteTester {

	@Test
	public void test() throws IOException {
		BestRestaurantVoteCounter tester = new BestRestaurantVoteCounter();
		tester.getGoing();
		assertEquals(4, tester.getWVotes());
		assertEquals(6, tester.getCVotes());
		assertEquals("C Level", tester.getBest());
	}

}
