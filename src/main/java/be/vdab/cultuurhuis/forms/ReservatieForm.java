package be.vdab.cultuurhuis.forms;

import javax.validation.constraints.NotBlank;

public class ReservatieForm {


    private Long id;
    private Integer aantalPlaatsen;

    public ReservatieForm(@NotBlank Long id, @NotBlank Integer aantalPlaatsen) {
        this.id = id;
        this.aantalPlaatsen = aantalPlaatsen;
    }

    public Long getId() {
        return id;
    }

    public Integer getAantalPlaatsen() {
        return aantalPlaatsen;
    }
}
