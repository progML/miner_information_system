package isdb.courseback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "brigade")
@NoArgsConstructor
@AllArgsConstructor
public class Brigade {

    @Id
    @Column(name = "brigade_id")
    private int brigadeId;
    @Column(name = "foreman_id")
    private int foremanId;
}
