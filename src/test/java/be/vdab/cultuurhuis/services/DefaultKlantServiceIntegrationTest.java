package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Adres;
import be.vdab.cultuurhuis.domain.Klant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultKlantServiceIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Klant klant;

    @Autowired
    private KlantenService service;

    @Autowired
    private EntityManager manager;

    @Before
    public void before() {
        klant = new Klant("test", "test", new Adres("test","test","test","test"), "test","test");
    }

    @Test
    public void saveKlant() {
        service.create(klant);
        manager.flush();

        assertThat(super.jdbcTemplate.queryForObject("select voornaam from klanten where voornaam = 'test'", String.class)).isEqualTo("test");

    }


}
