package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Reservatie;
import be.vdab.cultuurhuis.repositories.ReservatiesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultReservatiesService implements ReservatiesService {

    private final ReservatiesRepository repository;

    public DefaultReservatiesService(ReservatiesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Reservatie reservatie) {
        repository.save(reservatie);
    }

}
