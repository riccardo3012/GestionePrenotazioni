package repository;
import entities.Edificio;
import exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository usersRepo;

    public void create(Edificio e) {
        usersRepo.save(e);
    }

    public List<Edificio> find() {
        return usersRepo.findAll();
    }

    public Edificio findById(Long id) {
        return usersRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }
}