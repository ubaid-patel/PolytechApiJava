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
import App.tokens.getAttendanceToken;

@Service
public class GetAttendanceService {
	@Autowired
	AuthorizeRepo auth;
	
	public List getAttenndance(AuthToken token,String sem,String date,String subject)throws SQLException {
		List <getAttendanceToken> attendance = new ArrayList<getAttendanceToken>();
		if(auth.authorize(token)) {
			SqlReadQueryExecuter sas = new SqlReadQueryExecuter();
			ResultSet rs =  sas.executeQuery("SELECT * FROM attendance INNER JOIN users ON attendance.student = users.userid INNER "
					+ "JOIN students ON attendance.student = students.regno WHERE sem = '"+sem+"' AND date='"+date+"' AND subject='"+subject+"'");
			
			if(rs != null) {
				while(rs.next()) {
					getAttendanceToken st = new getAttendanceToken();
					st.setName(rs.getString("fullname"));
					st.setReg(rs.getString("userid"));
					st.setSem(rs.getString("sem"));
					st.setState(rs.getString("state"));
					attendance.add(st);
				}
			}else {
				getAttendanceToken st = new getAttendanceToken();
				st.setName("notfoun");
				st.setReg("notfound");
				st.setSem("0");
				st.setState("notfound");
				attendance.add(st);
			}
		}else {
			getAttendanceToken st = new getAttendanceToken();
			st.setName("invalidtoken");
			st.setReg("invalidtoken");
			st.setSem("0");
			st.setState("abs");
			attendance.add(st);
		}
		return attendance;
	}
}
