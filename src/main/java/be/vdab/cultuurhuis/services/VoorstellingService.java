package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Voorstelling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface VoorstellingService {

    List<Voorstelling> findByGenreId(long id);
    Optional<Voorstelling> findById(long id);

}
