package App.apiconts;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import App.services.GetFacultyService;
import App.services.GetStudentService;
import App.services.GetSubjectService;
import App.services.RegisterService;
import App.services.SqlWriteQueryExecuterService;
import App.services.AllotSubjectService;
import App.services.AssignedSubjectService;
import App.services.GetAttendanceService;
import App.services.SubjectsService;
import App.tokens.AuthToken;
import App.tokens.SubjectToken;
import App.tokens.getFacultyToken;
import App.Entities.*;
import App.Repos.AuthenticateRepo;
import App.Repos.SqlReadQueryExecuter;
import App.Repos.SqlWriteQueryExecuter;

import java.math.BigInteger;
import java.security.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
 

@RestController
@CrossOrigin
public class Apicont {	
	@Autowired
	ApplicationContext context;
	@Autowired
	AuthenticateRepo authenticate;
	@Autowired
	RegisterService registerserv;
	@Autowired
	AssignedSubjectService assigendsubs;
	@Autowired
	GetAttendanceService getattendance;
	@Autowired
	GetFacultyService getfacultyserv;
	@Autowired
	GetStudentService getstudentserv;
	@Autowired
	GetSubjectService getsubserv;
	@Autowired
	SubjectsService subjectsserv;
	@Autowired
	SqlWriteQueryExecuterService sqlqueryexecuter;
	@Autowired
	AllotSubjectService allotsubs;
	
	//Api's End Points
	
	@PostMapping("/api/Authenticate")
	public AuthToken Authenticate(HttpServletRequest request) throws SQLException{
		String mobile = request.getParameter("mobile");
		String pass = request.getParameter("password");
		AuthToken token = authenticate.authenticateUser(mobile, pass);
		return token;
	}
	
	@PostMapping("/api/AssignedSubs")
	public List AssignedSubs(@ModelAttribute AuthToken token) throws SQLException {
		List result =  assigendsubs.getalloteallotedsubs(token);
		return result;
	}
	
	@PostMapping("/api/GetAttendance")
	public List GetAttend(@ModelAttribute AuthToken token,HttpServletRequest request) throws SQLException {
		String sem = request.getParameter("sem");
		String date =request.getParameter("date");
		String subject =request.getParameter("subject");
		List result = getattendance.getAttenndance(token, sem, date, subject);
		return result;
	}
	
	@PostMapping("/api/GetFaculty")
	public List GetFaculty(@ModelAttribute AuthToken token) throws SQLException {
		List result = getfacultyserv.getFaculty(token);
		return result;
	}
	
	@PostMapping("/api/GetStudent")
	public List GetStudent(@ModelAttribute AuthToken token,HttpServletRequest request) throws SQLException {
		String sem = request.getParameter("sem");
		List result = getstudentserv.getStudent(token, sem);
		return result;
	}
	
	@PostMapping("/api/GetSubject")
	public List GetSubject(@ModelAttribute AuthToken token,HttpServletRequest request) throws SQLException {
		String value = request.getParameter("value");
		String type = request.getParameter("type");
		List result = getsubserv.getSubject(token, type, value);
		return result;
	}
	@PostMapping("/api/AllotSubject")
	public String AllotSubject(@ModelAttribute AuthToken token,@ModelAttribute Subjectalloted subject,HttpServletRequest request) throws SQLException {
		String result = allotsubs.allotSubject(subject,token);
		return result;
	}
	
	@PostMapping("/api/SqlWriteQueryExecuter")
	public int SqlWriteQueryExecuter(@ModelAttribute AuthToken token,HttpServletRequest request) {
		String query = request.getParameter("query");
		return sqlqueryexecuter.execute(token, query);
	}
	
	@PostMapping("/api/Register")
	public String Register(@ModelAttribute Users user) {
		String result = registerserv.registerUser(user);
		return result;
	}

}
