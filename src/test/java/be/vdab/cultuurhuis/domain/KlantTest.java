package be.vdab.cultuurhuis.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KlantTest {

    private Klant klant1;
    private Klant klant2;
    private Klant klant3;

    @Before
    public void before() {
        klant1= new Klant("test1", "test1", new Adres(),"test1","test1");
        klant2= new Klant("test2", "test2", new Adres(),"test2","test2");
        klant3= new Klant("test3", "test3", new Adres(),"test1","test3");
    }

    @Test
    public void klantenZijnGelijkAlsGebruikersnaamGelijkis() {
        assertThat(klant1).isEqualTo(klant3);
    }
    @Test
    public void klantenZijnVerschillendAlsGebruikersnaamVerschilt() {
        assertThat(klant1).isNotEqualTo(klant2);
    }
    @Test
    public void eenTelefoonNrVerschiltVanNull() {
        assertThat(klant1).isNotEqualTo(null);
    }
    @Test
    public void eenTelefoonNrVerschiltVanEenAnderTypeObject() {
        assertThat(klant1).isNotEqualTo("");
    }
    @Test
    public void gelijkeTelefoonNrsGevenDezelfdeHashCode() {
        assertThat(klant1).hasSameHashCodeAs(klant3);
    }


}
