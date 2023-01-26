package App.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class Attendance {

    @Id
    @Column(nullable = false, updatable = false, length = 20)
    private String subject;

    @Column(nullable = false, length = 20)
    private String teacher;

    @Column(nullable = false, length = 20)
    private String student;

    @Column(nullable = false, length = 20)
    private String state;

    @Column(nullable = false)
    private LocalDate date;

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(final String teacher) {
        this.teacher = teacher;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(final String student) {
        this.student = student;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

}
