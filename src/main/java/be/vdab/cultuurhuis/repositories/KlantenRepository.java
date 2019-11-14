package be.vdab.cultuurhuis.repositories;

import be.vdab.cultuurhuis.domain.Klant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlantenRepository extends JpaRepository<Klant, Long> {

    Klant findByGebruikersnaam(String gebruikersNaam);

}
