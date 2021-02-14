package isdb.courseback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Brigade_record")
@NoArgsConstructor
@AllArgsConstructor
public class BrigadeRecord {

    @Id
    @Column(name = "miner_id")
    private int minerId;

    @Column(name = "brigade_id")
    private int brigadeId;

    @Column(name = "part")
    private String part;
}
