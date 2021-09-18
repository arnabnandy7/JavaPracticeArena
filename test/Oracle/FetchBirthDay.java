package test.Oracle;

import java.sql.*;

// Write a program using JDBC to fetch employees details from table if it's his birthday. 
// (considering leap year birthday case)
public class FetchBirthDay {

	static Connection con = null;

	public static Connection connectDB() {
		try {
			// Importing and registering drivers
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/hotelman", "root", "1234");
			// here,root is the username and 1234 is the
			// password,you can set your own username and
			// password.
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return con;
	}

	public static void main(String[] args) {
		// Step 2: Making connection using
		// Connection type and inbulit function on
		Connection con = null;
		PreparedStatement p = null;
		ResultSet rs = null;

		con = connectDB();

		// Try block to catch exception/s
		try {

			// SQL command data stored in String datatype
			String sql = "select * from employee where DAY(birth_day)=DAY(current_date) and"
					+ " MONTH(birth_day)=MONTH(current_date) ";
			p = con.prepareStatement(sql);
			rs = p.executeQuery();

			// Printing ID, name, email of customers
			// of the SQL command above
			System.out.println("id\t\tname\t\temail");

			// Condiion check
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				System.out.println(id + "\t\t" + name + "\t\t" + email);
			}
		}

		// Catch block to handle exception
		catch (SQLException e) {

			// Print exception pop-up on scrreen
			System.out.println(e);
		}
	}
}