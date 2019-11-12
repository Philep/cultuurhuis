package be.vdab.cultuurhuis.controllers;

import be.vdab.cultuurhuis.domain.Genre;
import be.vdab.cultuurhuis.exceptions.GenreNietGevondenException;
import be.vdab.cultuurhuis.services.GenreService;
import be.vdab.cultuurhuis.services.VoorstellingService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
class IndexController {

    private final GenreService genreService;
    private final VoorstellingService voorstellingService;

    public IndexController(GenreService genreService, VoorstellingService voorstellingService) {
        this.genreService = genreService;
        this.voorstellingService = voorstellingService;
    }

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index", "genres", genreService.findAll());
    }

    @GetMapping("/voorstellingen/{naamGenre}")
    public ModelAndView genre(@PathVariable String naamGenre, Pageable pageable) {

        ModelAndView modelAndView = new ModelAndView("index", "genres", genreService.findAll()).addObject("naamGenre", naamGenre);

        try {
            Genre genre = genreService.findByNaam(naamGenre);
            return modelAndView.addObject("voorstellingen", voorstellingService.findById(genre.getId(),pageable));
        } catch (GenreNietGevondenException e) {
            e.printStackTrace();
        }

        return modelAndView;


    }

}
