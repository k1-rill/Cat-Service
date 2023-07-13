package lab.app.service.abstractions;
import lab.app.entities.User;

import java.util.List;

public interface UserService {
    User save(User user);
    void deleteById(long id);
    User update(long id, User user);
    List<User> getAll();
    User getById(long id);
}
