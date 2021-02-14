package isdb.courseback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MinerPartResponse {
    private int minerId;
    private String name;
    private String part;
}
