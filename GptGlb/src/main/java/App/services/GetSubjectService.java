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
import App.tokens.getSubjectToken;
import App.tokens.getSubjectToken;

@Service
public class GetSubjectService {
	@Autowired
	AuthorizeRepo auth;
	
	public List getSubject(AuthToken token,String type,String value)throws SQLException {
		List <getSubjectToken> subs = new ArrayList<getSubjectToken>();
		String typ = "sem";
		String query;
		
		if(auth.authorize(token)) {
			if(type.toLowerCase().equals(typ)) {
				query = "SELECT * FROM subjects WHERE sem='"+value+"'";
				System.out.println("iam sem"+value);
			}else {
				System.out.println("iam code");
				query = "SELECT * FROM subjects WHERE code='"+value+"'";
			}
			
			SqlReadQueryExecuter sas = new SqlReadQueryExecuter();
			ResultSet rs =  sas.executeQuery(query);
			
			if(rs != null) {
				while(rs.next()) {
					getSubjectToken st = new getSubjectToken();
					st.setName(rs.getString("name"));
					st.setCode(rs.getString("code"));
					subs.add(st);
				}
			}else {
				getSubjectToken st = new getSubjectToken();
				st.setName("notfoun");
				st.setCode("notfound");
				subs.add(st);
			}
		}else {
			getSubjectToken st = new getSubjectToken();
			st.setName("invalidToken");
			st.setCode("invalidtoken");
			subs.add(st);
		}
		
		
		
		
		
		
		
		return subs;
	}
}
