package dts;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.net.URL;
import java.net.HttpURLConnection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class TotalGoalsJson {

    /*
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     */

	public static int getWinnerTotalGoals(String competition, int year) {
        int totalGoals=0;
        try{
        	String team=getWinner(competition, year);
        	System.out.println(team);
        	int team1TotalPages=sendTeam1GETTotalPages(competition, team, year);
        	int team2TotalPages=sendTeam2GETTotalPages(competition, team, year);
        	System.out.println(team1TotalPages+" "+team2TotalPages);
            totalGoals=sendTeam1GET(competition, team, year, team1TotalPages)+sendTeam2GET(competition,team, year, team2TotalPages);
        }catch(Exception e){
            
        }
        
        return totalGoals;
    }
	
	private static String getWinner(String competition, int year) throws IOException {

        String winner="";
        URL obj = new URL("https://jsonmock.hackerrank.com/api/football_competitions?name="+competition+"&year="+year);
        System.out.println("https://jsonmock.hackerrank.com/api/football_competitions?name="+competition+"&year="+year);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        //System.out.println(con.get);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success

            String response=con.getInputStream().toString();
			// print result
            //System.out.println(response.toString());
            JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
            JsonArray arr = jsonObject.getAsJsonArray("data");
            winner = arr.get(0).getAsJsonObject().get("winner").getAsString();
        }
        return winner;
    }

    private static int sendTeam1GET(String competetion, String team, int year, int pages) throws IOException {

        int totalGoals=0;
        for(int i=1;i<=pages;i++){
        	URL obj = new URL("https://jsonmock.hackerrank.com/api/football_matches?competition="+competetion+"&year="+year+"&team1="+team +"&page="+i);
        	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            //System.out.println(con.get);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                //System.out.println(response.toString());
                JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
                System.out.println(jsonObject.get("total_pages").getAsInt());
                JsonArray arr = jsonObject.getAsJsonArray("data");
                for (int j = 0; j < arr.size(); j++) {
                    String post_id = arr.get(j).getAsJsonObject().get("team1goals").getAsString();
                    totalGoals+=Integer.parseInt(post_id);
                }
            }
        }
        
        return totalGoals;
    }
    
    private static int sendTeam1GETTotalPages(String competition, String team, int year) throws IOException {

        int totalLines=0;
        URL obj = new URL("https://jsonmock.hackerrank.com/api/football_matches?competition="+competition+"&year="+year+"&team1="+team);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        //System.out.println(con.get);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                //System.out.println(inputLine);
            }
            in.close();

            // print result
            //System.out.println(response.toString());
            JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
            totalLines=jsonObject.get("total_pages").getAsInt();
        }
        return totalLines;
    }
    
    private static int sendTeam2GETTotalPages(String competition, String team, int year) throws IOException {

        int totalLines=0;
        URL obj = new URL("https://jsonmock.hackerrank.com/api/football_matches?competition="+competition+"&year="+year+"&team2="+team);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println(responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                //System.out.println(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
            totalLines=jsonObject.get("total_pages").getAsInt();
        }
        return totalLines;
    }

    private static int sendTeam2GET(String competition, String team, int year, int pages) throws IOException {

        int totalGoals=0;
        for(int j=1;j<=pages;j++){
        	URL obj = new URL("https://jsonmock.hackerrank.com/api/football_matches?competition="+competition+"&year="+year+"&team2="+team +"&page="+j);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            //System.out.println(con.get);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                    //System.out.println(inputLine);
                }
                in.close();

                // print result
                //System.out.println(response.toString());
                JsonObject jsonObject = new JsonParser().parse(response.toString()).getAsJsonObject();
                JsonArray arr = jsonObject.getAsJsonArray("data");
                for (int i = 0; i < arr.size(); i++) {
                    String post_id = arr.get(i).getAsJsonObject().get("team2goals").getAsString();
                    totalGoals+=Integer.parseInt(post_id);
                }
                
                    System.out.println(totalGoals);
            }
        }
        
        return totalGoals;
    }
     public static void main(String[] args) {
    	 System.out.println(getWinnerTotalGoals("UEFA Champions League", 2011));
	}
}

