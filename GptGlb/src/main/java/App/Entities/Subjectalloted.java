package App.Entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Subjectalloted {

    @Id
    @Column(nullable = false, updatable = false, length = 20)
    private String sub;

    @Column(nullable = false, length = 20)
    private String teacher;

    @Column(nullable = false)
    private String sem;

    @Column(nullable = false, length = 10)
    private String branch;

    public String getSub() {
        return sub;
    }

    public void setSub(final String sub) {
        this.sub = sub;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(final String teacher) {
        this.teacher = teacher;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(final String sem) {
        this.sem = sem;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(final String branch) {
        this.branch = branch;
    }

}
