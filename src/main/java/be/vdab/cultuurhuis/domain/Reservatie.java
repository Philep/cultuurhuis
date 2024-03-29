package be.vdab.cultuurhuis.domain;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Table(name = "reservaties")
public class Reservatie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "klantid")
    private Klant klant;
    @ManyToOne(optional = false)
    @JoinColumn(name = "voorstellingid")
    private Voorstelling voorstelling;
    @Positive
    private int plaatsen;

    Reservatie() {
    }

    public Reservatie(Klant klant, Voorstelling voorstelling, @Positive int plaatsen) {
        this.klant = klant;
        this.voorstelling = voorstelling;
        this.plaatsen = plaatsen;
    }

    public long getId() {
        return id;
    }

    public Klant getKlant() {
        return klant;
    }

    public Voorstelling getVoorstelling() {
        return voorstelling;
    }

    public int getPlaatsen() {
        return plaatsen;
    }
}
