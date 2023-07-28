package lab.app.service.abstractions;
import lab.app.dto.UserDTO;
import lab.app.entities.User;

import java.util.List;

public interface UserService {
    UserDTO save(User user);
    void deleteById(long id);
    UserDTO update(long id, User user);
    List<UserDTO> getAll();
    UserDTO getById(long id);
}
