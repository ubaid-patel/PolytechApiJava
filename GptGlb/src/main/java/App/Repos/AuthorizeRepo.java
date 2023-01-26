package App.Repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import App.Entities.Users;
import App.tokens.AuthToken;

@Repository
public class AuthorizeRepo {
	@Autowired
	HibernateTemplate hiber;
	
	public Boolean authorize(AuthToken token) {
		Users user =  hiber.get(Users.class,token.getUserid());
		if(user != null) {
			BCryptPasswordEncoder passencoder = new BCryptPasswordEncoder();
			if( passencoder.matches(user.getUserPassword(), token.getToken())) {
				return true;
			}else {
				return false;
			}
		}else {
			return true;
		}	
}}
