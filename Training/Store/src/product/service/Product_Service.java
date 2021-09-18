package product.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class Product_Service {
	static int duplicate = 0;

	public static void Data_Import() {
		String line = "";
		String splitBy = ",";
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader("products.csv"));
			br.readLine();
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] record = line.split(splitBy); // use comma as separator
				try {
					Class.forName("org.apache.derby.jdbc.ClientDriver");
					Connection connection = DriverManager
							.getConnection("jdbc:derby://localhost:1527/ProductDb;create=true", "user", "user");
					PreparedStatement st = connection
							.prepareStatement("insert into app.product values(?,?,?,?,?,?,?,?)");
					st.setString(1, record[0]);
					st.setString(2, record[1]);
					st.setString(3, record[2]);
					st.setString(4, record[3]);
					st.setString(5, record[4]);
					st.setString(6, record[5]);
					st.setString(7, record[6]);
					String x = "";
					if (record[5].equals("0")) {
						st.setString(8, "OUT OF STOCK");
						x = "IN STOCK";
					} else {
						st.setString(8, "IN STOCK");
						x = "OUT OF STOCK";
					}
					
					st.execute();
					connection.close();

				} catch (ClassNotFoundException | SQLException ce) {
					if (ce instanceof SQLIntegrityConstraintViolationException) {
						duplicate++;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (duplicate > 0) {
			System.out.println("\nProduct data already imported.\n");
		}else{
		System.out.println("\n Import Successful \n");
		Product_Service.Data_Display();
		}
	}

	public static void Data_Display() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProductDb;create=true",
					"user", "user");
			Statement st = connection.createStatement();
			String q = "Select * from app.product";
			ResultSet rs = st.executeQuery(q);

			if (rs.next()) {
				System.out.println("\n");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------");
				System.out.format("%5s %20s %10s %20s %20s %10s %10s %20s", "id", "name", "gender", "brand", "category",
						"quantity", "price", "status");
				System.out.println(
						"\n--------------------------------------------------------------------------------------------------------------------------");
				do {
					System.out.format("%5s %20s %10s %20s %20s %10s %10s %20s", rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
							rs.getString(8));
					System.out.println();
				} while (rs.next());
				System.out.println("\n");
			} else {
				System.out.println("Record Not Found...");
			}

			connection.close();

		} catch (ClassNotFoundException | SQLException ce) {

		}
	}

}
