package app.controller;

import app.model.classes.GodzinyPrzyjec;
import app.model.repos.GodzinyPrzyjecRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Karolina on 08.02.2018.
 */
@Slf4j
@RestController
@CrossOrigin
public class GodzinyPrzyjecController {
    @Autowired
    public GodzinyPrzyjecRepo godzinyPrzyjecRepo;

    @RequestMapping(value = "/godzinyprzyjec/all", method = RequestMethod.GET)
    public Iterable<GodzinyPrzyjec> getGodzinyPrzyjec() {
        return godzinyPrzyjecRepo.findAll();
    }

    @RequestMapping(value = "godzinyprzyjec/bydzien", method = RequestMethod.GET)
    public Iterable<GodzinyPrzyjec> getByDzien(
            @RequestParam(value = "nazwisko") String nazwisko,
            @RequestParam(value = "opis") String opis,
            @RequestParam(value = "dzien") Integer dzien
    ) {
        return godzinyPrzyjecRepo.fGetLekarzsGodzOdByDzien(nazwisko, opis, dzien);
    }
}
