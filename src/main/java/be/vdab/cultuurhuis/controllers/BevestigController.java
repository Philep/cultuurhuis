package be.vdab.cultuurhuis.controllers;

import be.vdab.cultuurhuis.domain.Klant;
import be.vdab.cultuurhuis.services.KlantenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("bevestig")
class BevestigController {

    private final KlantenService klantenService;

    public BevestigController(KlantenService klantenService) {
        this.klantenService = klantenService;
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


}
