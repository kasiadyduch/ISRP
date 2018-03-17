package app.controller;

import app.model.classes.Rezerwacja;
import app.model.classes.RezerwacjaDetails;
import app.model.repos.RezerwacjaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Karolina on 27.12.2017.
 */
@Slf4j
@RestController
@CrossOrigin
public class RezerwacjaController {
    @Autowired
    RezerwacjaRepo rezerwacjaRepo;

    @RequestMapping(value = "/rezerwacje/all", method = RequestMethod.GET)
    public Iterable<Rezerwacja> getRezerwacje() {
        return rezerwacjaRepo.findAll();
    }

    @RequestMapping(value = "/rezerwacje/{rezerwacjaid}", method = RequestMethod.GET)
    public Rezerwacja getSingleRezerwacja(
            @PathVariable(value = "rezerwacjaid") Integer rezerwacjaid
    ) {
        if (rezerwacjaRepo.findOne(rezerwacjaid) == null) {
            throw new RuntimeException("Nie ma rezerwacji o podanym id!");
        }
        return rezerwacjaRepo.findOne(rezerwacjaid);
    }

    @RequestMapping(value = "/rezerwacje/add", method = RequestMethod.POST)
    public void createRezerwacja(@RequestBody Rezerwacja rezerwacja) {
        rezerwacjaRepo.save(new Rezerwacja(0, rezerwacja.getId_lekarza(), rezerwacja.getId_pacjenta(), rezerwacja.getData(), rezerwacja.getGodzina(), rezerwacja.getId_poradni()));
    }

    @RequestMapping(value = "/rezerwacje/{rezerwacjaid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRezerwacja(
            @PathVariable(value = "rezerwacjaid") Integer rezerwacjaid
    ) {
        rezerwacjaRepo.delete(rezerwacjaid);
    }
}
