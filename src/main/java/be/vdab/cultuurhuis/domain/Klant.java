package be.vdab.cultuurhuis.domain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "klanten")
public class Klant implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String voornaam;
    @NotBlank
    private String familienaam;
    @Valid
    @Embedded
    private Adres adres;
    @NotBlank
    private String gebruikersnaam;
    @NotBlank
    private String geencrypteerdPaswoord;

    Klant() {
    }

    public Klant(@NotBlank String voornaam, @NotBlank String familienaam, @Valid Adres adres, @NotBlank String gebruikersnaam, @NotBlank String plainWachtwoord) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.adres = adres;
        this.gebruikersnaam = gebruikersnaam;
        this.geencrypteerdPaswoord = encryptWachtwoord(plainWachtwoord);
    }

    private String encryptWachtwoord(String plainWachtwoord) {
        if (plainWachtwoord!= null) {
            return new BCryptPasswordEncoder().encode(plainWachtwoord);
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public Adres getAdres() {
        return adres;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public String getGeencrypteerdPaswoord() {
        return geencrypteerdPaswoord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klant)) return false;

        Klant klant = (Klant) o;

        return gebruikersnaam != null ? gebruikersnaam.equals(klant.gebruikersnaam) : klant.gebruikersnaam == null;
    }

    @Override
    public int hashCode() {
        return gebruikersnaam != null ? gebruikersnaam.hashCode() : 0;
    }
}
