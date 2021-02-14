package isdb.courseback.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {

    @NotNull
    private int id;
    @NotBlank(message = "Username is required")
    @Pattern(regexp = "^[a-z]+$", message = "Username must fit pattern")
    private String username;
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "[^а-я]+", message = "Password must fit pattern")
    private String password;

}
