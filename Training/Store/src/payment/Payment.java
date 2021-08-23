package payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Payment {
	public static void creditPayment(String username,String bill_amount) {
		try {
			int bi = Integer.parseInt(bill_amount);
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/payment;create=true",
					"user", "user");
			con.setAutoCommit(false);
			Statement statement = con.createStatement();
			ResultSet rs =  statement.executeQuery("SELECT * FROM app.payment where userid='"+username+"'");
			rs.next();
			String d = rs.getString(2);
			int limit = Integer.parseInt(d);
			int balance = limit-bi;
			PreparedStatement st = con.prepareStatement("update app.payment set credit_card=? where userid=?");
			st.setString(2, username);
			st.setInt(1, balance);
			st.executeUpdate();
			if(balance>=0 && limit>=bi ){
				con.commit();
				System.out.println("Bill payment approved");
			}
			else {
				con.rollback();
				System.out.println("Credit limit is breached");
				System.out.println("Transaction Failed");
				System.exit(4);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Try restarting the application.");
		}
		
	}
	public static void debitPayment(String username,String bill_amount) {
		try {
			int bi = Integer.parseInt(bill_amount);
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/payment;create=true",
					"user", "user");
			con.setAutoCommit(false);
			Statement statement = con.createStatement();
			ResultSet rs =  statement.executeQuery("SELECT * FROM app.payment where userid='"+username+"'");
			rs.next();
			String d = rs.getString(3);
			int limit = Integer.parseInt(d);
			int balance = limit-bi;
			PreparedStatement st = con.prepareStatement("update app.payment set debit_card=? where userid=?");
			st.setString(2, username);
			st.setInt(1, balance);
			st.executeUpdate();
			if(balance>=0 && limit>=bi ){
				con.commit();
				System.out.println("Bill payment approved");
			}
			else {
				con.rollback();
				System.out.println("Transaction Failed");
				System.exit(4);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Try restarting the application.");
		}
		
	}
}
