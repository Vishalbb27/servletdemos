package jdbcbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from account");) {
			while (rs.next()) { // Loop through the data
				int accno = rs.getInt(1);
				String lastname = rs.getString(2);
				String firstname = rs.getString(3);
				int bal = rs.getInt(4);
				System.out.println(accno + "|" + lastname + "|" + firstname + "|" + bal);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
