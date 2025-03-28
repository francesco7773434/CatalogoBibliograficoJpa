package it.epicode.prestito;

import it.epicode.catalogo.ElementoPrestato;
import it.epicode.utente.Utente;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "prestiti")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(
        name = "Prestito.findByNumeroDiTesseraAndActive",
        query = "SELECT p FROM Prestito p WHERE p.utente.numeroDiTessera = :numeroDiTessera AND p.dataRestituzionePrevista IS NULL"
)
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private ElementoPrestato elementoPrestato;
    @Column(length = 100)
    private String dataInizioPrestito;
    @Column(length = 100)
    private String dataRestituzionePrevista;
    @Column(length = 100)
    private String dataRestituzioneEffettiva;
}
