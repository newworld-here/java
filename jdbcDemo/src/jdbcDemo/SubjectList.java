package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SubjectList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish connection
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy", "root", "root");
			System.out.println("Connected");
			String sql = "select * from subjects";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				System.out.println(result.getInt(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				System.out.println("--------------");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
