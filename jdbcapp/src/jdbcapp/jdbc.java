package jdbcapp;

import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/kvcet_training";
		String username = "root";
		String password = "root123";

		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			// executeQuery -> select,
			// executeUpdate -> insert, update, delete
			// execute -> nested queries
			ResultSet rs = stmt.executeQuery("select * from student");
			System.out.println("studId  studName  marks skill");
			while (rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				int marks = rs.getInt(3);
				String skill = rs.getString(4);
				System.out.println(sid + "  " + sname + "\t " + marks + " " + skill);
			}
			rs.close();
			stmt.close();
			con.close();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}