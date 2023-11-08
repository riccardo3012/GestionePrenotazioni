package entities;
import com.github.javafaker.Faker;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Entity
@Table(name = "Postazione")
public class Postazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String codiceUnivoco;
    private String descrizione;
    @Column
    private int numeroMassimoOccupanti;
    @Column
    private TipoPostazione tipoPostazione;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazioni> prenotazioni;
    @ManyToOne
    private Edificio edificio;

    public Postazione(String codiceUnivoco, String descrizione, int numeroMassimoOccupanti, TipoPostazione tipoPostazione, List<Prenotazioni> prenotazioni, Edificio edificio) {
        this.codiceUnivoco = codiceUnivoco;
        this.descrizione = descrizione;
        this.numeroMassimoOccupanti = numeroMassimoOccupanti;
        this.tipoPostazione = tipoPostazione;
        this.prenotazioni = prenotazioni;
        this.edificio = edificio;
    }

    @Slf4j
    public static class PostazioneBuilder {
        private static long codiceUnivocoCounter = 1;
        Faker faker = new Faker();
        String codiceUnivoco = generateUniqueCodiceUnivoco();
        String descrizione = faker.lorem().sentence();
        int numeroMassimoOccupanti = faker.number().numberBetween(1, 10);

        private String generateUniqueCodiceUnivoco() {
            String uniqueCodiceUnivoco = "CODICE UNIVOCO" + codiceUnivocoCounter;
            codiceUnivocoCounter++;
            return uniqueCodiceUnivoco;
        }
}
}
