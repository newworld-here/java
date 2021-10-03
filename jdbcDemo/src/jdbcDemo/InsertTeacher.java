package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish connection
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/learneracademy", "root", "root");
			System.out.println("Connected");
			String sql = "insert into teacher values(4,'Shyam', 'three')";
			Statement statement = connect.createStatement();
			
			int count = statement.executeUpdate(sql);
//			System.out.println(count);
			if (count > 0) {
				System.out.println("Teacher Inserted");
			} else {
				System.out.println("not inserted");
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
