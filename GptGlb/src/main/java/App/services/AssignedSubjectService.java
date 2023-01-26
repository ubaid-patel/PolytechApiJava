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
import App.tokens.SubjectAllotedToken;
import App.tokens.SubjectToken;

@Service
public class AssignedSubjectService {
	@Autowired
	AuthorizeRepo auth;
	
	public List getalloteallotedsubs(AuthToken token) throws SQLException{
		List <SubjectAllotedToken> allotedsubs = new ArrayList<SubjectAllotedToken>();
		if(auth.authorize(token)) {
			String query = "SELECT subjectalloted.sem,subjectalloted.sub,subjectalloted.teacher,users.fullname,"
					+ "subjects.name FROM subjectalloted INNER JOIN users ON users.userid = subjectalloted.teacher"
					+" INNER JOIN subjects ON subjects.code = subjectalloted.sub";
			SqlReadQueryExecuter sqe =  new SqlReadQueryExecuter();
			ResultSet rs =  sqe.executeQuery(query);
			
			if(rs != null) {
				while(rs.next()) {
					SubjectAllotedToken st = new SubjectAllotedToken();
					st.setTeacher(rs.getString("fullname"));
					st.setSub(rs.getString("name"));
					st.setSem(rs.getString("sem"));
					allotedsubs.add(st);
				}
			}else {
				SubjectAllotedToken st = new SubjectAllotedToken();
				st.setTeacher("notsubjects");
				st.setSub("norecords");
				st.setSem("norecords");
				allotedsubs.add(st);
			}
			
		}else {
			SubjectAllotedToken st = new SubjectAllotedToken();
			st.setTeacher("invalidToken");
			st.setSub("invalidToken");
			st.setSem("invalidToken");
			allotedsubs.add(st);
		}
		
		
		
		return allotedsubs;
	}

}
