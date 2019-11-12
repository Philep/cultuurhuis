package be.vdab.cultuurhuis.controllers;

import be.vdab.cultuurhuis.domain.Reservatie;
import be.vdab.cultuurhuis.forms.ReservatieForm;
import be.vdab.cultuurhuis.services.VoorstellingService;
import be.vdab.cultuurhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mandje")
public class MandjeController {

    private final VoorstellingService

    @GetMapping()
    public ModelAndView mandje(@Valid Mandje mandje) {

        Map<Long, Integer> map = mandje.getReserveringen();
        List<Reservatie> reserveringenMandje = new ArrayList<>();
        map.forEach((key, value) -> reserveringenMandje.add());





        return new ModelAndView("mandje");
    }

    @PostMapping
    public ModelAndView toevoegen(@Valid ReservatieForm form, @Valid Mandje mandje, Errors errors) {

        ModelAndView modelAndView = new ModelAndView("mandje");

        if (errors.hasErrors()) {
            return modelAndView;
        }

        mandje.voegToe(form.getId(), form.getAantalPlaatsen());

        return modelAndView;


    }

}
