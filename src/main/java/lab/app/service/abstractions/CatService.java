package lab.app.service.abstractions;

import lab.app.dto.CatDTO;
import lab.app.entities.Cat;

import java.util.List;

public interface CatService {
    CatDTO save(Cat cat);
    void deleteById(long id);
    CatDTO update(long id, Cat cat);
    List<CatDTO> getAll();
    CatDTO getById(long id);
}
