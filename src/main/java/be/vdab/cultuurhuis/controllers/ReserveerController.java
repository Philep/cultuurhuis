package be.vdab.cultuurhuis.controllers;

import be.vdab.cultuurhuis.domain.Voorstelling;
import be.vdab.cultuurhuis.forms.ReservatieForm;
import be.vdab.cultuurhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("reserveer")
class ReserveerController {




    @GetMapping("{optionalVoorstelling}")
    public ModelAndView reserveer(@PathVariable Optional<Voorstelling> optionalVoorstelling) {

        Voorstelling voorstelling = optionalVoorstelling.get();

        return new ModelAndView("reserveer").addObject(voorstelling).addObject("reservatieForm", new ReservatieForm(voorstelling.getId(), null));

    }

    @PostMapping
    public String toevoegen(@Valid ReservatieForm form, @Valid Mandje mandje, Errors errors) {


        if (errors.hasErrors()) {
            return "redirect:/mandje";
        }

        mandje.voegToe(form.getId(), form.getAantalPlaatsen());

        return "redirect:/mandje";

    }



}
