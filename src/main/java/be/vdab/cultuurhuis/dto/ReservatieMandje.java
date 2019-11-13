package be.vdab.cultuurhuis.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservatieMandje {

    private long id;
    private LocalDate datum;
    private String titel;
    private String uitvoerders;
    private BigDecimal prijs;
    private int aantalPlaatsen;

    public ReservatieMandje(long id, LocalDate datum, String titel, String uitvoerders, BigDecimal prijs, int aantalPlaatsen) {
        this.id = id;
        this.datum = datum;
        this.titel = titel;
        this.uitvoerders = uitvoerders;
        this.prijs = prijs;
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getTitel() {
        return titel;
    }

    public String getUitvoerders() {
        return uitvoerders;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public int getAantalPlaatsen() {
        return aantalPlaatsen;
    }

}
