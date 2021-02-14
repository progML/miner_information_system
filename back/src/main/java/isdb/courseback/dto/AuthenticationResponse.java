package isdb.courseback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    private String authenticationToken;
    private int minerId;
    private String username;
    private String part;
    private int brigadeId;
}
