package repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import entities.Prenotazioni;
import exception.ItemNotFoundException;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository usersRepo;
    public void create(Prenotazioni p) {
        usersRepo.save(p);
    }

    public List<Prenotazioni> find() {
        return usersRepo.findAll();
    }

    public Prenotazioni findById(Long id) {
        return usersRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void findByIdAndUpdate(Long id, Prenotazioni p) throws ItemNotFoundException {
        Prenotazioni found = this.findById(id);
        found.setId(p.getId());
        found.setDataPrenotazione(p.getDataPrenotazione());
        found.setPostazione(p.getPostazione());
        found.setUser(p.getUser());

    }

    public void findByIdAndDelete(Long id) {
        Prenotazioni found = this.findById(id);
        usersRepo.delete(found);
    }

    public long count() {
        return usersRepo.count();
    }
}