package lab.app.repository;

import lab.app.entities.Cat;
import lab.app.entities.Flea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    public List<Flea> findAllFleasById(Long id);
    public List<Flea> findAllFleasByName(String name);
}
