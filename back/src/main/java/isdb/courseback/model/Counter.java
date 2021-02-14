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
@Table(name = "Counter")
@NoArgsConstructor
@AllArgsConstructor
public class Counter {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "count")
    private int count;
}
