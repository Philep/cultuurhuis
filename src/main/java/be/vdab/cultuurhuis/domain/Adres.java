package be.vdab.cultuurhuis.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Embeddable
public class Adres implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String straat;
    @NotBlank
    private String huisnr;
    @NotBlank
    private String postcode;
    @NotBlank
    private String gemeente;

    Adres() {
    }

    public Adres(@NotBlank String straat, @NotBlank String huisnr, @NotBlank String postcode, @NotBlank String gemeente) {
        this.straat = straat;
        this.huisnr = huisnr;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisnr() {
        return huisnr;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setHuisnr(String huisnr) {
        this.huisnr = huisnr;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }
}
