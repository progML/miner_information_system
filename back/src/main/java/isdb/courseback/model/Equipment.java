package isdb.courseback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "equipment")
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    @Id
    @Column(name = "equipment_id")
    private int equipmentId;

    @Column(name = "name")
    private String name;

}
