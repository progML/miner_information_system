package isdb.courseback.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Data
@Table(name = "delivery_auto")
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAuto {

    @Id
    @Column(name = "auto_id")
    private int autoId;
//    @Id
    @Column(name = "miner_id")
    private int minerId;
    @Column(name = "delivery_date")
    private Date deliveryDate;
}
