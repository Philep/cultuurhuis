package be.vdab.cultuurhuis.repositories;

import be.vdab.cultuurhuis.domain.Voorstelling;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VoorstellingRepository extends JpaRepository<Voorstelling, Long> {

    List<Voorstelling> findByGenreId(long id);

}
