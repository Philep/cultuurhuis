package be.vdab.cultuurhuis.repositories;

import be.vdab.cultuurhuis.domain.Reservatie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservatiesRepository extends JpaRepository<Reservatie, Long> {
}
