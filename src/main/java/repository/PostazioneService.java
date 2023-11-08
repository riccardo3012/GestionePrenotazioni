package repository;
import entities.Postazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository usersRepository;

    public void create(Postazione p) {
        usersRepository.save(p);
    }

    public List<Postazione> find() {
        return usersRepository.findAll();
    }
}