package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Prenotazioni")
public class Prenotazioni {
@Id
private long id;
private LocalDate dataPrenotazione;

}
