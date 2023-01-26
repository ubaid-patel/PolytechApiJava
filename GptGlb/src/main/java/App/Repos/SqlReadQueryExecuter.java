package App.Repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.mysql.cj.jdbc.result.ResultSetImpl;
 

@Repository
public class SqlReadQueryExecuter {
	//Using Jdbc HEre
	String url = "jdbc:mysql://localhost/newgpt";
	String username = "root";
	String pass = "";
	String driver ="com.mysql.cj.jdbc.Driver";
	
	
	
	public ResultSet executeQuery(String query){
		try {
		Connection conn  = DriverManager.getConnection(url, username, pass);
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(query);
		return res;
	}catch(SQLException e) {
		System.out.println(e);
		return null;
	}
}}
