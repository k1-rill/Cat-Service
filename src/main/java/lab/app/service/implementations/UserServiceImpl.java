package lab.app.service.implementations;

import lab.app.entities.User;
import lab.app.repository.UserRepository;
import lab.app.service.abstractions.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(long id, User user) {
        User newUser;
        newUser = userRepository.findById(id).orElseThrow();
        if (newUser == null)
            return null;
        newUser.setLogin(user.getLogin());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
