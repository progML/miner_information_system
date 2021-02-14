package isdb.courseback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "message_miner")
@NoArgsConstructor
@AllArgsConstructor
public class MessageMiner {

    @Id
    @Column(name = "message_id", columnDefinition = "SERIAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int messageId;

    @Column(name = "miner_id")
    int minerId;

    @Column(name = "status")
    String status;

    @Column(name = "description")
    String description;

}


