package App.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.Repos.AuthorizeRepo;
import App.Repos.SqlWriteQueryExecuter;
import App.tokens.AuthToken;

@Service
public class SqlWriteQueryExecuterService {
	@Autowired
	AuthorizeRepo auth;
	
	public int execute(AuthToken token,String query) {
		if(auth.authorize(token)) {
			SqlWriteQueryExecuter sqe = new SqlWriteQueryExecuter();
			System.out.println("i worked");
			return sqe.executeQuery(query);
		}else {
			System.out.println("Invalid token");
			return 0;
		}
	}
}
