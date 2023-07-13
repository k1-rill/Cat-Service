package lab.app.service.implementations;

import lab.app.entities.Owner;
import lab.app.repository.OwnerRepository;
import lab.app.service.abstractions.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteById(long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner update(long id, Owner owner) {
        Owner newOwner = new Owner();
        newOwner = ownerRepository.findById(id).orElseThrow();
        if (newOwner == null)
            return null;

        newOwner.setName(newOwner.getName());
        return ownerRepository.save(newOwner);
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner getById(long id) {
        return ownerRepository.findById(id).orElseThrow();
    }
}
