package app.controller;

import app.model.classes.RezerwacjeMP;
import app.model.repos.RezerwacjeMPRepo;
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
public class RezerwacjaMPController {
    @Autowired
    RezerwacjeMPRepo rezerwacjeMPRepo;

    @RequestMapping(value = "/rezerwacjemp/all", method = RequestMethod.GET)
    public Iterable<RezerwacjeMP> getRezerwacjeMP() {
        return rezerwacjeMPRepo.findAll();
    }

    @RequestMapping(value = "rezerwacjemp/{rezerwacjempid}", method = RequestMethod.GET)
    public RezerwacjeMP getSingleRezerwacjaMP(
            @PathVariable(value = "rezerwacjampid") Integer rezerwacjampid
    ) {
        if (rezerwacjeMPRepo.findOne(rezerwacjampid) == null) {
            throw new RuntimeException("Nie ma rezerwacji o podanym id!");
        }
        return rezerwacjeMPRepo.findOne(rezerwacjampid);
    }

    @RequestMapping(value = "rezerwacjemp/add", method = RequestMethod.POST)
    public void createRezerwacjaMP(@RequestBody RezerwacjeMP rezerwacjeMP) {
        rezerwacjeMPRepo.save( new RezerwacjeMP( 0, rezerwacjeMP.getId_pacjenta(), rezerwacjeMP.getId_badania(), rezerwacjeMP.getId_zakladu (), rezerwacjeMP.getData() ) );
    }

    @RequestMapping(value = "/rezerwacjemp/{rezerwacjempid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRezerwacjaMP(
            @PathVariable(value = "rezerwacjampid") Integer rezerwacjampid
    ) {
        rezerwacjeMPRepo.delete(rezerwacjampid);
    }
}
