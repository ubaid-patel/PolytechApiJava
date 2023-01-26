package App.tokens;

import java.util.ArrayList;
import java.util.List;

public class AuthToken {
	private String userid;
	private String name;
	private String type;
	private String token;
	private String auth;
	private String branch;
	private List <SubjectToken> subjects;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public List<SubjectToken> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<SubjectToken> subjects) {
		this.subjects = subjects;
	}
	
	
}
