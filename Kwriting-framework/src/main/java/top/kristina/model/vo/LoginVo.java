package top.kristina.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import top.kristina.model.entry.Role;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LoginVo {

    private Long id;
    private String username;
    private List<Role> roles;
    private String token;
}
