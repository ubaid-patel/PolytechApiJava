package App.Repos;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import App.Entities.User;

@Repository
public class TestRepo {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void getuser(User user) {		
		hibernateTemplate.save(user);
	}
}
