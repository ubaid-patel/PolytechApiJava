package App.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import App.Entities.Subjectalloted;
import App.Repos.AuthorizeRepo;
import App.tokens.AuthToken;

@Repository
public class AllotSubjectService {
	@Autowired
	HibernateTemplate hiber;
	@Autowired 
	AuthorizeRepo auth;
	
	@Transactional
	public String allotSubject(Subjectalloted subject,AuthToken token) {
		if(auth.authorize(token)) {
			System.out.println(subject.getSub());
			String res = (String) hiber.save(subject);
			if(res != null ) {
				return "1";
			}else {
				return "0";
			}
		}else {
			return "0";
		}
	}

}
