package App.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.Entities.Users;
import App.Repos.RegisterRepo;

@Service
public class RegisterService {
	@Autowired
	RegisterRepo regrepo;
	
	public String registerUser(Users user) {
		String typ = "STUDENT";
		if(user.getUserRole().toUpperCase().equals(typ)) {
			return regrepo.saveStudent(user);
		}else {
			return regrepo.saveEmployee(user);
		}
		
	}
}
