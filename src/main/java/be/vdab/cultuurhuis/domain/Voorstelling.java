package be.vdab.cultuurhuis.domain;

import be.vdab.cultuurhuis.exceptions.GeenVrijePlaatsenException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="voorstellingen")
public class Voorstelling implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String titel;
    @NotBlank
    private String uitvoerders;
    @DateTimeFormat(style = "S-")
    @NotNull
    private LocalDate datum;
    @ManyToOne(optional = false)
    @JoinColumn(name = "genreid")
    private Genre genre;
    @PositiveOrZero
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal prijs;
    @PositiveOrZero
    @NotBlank
    private int vrijeplaatsen;
    @Version
    private long versie;

    Voorstelling() {
    }

    public long getId() {
        return id;
    }

    public String getTitel() {
        return titel;
    }

    public String getUitvoerders() {
        return uitvoerders;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public Genre getGenre() {
        return genre;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public int getVrijeplaatsen() {
        return vrijeplaatsen;
    }

    public void reserveerPlaatsen(int plaatsen) {
        try {
            if (vrijeplaatsen > plaatsen) {
                vrijeplaatsen = vrijeplaatsen - plaatsen;
            } else {
                throw new GeenVrijePlaatsenException();
            }

        } catch (GeenVrijePlaatsenException ex) {
            System.out.println("Niet voldoende plaatsen beschikbaar." + ex.getStackTrace());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voorstelling)) return false;

        Voorstelling that = (Voorstelling) o;

        if (uitvoerders != null ? !uitvoerders.equals(that.uitvoerders) : that.uitvoerders != null) return false;
        return datum != null ? datum.equals(that.datum) : that.datum == null;
    }

    @Override
    public int hashCode() {
        int result = uitvoerders != null ? uitvoerders.hashCode() : 0;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        return result;
    }
}
