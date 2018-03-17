package app.controller;

import app.config.Validator;
import app.model.classes.Lekarz;
import app.model.repos.LekarzRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Karolina on 29.11.2017.
 */
@Slf4j
@RestController
@CrossOrigin
public class LekarzController {
    @Autowired
    LekarzRepo lekarzRepo;

    @Autowired
    Validator validator;

    @RequestMapping(value = "lekarze/all", method = RequestMethod.GET)
    public Iterable<Lekarz> getLekarze() {
        return lekarzRepo.findAll();
    }

    @RequestMapping(value = "lekarze/{lekarzid}", method = RequestMethod.GET)
    public Lekarz getSingleLekarz(
            @PathVariable(value = "lekarzid") Integer lekarzid
    ) {
        if (lekarzRepo.findOne(lekarzid) == null) {
            throw new RuntimeException("Nie ma lekarza o podanym id!");
        }
        return lekarzRepo.findOne(lekarzid);
    }

    @RequestMapping(value = "lekarze/bynazwisko", method = RequestMethod.GET)
    public Iterable<Lekarz> getLekarzeByNazwisko(
            @RequestParam(value = "nazwisko", required = true) String nazwisko
    ) {
        if (lekarzRepo.findLekarzsByNazwiskoContaining(nazwisko).isEmpty()) {
            throw new RuntimeException("Nie ma lekarza o podanym nazwisku!");
        }
        return lekarzRepo.findLekarzsByNazwiskoContaining(nazwisko);
    }

    @RequestMapping(value = "lekarze/bypwz", method = RequestMethod.GET)
    public Lekarz getLekarzeByPwz(
            @RequestParam(value = "pwz", required = true) String pwz
    ) {
        if (lekarzRepo.findLekarzByPwzContaining(pwz) == null) {
            throw new RuntimeException("Nie ma lekarza o podanym pwz!");
        }
        return lekarzRepo.findLekarzByPwzContaining(pwz);
    }

    @RequestMapping(value = "lekarze/byporadnia", method = RequestMethod.GET)
    public Iterable getLekarzeByPoradnia(
            @RequestParam(value = "poradnia", required = true) String poradnia
    ) {
        if (lekarzRepo.gfindLekarzsByOpisPoradni(poradnia).isEmpty()) {
            throw new RuntimeException("Brak lekarzy w danej poradni!");
        }
        return lekarzRepo.gfindLekarzsByOpisPoradni(poradnia);
    }

    @RequestMapping(value = "lekarze/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createLekarz(@RequestBody Lekarz lekarz) {
        if (!validator.isLekarzValid(lekarz)) {
            throw new RuntimeException("Złe dane lekarza!");
        }
        lekarzRepo.save(lekarz);
    }

    @RequestMapping(value = "lekarze/{lekarzid}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateLekarz(
            @PathVariable(value = "lekarzid") Integer lekarzid,
            @RequestBody Lekarz lekarz) {
        if (lekarzRepo.findOne(lekarzid) == null) {
            throw new RuntimeException("Nie ma lekarza o podanym id!");
        }
        Lekarz l = lekarzRepo.findOne(lekarzid);
        l.setImie(lekarz.getImie());
        l.setNazwisko(lekarz.getNazwisko());
        l.setPwz(lekarz.getPwz());
        if (!validator.isLekarzValid(l)) {
            throw new RuntimeException("Złe dane lekarza!");
        }
        lekarzRepo.save(l);
    }

    @RequestMapping(value = "/lekarze/{lekarzid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteLekarz(
            @PathVariable(value = "lekarzid") Integer lekarzid
    ) {
        lekarzRepo.delete(lekarzid);
    }
}
