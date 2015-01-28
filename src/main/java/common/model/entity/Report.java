package common.model.entity;


import javax.persistence.*;
import java.sql.Date;

//Class that embodies the entity of the table 'reports'
@Entity(name = "reports")
public class Report {

    //id column of table 'reports'
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    //start_date column of table 'reports'
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    //end_date column of table 'reports'
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    //performer column of table 'reports'
    @Column(name = "performer", length = 32, nullable = false)
    private String performer;

    //activity column of table 'reports'
    @Column(name = "activity", length = 32, nullable = false)
    private String activity;

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
