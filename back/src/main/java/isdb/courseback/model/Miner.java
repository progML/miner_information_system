package isdb.courseback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Miner")
@NoArgsConstructor
@AllArgsConstructor
public class Miner {
    @Id
    @Column(name = "miner_id")
    private int minerId;
    @Column(name = "miner_name")
    private String minerName;
    @Column(name = "age")
    private int age;
    @Column(name = "height")
    private int height;
    @Column(name = "weight")
    private int weight;
    @Column(name = "health_group")
    private int healthGroup;
    @Column(name = "air_cylinder")
    private int airCylinder;
}
