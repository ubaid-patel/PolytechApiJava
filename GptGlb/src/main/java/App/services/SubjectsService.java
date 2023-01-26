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
import App.tokens.SubjectToken;

@Service
public class SubjectsService {
	@Autowired AuthorizeRepo auth;
	
	
	public List getallotesubs(AuthToken token,String id) throws SQLException{
		List <SubjectToken> subs = new ArrayList<SubjectToken>();
		if(auth.authorize(token)) {
			String query = "SELECT * FROM `subjectalloted` INNER JOIN subjects ON "
					+ "subjectalloted.sub = subjects.code WHERE subjectalloted.teacher ='"+id+"'";
			SqlReadQueryExecuter sqe =  new SqlReadQueryExecuter();
			ResultSet rs =  sqe.executeQuery(query);
			if(rs != null) {
				while(rs.next()) {
					SubjectToken st = new SubjectToken();
					st.setCode(rs.getString("code"));
					st.setName(rs.getString("name"));
					st.setSem(rs.getString("sem"));
					subs.add(st);
				}
			}else {
				SubjectToken st = new SubjectToken();
				st.setCode("notcode");
				st.setName("notfoun");
				st.setSem("notfound");
				subs.add(st);
			}
		}else {
			SubjectToken st = new SubjectToken();
			st.setCode("invalidToken");
			st.setName("invalidToken");
			st.setSem("0");
			subs.add(st);
		}
		
		
		return subs;
	}

}
