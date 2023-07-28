package lab.app.service.implementations;

import lab.app.dto.UserDTO;
import lab.app.entities.Owner;
import lab.app.entities.User;
import lab.app.mappers.UserEntityMapper;
import lab.app.repository.UserRepository;
import lab.app.service.abstractions.UserService;
import lab.app.tools.OwnerServiceException;
import lab.app.tools.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private final UserEntityMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserEntityMapper mapper){
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDTO save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteById(long id) throws UserServiceException {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserServiceException(String.format("no such user to delete: %s", user.get().getId()));

        userRepository.deleteById(id);
    }

    @Override
    public UserDTO update(long id, User user) throws UserServiceException {
        Optional<User> somebody = userRepository.findById(id);

        if (somebody.isEmpty())
            throw new UserServiceException(String.format("no such user to delete: %s", id));

        somebody.get().setPassword(user.getPassword());
        somebody.get().setRole(user.getRole());
        somebody.get().setLogin(user.getLogin());

        return mapper.toDto(userRepository.save(somebody.get()));
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public UserDTO getById(long id) throws UserServiceException {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserServiceException(String.format("no such user to delete: %s", id));

        return mapper.toDto(user.get());
    }
}
