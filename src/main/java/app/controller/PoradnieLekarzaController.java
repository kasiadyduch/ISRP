package app.controller;

import app.model.classes.PoradnieLekarze;
import app.model.repos.PoradnieLekarzeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Karolina on 30.11.2017.
 */
@Slf4j
@RestController
@CrossOrigin
public class PoradnieLekarzaController {

    @Autowired
    PoradnieLekarzeRepo poradnieLekarzaRepo;

    @RequestMapping(value = "/poradnielekarze/all", method = RequestMethod.GET)
    public Iterable<PoradnieLekarze> getPoradnieLekarze() {
        return poradnieLekarzaRepo.findAll();
    }

    @RequestMapping(value = "/poradnielekarze/{poradnielekarzeid}", method = RequestMethod.GET)
    public PoradnieLekarze getSinglePoradnieLekarze(
            @PathVariable(value = "poradnielekarzeid") Integer poradnielekarzeid
    ) {
        if (poradnieLekarzaRepo.findOne(poradnielekarzeid) == null) {
            throw new RuntimeException("Nie ma poradni lekarza o podanym id!");
        }
        return poradnieLekarzaRepo.findOne(poradnielekarzeid);
    }

    @RequestMapping(value = "/poradnielekarze/{poradnielekarzeid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePoradnieLekarze(
            @PathVariable(value = "poradnielekarzeid") Integer poradnielekarzeid
    ) {
        poradnieLekarzaRepo.delete(poradnielekarzeid);
    }
}
