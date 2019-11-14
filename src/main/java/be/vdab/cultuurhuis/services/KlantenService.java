package be.vdab.cultuurhuis.services;

import be.vdab.cultuurhuis.domain.Klant;

public interface KlantenService {

    Klant findByGebruikersnaam(String gebruikersnaam);
    void create(Klant klant);

}
