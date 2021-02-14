package isdb.courseback.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@IdClass(ScheduleKey.class)
@Table(name = "schedule")
public class Schedule {

    @Id
    @Column(name = "work_date")
    private Date workDate;

    @Id
    @Column(name = "brigade_id")
    private int brigadeId;

    @Id
    @Column(name = "mine_name")
    private String mineName;
}



