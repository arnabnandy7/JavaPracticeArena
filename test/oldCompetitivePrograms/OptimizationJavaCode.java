package test.oldCompetitivePrograms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OptimizationJavaCode {

	public static void main(String[] args) throws SQLException {
		long start = TimeUnit.MILLISECONDS
				.toSeconds(System.currentTimeMillis());
		double ad = 0;
		for (int i = 0; i < 50000; i++) {
			String a = "hello ";
			a = a + "ns" + i + " asda";

			a = a + "\n ksfknf ";

			a = a + "sdnffn " + "ksnnf";

			a = a + "sdnffn " + "ksnnf";
			for (int j = 0; j < 55; j++) {
				List<HashMap<String, String>> dataList = getData();
			}
			if (i % 10000 == 0) {
				System.out.println("String::" + i);
			}
			ad = new BigDecimal(ad).add(
					new BigDecimal(1).divide(new BigDecimal(216), 8,
							RoundingMode.HALF_EVEN)).doubleValue();
			ad = new BigDecimal(ad).add(
					new BigDecimal(1).divide(new BigDecimal(216), 8,
							RoundingMode.HALF_EVEN)).doubleValue();
			ad = new BigDecimal(ad).add(
					new BigDecimal(1).divide(new BigDecimal(216), 8,
							RoundingMode.HALF_EVEN)).doubleValue();
			ad = new BigDecimal(ad).add(
					new BigDecimal(1).divide(new BigDecimal(216), 8,
							RoundingMode.HALF_EVEN)).doubleValue();
		}

		long end = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

		System.out.println(start + "::" + end + "->" + (end - start));

		start = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
		double ar = 0;
		for (int i = 0; i < 50000; i++) {
			StringBuilder sb = new StringBuilder("hello ");
			sb.append("ns");
			sb.append(i);
			sb.append(" asda");
			sb.append("\n ksfknf ");
			sb.append("sdnffn ");
			sb.append("ksnnf");
			sb.append("sdnffn ");
			sb.append("ksnnf");
			for (int j = 0; j < 55; j++) {
				List<HashMap<String, String>> dataList = getData();
			}
			if (i % 10000 == 0) {
				System.out.println("StringBuilder::" + i);
			}
			ar = ar + 1 / Double.parseDouble("216");
			ar = ar + 1 / Double.parseDouble("216");
			ar = ar + 1 / Double.parseDouble("216");
			ar = ar + 1 / Double.parseDouble("216");

		}

		end = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

		System.out.println(start + "::" + end + "->" + (end - start));

	}

	public static List<HashMap<String, String>> getData() throws SQLException {
		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> dataRow = null;
		Connection con = Database.getInstance().getConnection();
		Statement stmt = con.createStatement();
		StringBuilder querySB = new StringBuilder();
		querySB.append("select emp_id, emp_name, emp_salary from employee");
		try {
			ResultSet rs = stmt.executeQuery(querySB.toString());
			while (rs.next()) {
				dataRow = new HashMap<String, String>();
				dataRow.put("emp_id", rs.getString("emp_id"));
				dataRow.put("emp_name", rs.getString("emp_name"));
				dataRow.put("emp_salary", rs.getString("emp_salary"));
				dataList.add(dataRow);
			}
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return dataList;
	}

}

class Database {

	private static Database dbIsntance;
	private static Connection con;

	private Database() {
	}

	public static Database getInstance() {
		if (dbIsntance == null) {
			dbIsntance = new Database();
		}
		return dbIsntance;
	}

	public Connection getConnection() {

		if (con == null) {
			try {
				String host = "jdbc:postgresql://localhost:5432/system";
				String username = "system";
				String password = "system";
				con = DriverManager.getConnection(host, username, password);
			} catch (SQLException ex) {
				Logger.getLogger(Database.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

		return con;
	}

}