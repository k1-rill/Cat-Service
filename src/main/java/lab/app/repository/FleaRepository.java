package lab.app.repository;

import lab.app.entities.Flea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FleaRepository extends JpaRepository<Flea, Long> {
    public List<Flea> getAllById(long id);
    public List<Flea> getAllByName(String name);
}
