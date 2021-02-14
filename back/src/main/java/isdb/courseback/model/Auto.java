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
@Table(name = "auto")
@NoArgsConstructor
@AllArgsConstructor
public class Auto {

    @Id
    @Column(name = "auto_id")
    int autoId;

    @Column(name = "gasoline_level")
    int gasolineLevel;

}
