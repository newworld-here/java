package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AssignClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish connection
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy", "root", "root");
			System.out.println("Connected");
			String sql = "select * from subjects join teacher where subjects.className = teacher.className";
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				System.out.println("SubjectId " + result.getInt(1));
				System.out.println("Subject Name " + result.getString(2));
				System.out.println("Assigned Class " + result.getString(3));
				System.out.println("Name of Teacher " + result.getString(5));
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
