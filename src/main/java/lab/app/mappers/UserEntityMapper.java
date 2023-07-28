package lab.app.mappers;

import lab.app.dto.UserDTO;
import lab.app.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {
    private ModelMapper modelMapper;

    public UserEntityMapper(){
        this.modelMapper = new ModelMapper();
    }

    public UserDTO toDto(User user){
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
}
