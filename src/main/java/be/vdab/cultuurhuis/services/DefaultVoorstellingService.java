package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Voorstelling;
import be.vdab.cultuurhuis.repositories.VoorstellingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultVoorstellingService implements VoorstellingService {

    private final VoorstellingRepository voorstellingRepository;

    public DefaultVoorstellingService(VoorstellingRepository voorstellingRepository) {
        this.voorstellingRepository = voorstellingRepository;
    }

    @Override
    public Optional<Voorstelling> findById(long id) {
        return voorstellingRepository.findById(id);
    }

    @Override
    public List<Voorstelling> findByGenreId(long id) {
        return voorstellingRepository.findByGenreId(id);
    }
}
