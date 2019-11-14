package be.vdab.cultuurhuis.controllers;

import be.vdab.cultuurhuis.domain.Adres;
import be.vdab.cultuurhuis.domain.Klant;
import be.vdab.cultuurhuis.dto.ReservatieMandje;
import be.vdab.cultuurhuis.repositories.KlantenRepository;
import be.vdab.cultuurhuis.services.KlantenService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/nieuweklant")
public class KlantController {

    private final KlantenService klantenService;


    public KlantController(KlantenService klantenService) {
        this.klantenService = klantenService;
    }

    @GetMapping()
    public ModelAndView nieuweKlant() {


        ModelAndView modelAndView = new ModelAndView("nieuweklant");
        Klant klant = new Klant(null,null,new Adres(null,null,null,null),null,null);
//        Klant klant = new Klant("test","test",new Adres("test","test","test","test"),"test","test");
        modelAndView.addObject("klant", klant);

        return modelAndView;
    }

    @PostMapping()
    public ModelAndView aanmakenKlant() {

        ModelAndView modelAndView = new ModelAndView("nieuweklant");
        Klant klant = new Klant(null,null,new Adres(null,null,null,null),null,null);
        modelAndView.addObject("klant", klant);

        return modelAndView;

    }

    @PostMapping(value = "nieuweklant", params = "toevoegen")
    public ModelAndView aanmakenKlant(@Valid Klant klant, Errors errors) {

        if (errors.hasErrors()) {
            return new ModelAndView("nieuweklant");
        }

        klantenService.create(klant);

        return new ModelAndView("bevestig");

    }


}
