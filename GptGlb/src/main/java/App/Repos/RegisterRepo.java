package App.Repos;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import App.Entities.Students;
import App.Entities.User;
import App.Entities.Users;

@Repository
public class RegisterRepo {
	@Autowired
	private HibernateTemplate hiber;
	
	@Transactional
	public String saveEmployee(Users user) {
		String r;
		r = (String) hiber.save(user);
		
		if(r.equals(user.getUserid())) {
			return "1";
		}else {
			return "0";
		}
	}
	
	@Transactional
	public String saveStudent(Users user) {
		Students stud = new Students();
		stud.setRegno(user.getUserid());
		stud.setSem(user.getSem());
	
		String r;
		r = (String) hiber.save(user);
		hiber.save(stud);
		
		if(r.equals(user.getUserid())) {
			return "1";
		}else {
			return "0";
		}
		
	}
}
