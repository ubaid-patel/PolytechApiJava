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
import App.tokens.getFacultyToken;

@Service
public class GetFacultyService {
	@Autowired
	AuthorizeRepo auth;
	
	public List getFaculty(AuthToken token)throws SQLException {
		List <getFacultyToken> subs = new ArrayList<getFacultyToken>();
		if(auth.authorize(token)) {
			SqlReadQueryExecuter sas = new SqlReadQueryExecuter();
			ResultSet rs =  sas.executeQuery("SELECT * FROM users WHERE branch='CS' AND userRole= 'FACULTY'");
			
			if(rs != null) {				
				while(rs.next()) {
					getFacultyToken st = new getFacultyToken();
					st.setName(rs.getString("fullname"));
					st.setUserid(rs.getString("userid"));
					subs.add(st);
				}
			}else {
				getFacultyToken st = new getFacultyToken();
				st.setName("notfoun");
				st.setUserid("notfound");
				subs.add(st);
			}
		}else {
			getFacultyToken st = new getFacultyToken();
			st.setName("invalidoken");
			st.setUserid("invalid");
			subs.add(st);
		}
		
		return subs;
	}
}
