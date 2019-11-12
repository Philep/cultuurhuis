package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Genre;
import be.vdab.cultuurhuis.repositories.GenreRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class DefaultGenreServiceTest {

    private DefaultGenreService genreService;
    private List<Genre> genreList;

    @Mock
    private GenreRepository genreRepository;

    @Before
    public void before() {
        genreService = new DefaultGenreService(genreRepository);
        genreList = new ArrayList<>();
        genreList.add(new Genre("test1"));
        genreList.add(new Genre("test2"));

        when(genreRepository.findAll(Sort.by("naam"))).thenReturn(genreList);
    }

    @Test
    public void allGenresFound() {
        assertThat(genreService.findAll()).isEqualTo(genreList);
    }


}
