package lab.app.service.abstractions;

import lab.app.dto.OwnerDTO;
import lab.app.entities.Cat;
import lab.app.entities.Owner;

import java.util.List;


public interface OwnerService {
    OwnerDTO save(Owner Owner);
    void deleteById(long id);
    OwnerDTO update(long id, Owner Owner);
    List<OwnerDTO> getAll();
    OwnerDTO getById(long id);
}
