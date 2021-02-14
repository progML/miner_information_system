package isdb.courseback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@IdClass(MiningKey.class)
@Table(name = "Mining")
@NoArgsConstructor
@AllArgsConstructor
public class Mining {

    @Id
    @Column(name = "brigade_id")
    private int brigadeId;

    @Id
    @Column(name = "ore_name")
    private String oreName;

    @Column(name = "weight")
    private double weight;

    @Column(name = "date_work")
    private Date dateWork;

}

