package lab.app.service.implementations;

import lab.app.dto.OwnerDTO;
import lab.app.entities.Cat;
import lab.app.entities.Owner;
import lab.app.mappers.OwnerEntityMapper;
import lab.app.repository.CatRepository;
import lab.app.repository.OwnerRepository;
import lab.app.service.abstractions.OwnerService;
import lab.app.tools.CatServiceException;
import lab.app.tools.OwnerServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    private final CatRepository catRepository;

    private final OwnerEntityMapper mapper;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, CatRepository catRepository, OwnerEntityMapper mapper){
        this.ownerRepository = ownerRepository;
        this.catRepository = catRepository;
        this.mapper = mapper;
    }

    @Override
    public OwnerDTO save(Owner owner) {
        return mapper.toDto(ownerRepository.save(owner));
    }

    @Override
    public void deleteById(long id) throws OwnerServiceException {
        Optional<Owner> owner = ownerRepository.findById(id);

        if (owner.isEmpty())
            throw new OwnerServiceException(String.format("no such owner to delete: %s", owner.get().getId()));

        ownerRepository.deleteById(id);
    }

    @Override
    public OwnerDTO update(long id, Owner owner) throws OwnerServiceException{
        Optional<Owner> person = ownerRepository.findById(id);

        if (person.isEmpty())
            throw new OwnerServiceException(String.format("no such owner to update: %s", owner.getId()));

        person.get().setName(owner.getName());
        person.get().setDate(owner.getDate());

        return mapper.toDto(person.get());
    }

    @Override
    public List<OwnerDTO> getAll() {
        return ownerRepository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public OwnerDTO getById(long id) throws OwnerServiceException {
        Optional<Owner> owner = ownerRepository.findById(id);

        if (owner.isEmpty())
            throw new OwnerServiceException(String.format("no such owner to get: %s", owner.get().getId()));

        return mapper.toDto(owner.get());
    }
}
