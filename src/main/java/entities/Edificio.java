package entities;
import com.github.javafaker.Faker;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Edificio")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nome;
    @Column
    private String indirizzo;
    @Column
    private String città;

    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

    public Edificio(Long id, String nome, String indirizzo, String città, List<Postazione> postazioni) {
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.città = città;
        this.postazioni = postazioni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCittà() {
        return città;
    }

    public void setCittà(String città) {
        this.città = città;
    }

    public List<Postazione> getPostazioni() {
        return postazioni;
    }

    public void setPostazioni(List<Postazione> postazioni) {
        this.postazioni = postazioni;
    }


    public static class BuildingBuilder {
        Faker faker = new Faker();
        String nome = faker.address().streetName();
        String indirizzo = faker.address().streetAddress();
        String città = faker.address().city();
    }
}
