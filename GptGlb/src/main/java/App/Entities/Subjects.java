package App.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Subjects {

    @Id
    @Column(nullable = false, updatable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 20)
    private String code;

    @Column(nullable = false)
    private String sem;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(final String sem) {
        this.sem = sem;
    }

}
