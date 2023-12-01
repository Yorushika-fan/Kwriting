package top.kristina.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message =  "Password is required")
    private String password;
}
