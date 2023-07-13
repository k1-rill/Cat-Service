package lab.app.service.abstractions;

import lab.app.entities.Flea;

import java.util.List;

public interface FleaService {
    Flea save(Flea Flea);
    void deleteById(long id);
    Flea update(long id, Flea Flea);
    List<Flea> getAll();
    Flea getById(long id);
}
