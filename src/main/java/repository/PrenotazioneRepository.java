package repository;
import entities.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazioni, Long> {

}