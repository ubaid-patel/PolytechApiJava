package App.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Students {

    @Id
    private String regno;
    private String sem;

   
    public String getSem() {
        return sem;
    }

    public void setSem(final String sem) {
        this.sem = sem;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(final String regno) {
        this.regno = regno;
    }

}
