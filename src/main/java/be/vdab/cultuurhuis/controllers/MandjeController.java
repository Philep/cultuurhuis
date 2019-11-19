package be.vdab.cultuurhuis.controllers;

import be.vdab.cultuurhuis.dto.ReservatieMandje;
import be.vdab.cultuurhuis.domain.Voorstelling;
import be.vdab.cultuurhuis.exceptions.VoorstellingNietGevondenException;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mandje")
public class MandjeController {

    private final VoorstellingService voorstellingService;

    public MandjeController(VoorstellingService voorstellingService) {
        this.voorstellingService = voorstellingService;
    }

    //vul tijdelijk mandje dat gebruiker ziet en nog niet bevestigd is
    private List<ReservatieMandje> vulMandjeGebruiker(@Valid Mandje mandje) {
        List<ReservatieMandje> reserveringenMandje = new ArrayList<>();

        try {

            Map<Long, Integer> map = mandje.getReserveringen();

            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                Voorstelling voorstelling = voorstellingService.findById(entry.getKey()).get();
                reserveringenMandje.add(new ReservatieMandje(entry.getKey(), voorstelling.getDatum(), voorstelling.getTitel(), voorstelling.getUitvoerders(), voorstelling.getPrijs(), entry.getValue()));
            }

        } catch (VoorstellingNietGevondenException e) {
            e.printStackTrace();
        }

        return reserveringenMandje;
    }

    //bereken tijdelijke kostprijs dat de gebruiker moet gaan betalen
    private BigDecimal berekenTotalePrijsMandje(List<ReservatieMandje> reserveringenMandje) {

        BigDecimal totalePrijsMandje = BigDecimal.ZERO;

        for (ReservatieMandje res : reserveringenMandje) {
            totalePrijsMandje = totalePrijsMandje.add(res.getPrijs().multiply(BigDecimal.valueOf(res.getAantalPlaatsen())));
        }

        return totalePrijsMandje;

    }

    @GetMapping()
    public ModelAndView mandje(@Valid Mandje mandje) {

        ModelAndView modelAndView = new ModelAndView("mandje");

        List<ReservatieMandje> reserveringenMandje = vulMandjeGebruiker(mandje);
        BigDecimal totalePrijs = berekenTotalePrijsMandje(reserveringenMandje);

        modelAndView.addObject("totalePrijs", totalePrijs);
        return modelAndView.addObject("reserveringenMandje", reserveringenMandje);
    }

    @PostMapping()
    public String verwijderen(long[] ids, @Valid Mandje mandje) {

        if (ids != null) {
            Arrays.stream(ids).forEach(id -> mandje.remove(id));
        }

        return "redirect:/mandje";

    }


}
