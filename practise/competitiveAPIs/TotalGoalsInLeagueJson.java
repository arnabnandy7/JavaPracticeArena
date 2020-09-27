package practise.competitiveAPIs;

import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Dependencies : gson-2.3.1.jar
 * 
 * @author arnab
 *
 */

public class TotalGoalsInLeagueJson {

	/*
	 * Complete the 'getTotalGoals' function below.
	 * 
	 * The function is expected to return an INTEGER. The function accepts
	 * following parameters: 1. STRING team 2. INTEGER year
	 */

	public static int getWinnerTotalGoals(String competition, int year) {
		int totalGoals = 0;
		try {
			String team = getWinner(competition, year);
			int team1TotalPages = getTotalPagesForTeam1(competition, team, year);
			int team2TotalPages = getTotalPagesForTeam2(competition, team, year);
			totalGoals = getTotalGoalsOfTeam1(competition, team, year,
					team1TotalPages)
					+ getTotalGoalsOfTeam2(competition, team, year,
							team2TotalPages);
		} catch (Exception e) {

		}

		return totalGoals;
	}

	private static String getWinner(String competition, int year)
			throws IOException {

		String winner = "";
		URL obj = new URL(
				"https://jsonmock.hackerrank.com/api/football_competitions");

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestProperty("name", competition);
		con.setRequestProperty("year", String.valueOf(year));
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success

			String response = getResponseContent(con);
			// print result
			JsonObject jsonObject = new JsonParser().parse(response.toString())
					.getAsJsonObject();
			JsonArray arr = jsonObject.getAsJsonArray("data");
			winner = arr.get(0).getAsJsonObject().get("winner").getAsString();
		}
		return winner;
	}

	private static int getTotalGoalsOfTeam1(String competition, String team,
			int year, int pages) throws IOException {

		int totalGoals = 0;
		for (int i = 1; i <= pages; i++) {

			StringBuilder urlSb = new StringBuilder();
			urlSb.append("https://jsonmock.hackerrank.com/api/football_matches?");
			urlSb.append("competition=");
			urlSb.append(competition.replace(" ", "%20"));
			urlSb.append("&year=");
			urlSb.append(year);
			urlSb.append("&team1=");
			urlSb.append(team.replace(" ", "%20"));
			urlSb.append("&page=");
			urlSb.append(String.valueOf(i));

			URL obj = new URL(urlSb.toString());
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				String response = getResponseContent(con);

				JsonObject jsonObject = new JsonParser().parse(
						response.toString()).getAsJsonObject();
				JsonArray arr = jsonObject.getAsJsonArray("data");
				for (int j = 0; j < arr.size(); j++) {
					String post_id = arr.get(j).getAsJsonObject()
							.get("team1goals").getAsString();
					totalGoals += Integer.parseInt(post_id);
				}
			}
		}

		return totalGoals;
	}

	/**
	 * @param con
	 * @return
	 * @throws IOException
	 */
	private static String getResponseContent(HttpURLConnection con)
			throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

	private static int getTotalPagesForTeam1(String competition, String team,
			int year) throws IOException {

		int totalLines = 0;
		StringBuilder urlSb = new StringBuilder();
		urlSb.append("https://jsonmock.hackerrank.com/api/football_matches?");
		urlSb.append("competition=");
		urlSb.append(competition.replace(" ", "%20"));
		urlSb.append("&year=");
		urlSb.append(year);
		urlSb.append("&team1=");
		urlSb.append(team.replace(" ", "%20"));
		URL obj = new URL(urlSb.toString());

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			String response = getResponseContent(con);

			// print result
			JsonObject jsonObject = new JsonParser().parse(response.toString())
					.getAsJsonObject();
			totalLines = jsonObject.get("total_pages").getAsInt();
		}
		return totalLines;
	}

	private static int getTotalPagesForTeam2(String competition, String team,
			int year) throws IOException {

		int totalLines = 0;

		StringBuilder urlSb = new StringBuilder();
		urlSb.append("https://jsonmock.hackerrank.com/api/football_matches?");
		urlSb.append("competition=");
		urlSb.append(competition.replace(" ", "%20"));
		urlSb.append("&year=");
		urlSb.append(year);
		urlSb.append("&team2=");
		urlSb.append(team.replace(" ", "%20"));

		URL obj = new URL(urlSb.toString());
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			String response = getResponseContent(con);

			// print result
			JsonObject jsonObject = new JsonParser().parse(response.toString())
					.getAsJsonObject();
			totalLines = jsonObject.get("total_pages").getAsInt();
		}
		return totalLines;
	}

	private static int getTotalGoalsOfTeam2(String competition, String team,
			int year, int pages) throws IOException {

		int totalGoals = 0;
		for (int j = 1; j <= pages; j++) {

			StringBuilder urlSb = new StringBuilder();
			urlSb.append("https://jsonmock.hackerrank.com/api/football_matches?");
			urlSb.append("competition=");
			urlSb.append(competition.replace(" ", "%20"));
			urlSb.append("&year=");
			urlSb.append(year);
			urlSb.append("&team2=");
			urlSb.append(team.replace(" ", "%20"));
			urlSb.append("&page=");
			urlSb.append(String.valueOf(j));

			URL obj = new URL(urlSb.toString());
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				String response = getResponseContent(con);

				// print result
				JsonObject jsonObject = new JsonParser().parse(
						response.toString()).getAsJsonObject();
				JsonArray arr = jsonObject.getAsJsonArray("data");
				for (int i = 0; i < arr.size(); i++) {
					String post_id = arr.get(i).getAsJsonObject()
							.get("team2goals").getAsString();
					totalGoals += Integer.parseInt(post_id);
				}
			}
		}

		return totalGoals;
	}

	public static void main(String[] args) {
		System.out.println(getWinnerTotalGoals("UEFA Champions League", 2011));
	}
}
