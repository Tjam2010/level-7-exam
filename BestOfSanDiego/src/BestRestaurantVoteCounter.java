import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class BestRestaurantVoteCounter {
	private String bestRestaurant;
	private int cvotes;
	private int wvotes;

	public void getGoing() throws IOException {
		URL fileWithVotes = getClass().getResource("sample-votes.txt");

		ArrayList<String> votes = new ArrayList();
		Scanner scanner = new Scanner(fileWithVotes.openStream());

		while (scanner.hasNextLine()) {
			votes.add(scanner.nextLine());
		}
		scanner.close();

		int votesForSangDeuan = 0, votesForOceanaCoastalKitchen = 0, votesForHomeAndAway = 0;
		setCVotes(0);
		setWVotes(0);
		for (String vote : votes) {
			if (matchesSangDeuan(vote))
				votesForSangDeuan++;
			if (matchesOceanaCoastalKitchen(vote))
				votesForOceanaCoastalKitchen++;
			if (matchesWerewolf(vote)) {
				setWVotes(getWVotes() + 1);
			}
			if (matchesHomeAndAway(vote))
				votesForHomeAndAway++;
			if (matchesCLevel(vote)) {
				setCVotes(getCVotes() + 1);
			}
		}

		System.out.println("Reader's favorite restaurant is: "
				+ calculateWinner(votesForSangDeuan,
						votesForOceanaCoastalKitchen, votesForHomeAndAway));
	}

	private String calculateWinner(int votesForSangDeuan,
			int votesForOceanaCoastalKitchen, int votesForHomeAndAway) {
		int mostVotes = 0;
		setBest(null);
		if (votesForSangDeuan > mostVotes) {
			mostVotes = votesForSangDeuan;
			setBest("Sang Deuan");
		}
		if (votesForOceanaCoastalKitchen > mostVotes) {
			mostVotes = votesForOceanaCoastalKitchen;
			setBest("Oceana Coastal Kitchen");
		}
		if (getWVotes() > mostVotes) {
			mostVotes = getWVotes();
			setBest("Werewolf");
		}
		if (votesForHomeAndAway > mostVotes) {
			mostVotes = votesForHomeAndAway;
			setBest("Home & Away");
		}
		if (getCVotes() > mostVotes) {
			mostVotes = getCVotes();
			setBest("C Level");
		}
		return getBest();
	}

	boolean matchesSangDeuan(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("Sang Deuan")
				|| possibleMatch.equalsIgnoreCase("Sang Duan"))
			return true;
		else
			return false;
	}

	boolean matchesOceanaCoastalKitchen(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("Oceana Coastal Kitchen")
				|| possibleMatch.equalsIgnoreCase("Ocean Coastal"))
			return true;
		else
			return false;
	}

	boolean matchesWerewolf(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("Wherewolf")
				|| possibleMatch.equalsIgnoreCase("Werewolf"))
			return true;
		else
			return false;
	}

	boolean matchesHomeAndAway(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("HomeAndAway")
				|| possibleMatch.equalsIgnoreCase("Home And Away")
				|| possibleMatch.equalsIgnoreCase("Home & Away"))
			return true;
		else
			return false;
	}

	boolean matchesCLevel(String possibleMatch) {
		if (possibleMatch.equalsIgnoreCase("C Level")
				|| possibleMatch.equalsIgnoreCase("C Level  ")
				|| possibleMatch.equalsIgnoreCase("C-Level")
				|| possibleMatch.equalsIgnoreCase("c-level")
				|| possibleMatch.equalsIgnoreCase("c level")
				|| possibleMatch.equalsIgnoreCase("c level ")
				|| possibleMatch.equalsIgnoreCase("C level lounge"))
		{
			System.out.println("c");
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getCVotes() {
		return cvotes;
	}

	public void setCVotes(int votes) {
		cvotes = votes;
	}

	public void setWVotes(int votes) {
		wvotes = votes;
	}

	public int getWVotes() {
		return wvotes;
	}

	public void setBest(String best) {
		bestRestaurant = best;
	}

	public String getBest() {
		return bestRestaurant;
	}
}
