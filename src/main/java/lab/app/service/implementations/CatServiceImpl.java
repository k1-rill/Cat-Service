package lab.app.service.implementations;

import lab.app.entities.Cat;
import lab.app.repository.CatRepository;
import lab.app.service.abstractions.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    private final CatRepository catRepository;

    @Autowired
    public CatServiceImpl(CatRepository catRepository){
        this.catRepository = catRepository;
    }

    @Override
    public Cat save(Cat cat) {
        return catRepository.save(cat);
    }

    @Override
    public void deleteById(long id) {
        catRepository.deleteById(id);
    }

    @Override
    public Cat update(long id, Cat cat) {
        Cat newCat;
        newCat = catRepository.findById(id).orElseThrow();
        if (newCat == null)
            return null;

        newCat.setName(cat.getName());
        newCat.setColor(cat.getColor());
        return catRepository.save(newCat);
    }

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat getById(long id) {
        return catRepository.findById(id).orElseThrow();
    }
}
