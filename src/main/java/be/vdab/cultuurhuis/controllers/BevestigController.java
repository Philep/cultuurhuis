package be.vdab.cultuurhuis.controllers;

import be.vdab.cultuurhuis.domain.Klant;
import be.vdab.cultuurhuis.domain.Reservatie;
import be.vdab.cultuurhuis.domain.Voorstelling;
import be.vdab.cultuurhuis.dto.ReservatieMandje;
import be.vdab.cultuurhuis.exceptions.VoorstellingNietGevondenException;
import be.vdab.cultuurhuis.services.KlantenService;
import be.vdab.cultuurhuis.services.VoorstellingService;
import be.vdab.cultuurhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("bevestig")
class BevestigController {

    private final KlantenService klantenService;
    private final VoorstellingService voorstellingService;

    public BevestigController(KlantenService klantenService, VoorstellingService voorstellingService) {
        this.klantenService = klantenService;
        this.voorstellingService = voorstellingService;
    }

    @GetMapping()
    public ModelAndView bevestig(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("bevestig");
        if (principal != null) {
            Klant klant = klantenService.findByGebruikersnaam(principal.getName());
            modelAndView.addObject(klant);
        }
        return modelAndView;
    }

    @PostMapping()
    public String login() {
        return "bevestig";
    }

    @PostMapping("overzicht")
    public ModelAndView overzicht(@Valid Mandje mandje, Principal principal) {

        ModelAndView modelAndView = new ModelAndView("overzicht");
        try {

            Map<Long, Integer> map = mandje.getReserveringen();

            for (Map.Entry<Long, Integer> entry : map.entrySet()) {

                Klant klant = klantenService.findByGebruikersnaam(principal.getName());

                Reservatie reservatie = new Reservatie(klant, voorstellingService.findById(entry.getKey()).get(),entry.getValue());
                souts
            }


        } catch (VoorstellingNietGevondenException e) {
            e.printStackTrace();
        }


        return modelAndView;

    }


}
