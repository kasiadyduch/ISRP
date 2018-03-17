package app.controller;

import app.model.classes.Gabinet;
import app.model.repos.GabinetRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Karolina on 29.11.2017.
 */
@Slf4j
@RestController
@CrossOrigin
public class GabinetController {
    @Autowired
    GabinetRepo gabinetRepo;

    @RequestMapping(value = "/gabinety/all", method = RequestMethod.GET)
    public Iterable<Gabinet> getGabinety() {
        return gabinetRepo.findAll();
    }

    @RequestMapping(value = "/gabinety/{gabinetid}", method = RequestMethod.GET)
    public Gabinet getSingleGabinet(
            @PathVariable(value = "gabinetid") Integer gabinetid
    ) {
        if (gabinetRepo.findOne(gabinetid) == null) {
            throw new RuntimeException("Nie ma gabinetu o podanym id!");
        }
        return gabinetRepo.findOne(gabinetid);
    }
}
