package be.vdab.cultuurhuis.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="genres")
public class Genre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String naam;

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }


    Genre() {
    }

    public Genre(@NotBlank String naam) {
        this.naam = naam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;

        Genre genre = (Genre) o;

        return naam != null ? naam.equals(genre.naam) : genre.naam == null;
    }

    @Override
    public int hashCode() {
        return naam != null ? naam.hashCode() : 0;
    }
}
