package lab.app.service.abstractions;

import lab.app.entities.Cat;

import java.util.List;

public interface CatService {
    Cat save(Cat cat);
    void deleteById(long id);
    Cat update(long id, Cat cat);
    List<Cat> getAll();
    Cat getById(long id);
}
