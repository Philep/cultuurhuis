package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Genre;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultGenreServiceIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private GenreService genreService;

    @Autowired
    private EntityManager manger;

    @Test
    public void testFindAll() {
        assertThat(genreService.findAll().size()).isEqualTo(super.jdbcTemplate.queryForList("select id from genres").size());
    }

    @Test
    public void testFindAllSorted() {
        assertThat(genreService.findAll()).extracting(genre -> genre.getNaam()).isSorted();
    }


}
