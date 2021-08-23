package invoice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Invoice_Service {
	public static void update(String userid,String product,String quantity,String billamount) {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/storedb;create=true","user","user");
			Statement st  = connection.createStatement();
			st.executeUpdate("insert into app.store values('"+userid+"','"+product+"','"+quantity+"','"+billamount+"')");
			connection.close();
			
		} catch (ClassNotFoundException | SQLException ce) {
			System.out.println("Try restarting the application.");
		}
	}
	public static void Invoice_Display()   
	{
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/storedb;create=true","user","user");
			Statement st  = connection.createStatement();
			String q="Select * from app.store";
			
			ResultSet rs=st.executeQuery(q);
			
			if(rs.next()){
				System.out.println("\n");
				System.out.println("-----------------------------------------------------");
				System.out.format("%10s %10s %10s %20s","userid","product","quantity","bill_amount");
				System.out.println();
				System.out.println("-----------------------------------------------------");
				do{
					System.out.format("%10s %10s %10s %20s",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
					System.out.println();
				}while(rs.next());
				System.out.println("\n");
			}
			else{
				System.out.println("Record Not Found...");
			}
			
			connection.close();
			
		} catch (ClassNotFoundException | SQLException ce) {
			System.out.println("Try restarting the application.");
			}  
		}     
}
