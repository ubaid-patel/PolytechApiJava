package App.Repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlWriteQueryExecuter {
	//Using Jdbc HEre
		String url = "jdbc:mysql://localhost/newgpt?allowMultiQueries=true";
		String username = "root";
		String pass = "";
		String driver ="com.mysql.cj.jdbc.Driver";
		
		
		
		public int executeQuery(String query){
			try {
			Connection conn  = DriverManager.getConnection(url, username, pass);
			Statement stmt = conn.createStatement();
			int res = stmt.executeUpdate(query);
			return res;
		}catch(SQLException e) {
			return 0;
		}
			
}}
