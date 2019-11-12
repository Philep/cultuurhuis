package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> findAll();
    Genre findByNaam(String naam);

}
