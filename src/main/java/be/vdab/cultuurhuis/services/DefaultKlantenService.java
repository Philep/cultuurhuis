package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Klant;
import be.vdab.cultuurhuis.repositories.KlantenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultKlantenService implements KlantenService{

    private final KlantenRepository klantenRepository;

    public DefaultKlantenService(KlantenRepository klantenRepository) {
        this.klantenRepository = klantenRepository;
    }

    @Override
    public Klant findByGebruikersnaam(String gebruikersnaam) {
        return klantenRepository.findByGebruikersnaam(gebruikersnaam);
    }

    @Override
    public void create(Klant klant) {
        klantenRepository.save(klant);
    }
}
