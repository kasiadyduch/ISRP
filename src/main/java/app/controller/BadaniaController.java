package app.controller;

import app.model.classes.Badania;
import app.model.repos.BadaniaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Karolina on 27.12.2017.
 */
@Slf4j
@RestController
@CrossOrigin
public class BadaniaController {
    @Autowired
    BadaniaRepo badaniaRepo;

    @RequestMapping(value = "/badania/all", method = RequestMethod.GET)
    public Iterable<Badania> getBadania() {
        return badaniaRepo.findAll();
    }

    @RequestMapping(value = "badania/{badanieid}", method = RequestMethod.GET)
    public Badania getSingleBadanie(
            @PathVariable(value = "badanieid") Integer badanieid
    ) {
        if (badaniaRepo.findOne(badanieid) == null) {
            throw new RuntimeException("Nie ma badania o podanym id!");
        }
        return badaniaRepo.findOne(badanieid);
    }

}
