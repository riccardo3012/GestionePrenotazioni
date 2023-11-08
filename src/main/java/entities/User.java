package entities;
import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Entity
@Table (name = "User")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column
    private String nome;
    @Column
    private  String cognome;
    @Column
    private String email;
    @OneToMany (mappedBy = "user")
    private List<Prenotazioni> prenotazione;

    public User(long id, String nome, String cognome, String email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Slf4j
    public static class UserBuilder {
        Faker faker = new Faker();
        String nome = faker.name().firstName();
        String cognome = faker.name().lastName();
        String email = faker.internet().emailAddress();
    }
}
