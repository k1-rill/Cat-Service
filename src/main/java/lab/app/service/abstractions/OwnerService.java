package lab.app.service.abstractions;

import lab.app.entities.Owner;

import java.util.List;


public interface OwnerService {
    Owner save(Owner Owner);
    void deleteById(long id);
    Owner update(long id, Owner Owner);
    List<Owner> getAll();
    Owner getById(long id);
}
