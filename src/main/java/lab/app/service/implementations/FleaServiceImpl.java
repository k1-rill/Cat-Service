package lab.app.service.implementations;

import lab.app.entities.Flea;
import lab.app.repository.FleaRepository;
import lab.app.service.abstractions.FleaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FleaServiceImpl implements FleaService {
    private final FleaRepository fleaRepository;

    @Autowired
    public FleaServiceImpl(FleaRepository fleaRepository){
        this.fleaRepository = fleaRepository;
    }

    @Override
    public Flea save(Flea flea) {
        return fleaRepository.save(flea);
    }

    @Override
    public void deleteById(long id) {
        fleaRepository.deleteById(id);
    }

    @Override
    public Flea update(long id, Flea flea) {
        Flea newFlea = new Flea();
        newFlea = fleaRepository.findById(id).orElseThrow();
        if (newFlea == null)
            return null;

        newFlea.setName(flea.getName());
        return fleaRepository.save(newFlea);
    }

    @Override
    public List<Flea> getAll() {
        return fleaRepository.findAll();
    }

    @Override
    public Flea getById(long id) {
        return fleaRepository.findById(id).orElseThrow();
    }
}
