package entities;
import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "Prenotazioni")
public class Prenotazioni {
@Id
@Column
private long id;
@Column
private LocalDate dataPrenotazione;
@ManyToOne
private User user;
@ManyToOne
private Postazione postazione;

    public Prenotazioni(long id, LocalDate dataPrenotazione, User user, Postazione postazione) {
        this.id = id;
        this.dataPrenotazione = dataPrenotazione;
        this.user = user;
        this.postazione = postazione;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    @Slf4j
    public static class PrenotazioniBuilder {
        Faker faker = new Faker();
        long id = faker.number().randomNumber();
        LocalDate dataPrenotazione = faker.date().future(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        User user;
        Postazione postazione;

        public PrenotazioniBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public PrenotazioniBuilder withPostazione(Postazione postazione) {
            this.postazione = postazione;
            return this;
        }

        public Prenotazioni build() {
            return new Prenotazioni(id, dataPrenotazione, user, postazione);
        }
    }

}
