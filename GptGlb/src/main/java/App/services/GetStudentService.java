package App.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.Repos.AuthorizeRepo;
import App.Repos.SqlReadQueryExecuter;
import App.tokens.AuthToken;
import App.tokens.getStudentToken;

@Service
public class GetStudentService {
	@Autowired
	AuthorizeRepo auth;
	
	public List getStudent(AuthToken token,String sem)throws SQLException {
		List <getStudentToken> students = new ArrayList<getStudentToken>();
		if(auth.authorize(token)) {
			SqlReadQueryExecuter sas = new SqlReadQueryExecuter();
			ResultSet rs =  sas.executeQuery("SELECT users.userid ,students.sem,users.fullname FROM users"
					+ " INNER JOIN students ON students.regno = users.userid WHERE sem='"+sem+"'");
			
			if(rs != null) {
				while(rs.next()) {
					getStudentToken st = new getStudentToken();
					st.setName(rs.getString("fullname"));
					st.setReg(rs.getString("userid"));
					st.setSem(rs.getString("sem"));
					students.add(st);
				}
			}else {
				getStudentToken st = new getStudentToken();
				st.setName("notfoun");
				st.setReg("notfound");
				st.setSem("0");
				students.add(st);
			}
		}else {
			getStudentToken st = new getStudentToken();
			st.setName("invalidtoken");
			st.setReg("invalidtoken");
			st.setSem("0");
			students.add(st);
		}
		return students;
	}
}
