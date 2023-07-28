package lab.app.mappers;

import lab.app.dto.OwnerDTO;
import lab.app.entities.Owner;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OwnerEntityMapper {
    private ModelMapper modelMapper;

    public OwnerEntityMapper(){
        this.modelMapper = new ModelMapper();
    }

    public OwnerDTO toDto(Owner owner){
        return modelMapper.map(owner, OwnerDTO.class);
    }

    public Owner toEntity(OwnerDTO ownerDTO){
        return modelMapper.map(ownerDTO, Owner.class);
    }
}
