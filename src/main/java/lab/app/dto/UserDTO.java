package lab.app.dto;

import lab.app.entities.Owner;
import lab.app.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
public @Data class UserDTO {

    @NonNull
    private long id;

    @NonNull
    private String login;

    @NonNull
    private String password;

    @NonNull
    private Role role;

    @NonNull
    private Owner catOwner;

}
