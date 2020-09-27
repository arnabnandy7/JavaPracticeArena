package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Enter the agent details");
		System.out.println("Enter the agent name :");
		String agentName;
		try {
			agentName = br.readLine();

			System.out.println("Enter the identification number :");
			String identificationNumber = br.readLine();

			System.out.println("Enter the accountNumber :");
			String accountNumber = br.readLine();

			System.out.println("Enter the creditLimit :");
			double creditLimit = Double.parseDouble(br.readLine());

			// fill the code
			System.out.println("Agent details are\nName : " + agentName);
			System.out.println("Identification Number : "
					+ identificationNumber);
			System.out.println("Account Number : " + accountNumber);
			System.out.println("Credit Limit : " + df.format(creditLimit));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Connection getConnection() {
        ResourceBundle rb = ResourceBundle.getBundle("mysql");
		String url = rb.getString("db.url");
		String username = rb.getString("db.username");
		String password = rb.getString("db.password");
	    // fill the code
        Connection conn = null;
        try{
           Class.forName(rb.getString("db.driver")); 
           
           conn = DriverManager.getConnection(url,username,password);
           
        }catch(SQLException se){
          //Handle errors for JDBC
          se.printStackTrace();
       }catch(Exception e){
          //Handle errors for Class.forName
          e.printStackTrace();
       }finally{
          try{
             if(conn!=null)
                conn.close();
          }catch(SQLException se){
             se.printStackTrace();
          }//end finally try
       }
        
        return conn;
    }
}
