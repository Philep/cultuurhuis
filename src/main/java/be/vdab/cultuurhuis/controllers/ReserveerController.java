package be.vdab.cultuurhuis.controllers;

import be.vdab.cultuurhuis.domain.Voorstelling;
import be.vdab.cultuurhuis.forms.ReservatieForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("reserveer/{optionalVoorstelling}")
class ReserveerController {




    @GetMapping
    public ModelAndView reserveer(@PathVariable Optional<Voorstelling> optionalVoorstelling) {

        Voorstelling voorstelling = optionalVoorstelling.get();

        return new ModelAndView("reserveer").addObject(voorstelling).addObject("reservatieForm", new ReservatieForm(voorstelling.getId(), null));

    }

}
