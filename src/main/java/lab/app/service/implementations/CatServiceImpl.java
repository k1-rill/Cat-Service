package lab.app.service.implementations;

import lab.app.dto.CatDTO;
import lab.app.entities.Cat;
import lab.app.entities.Owner;
import lab.app.mappers.CatEntityMapper;
import lab.app.repository.CatRepository;
import lab.app.repository.OwnerRepository;
import lab.app.service.abstractions.CatService;
import lab.app.tools.CatServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    private final OwnerRepository ownerRepository;

    private final CatEntityMapper mapper;

    @Autowired
    public CatServiceImpl(CatRepository catRepository, CatEntityMapper mapper, OwnerRepository ownerRepository){
        this.catRepository = catRepository;
        this.mapper = mapper;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public CatDTO save(Cat cat) throws CatServiceException{
        Optional<Owner> owner = ownerRepository.findById(cat.getCatOwner().getId());

        if (owner.isEmpty())
            throw new CatServiceException(String.format("no such owner for the cat: %s", cat.getId()));

        cat.setCatOwner(owner.get());
        List<Cat> cats = owner.get().getCats();
        cats.add(cat);
        owner.get().setCats(cats);
        ownerRepository.save(owner.get());

        return mapper.toDto(catRepository.save(cat));
    }

    @Override
    public void deleteById(long id) throws CatServiceException{
        Optional<Cat> cat = catRepository.findById(id);

        if (cat.isEmpty())
            throw new CatServiceException(String.format("no such cat to delete: %s", cat.get().getId()));

        catRepository.deleteById(id);
    }

    @Override
    public CatDTO update(long id, Cat cat) throws CatServiceException {
        Optional<Cat> meow = catRepository.findById(id);
        Optional<Owner> owner = ownerRepository.findById(cat.getCatOwner().getId());

        if (meow.isEmpty())
            throw new CatServiceException(String.format("no such cat found to update: %s", meow.get().getId()));

        if (owner.isEmpty())
            throw new CatServiceException(String.format("no such owner for this cat found: %s", meow.get().getId()));

        List<Cat> cats = owner.get().getCats();
        cats.remove(cat);

        meow.get().setName(cat.getName());
        meow.get().setBreed(cat.getBreed());
        meow.get().setColor(cat.getColor());
        meow.get().setDate(cat.getDate());
        cats.add(meow.get());
        owner.get().setCats(cats);
        meow.get().setCatOwner(owner.get());

        ownerRepository.save(owner.get());

        return mapper.toDto(catRepository.save(meow.get()));
    }

    @Override
    public List<CatDTO> getAll() {
        return catRepository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CatDTO getById(long id) throws CatServiceException {
        Optional<Cat> cat = catRepository.findById(id);

        if (cat.isEmpty())
            throw new CatServiceException(String.format("no such cat found to get: %s", cat.get().getId()));

        return mapper.toDto(cat.get());
    }
}
