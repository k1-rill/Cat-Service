package lab.app.mappers;

import lab.app.dto.CatDTO;
import lab.app.entities.Cat;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CatEntityMapper {
    private ModelMapper modelMapper;

    public CatEntityMapper(){
        this.modelMapper = new ModelMapper();
    }

    public CatDTO toDto(Cat cat){
        return modelMapper.map(cat, CatDTO.class);
    }

    public Cat toEntity(CatDTO catDTO){
        return modelMapper.map(catDTO, Cat.class);
    }
}
