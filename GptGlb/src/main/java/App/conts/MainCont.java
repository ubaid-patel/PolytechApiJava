package App.conts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainCont {
	
	@GetMapping(path={"","/Student","Faculty","Admin","Hod","courses","Admission","About","Register","Login"})
	public String name() {
		return "index";
	}
	
	//Routing for images 
	@GetMapping("/images/{img}")
	public String img_redir(@PathVariable String img) {
		return "redirect:/static/images/"+img;
	}

}
