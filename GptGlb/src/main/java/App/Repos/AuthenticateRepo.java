package App.Repos;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.mysql.cj.xdevapi.SessionFactory;

import App.Entities.User;
import App.Entities.Users;
import App.services.SubjectsService;
import App.tokens.AuthToken;

@Repository
public class AuthenticateRepo {
	@Autowired
	HibernateTemplate hibertemp;
	@Autowired 
	SubjectsService subs;
	
	public AuthToken authenticateUser(String mobile,String userPass) throws SQLException {
		Users user = new Users();
		user.setMobile(mobile);
		List<Users> res = hibertemp.findByExample(user);
		AuthToken token = new AuthToken();
		//Logic if user Exist
		if(!res.isEmpty()) {
			if(res.get(0).getUserPassword().equals(userPass)) {
				BCryptPasswordEncoder passencoder = new BCryptPasswordEncoder();
				
				//Generating Token
				token.setAuth("true");
				token.setBranch(res.get(0).getBranch());
				token.setName(res.get(0).getFullname());
				
				token.setToken(passencoder.encode(userPass));
				token.setType(res.get(0).getUserRole());
				token.setUserid(res.get(0).getUserid());
				
				token.setSubjects(subs.getallotesubs(token,res.get(0).getUserid()));
				return token ;
			}
		}
		token.setAuth("false");
		return token ;
	}
}
