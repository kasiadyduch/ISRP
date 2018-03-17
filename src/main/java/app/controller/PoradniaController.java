package app.controller;

import app.model.classes.Poradnia;
import app.model.repos.PoradniaRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Karolina on 29.11.2017.
 */
@Slf4j
@RestController
@CrossOrigin
public class PoradniaController {
    @Autowired
    PoradniaRepo poradniaRepo;

    @RequestMapping(value = "/poradnie/all", method = RequestMethod.GET)
    public Iterable<Poradnia> getPoradnie() {
        return poradniaRepo.findAll();
    }

    @RequestMapping(value = "/poradnie/{poradniaid}", method = RequestMethod.GET)
    public Poradnia getSinglePoradnia(
            @PathVariable(value = "poradniaid") Integer poradniaid
    ) {
        if (poradniaRepo.findOne(poradniaid) == null) {
            throw new RuntimeException("Nie ma poradni o podanym id!");
        }
        return poradniaRepo.findOne(poradniaid);
    }
}
