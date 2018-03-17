package app.controller;

import app.config.Validator;
import app.model.classes.ZakladyPracy;
import app.model.repos.ZakladyPracyRepo;
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
public class ZakladPracyController {
    @Autowired
    ZakladyPracyRepo zakladyPracyRepo;

    @Autowired
    Validator validator;

    @RequestMapping(value = "/zaklady/all", method = RequestMethod.GET)
    public Iterable<ZakladyPracy> getZaklady() {
        return zakladyPracyRepo.findAll();
    }

    @RequestMapping(value = "/zaklady/{zakladid}", method = RequestMethod.GET)
    public ZakladyPracy getSingleZaklad(
            @PathVariable(value = "zakladid") Integer zakladid
    ) {
        if (zakladyPracyRepo.findOne(zakladid) == null) {
            throw new RuntimeException("Nie ma zakladu o podanym id!");
        }
        return zakladyPracyRepo.findOne(zakladid);
    }
    @RequestMapping(value = "zaklady/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createZakladPracy(@RequestBody ZakladyPracy zakladPracy) {
        if (!validator.isZakladValid(zakladPracy)) {
            throw new RuntimeException("Złe dane zakładu!");
        }
        zakladyPracyRepo.save(zakladPracy);
    }

    @RequestMapping(value = "/zaklady/{zakladid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteZaklad(
            @PathVariable(value = "zakladid") Integer zakladid
    ) {
        zakladyPracyRepo.delete(zakladid);
    }
}
