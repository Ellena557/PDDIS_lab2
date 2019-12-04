package hello;
//import lombok.Getter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RbkDb")
public class RbkDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private Double currency;

    public RbkDb(){
        super();
    }

    public RbkDb(String date, Double currency){
        super();
        this.currency = currency;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public Double getCurrency() {
        return currency;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCurrency(Double currency) {
        this.currency = currency;
    }

}
