package isdb.courseback.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.sql.Date;

@Data
@AllArgsConstructor
@Builder

public class MagazineDto {

  private int minerId;
  private String name;
  private String part;
  private Date date_work;


}
