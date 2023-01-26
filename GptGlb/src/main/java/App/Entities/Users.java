package App.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import java.util.Set;


@Entity
public class Users {
	
	 @Transient
	    private String sem;

    @Id
    @Column(nullable = false, updatable = false, length = 20)
    private String userid;

    @Column(nullable = false, length = 50)
    private String fullname;

    @Column(nullable = false, length = 13)
    private String mobile;

    @Column(nullable = false, length = 60)
    private String email;

    @Column(nullable = false, length = 20)
    private String userPassword;

    @Column(nullable = false, length = 20)
    private String userRole;

    @Column(nullable = false, length = 6)
    
    public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	private String branch;

    @OneToMany(mappedBy = "regno")
    private Set<Students> regnoStudentss;

    public String getUserid() {
        return userid;
    }

    public void setUserid(final String userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(final String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(final String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(final String userRole) {
        this.userRole = userRole;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(final String branch) {
        this.branch = branch;
    }

    public Set<Students> getRegnoStudentss() {
        return regnoStudentss;
    }

    public void setRegnoStudentss(final Set<Students> regnoStudentss) {
        this.regnoStudentss = regnoStudentss;
    }

}
