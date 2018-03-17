package app.controller;

import app.model.classes.RezerwacjaDetails;
import app.model.repos.RezerwacjaDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;

@Slf4j
@RestController
@CrossOrigin
public class RezerwacjaDetailsController {
    @Autowired
    RezerwacjaDetailsRepo rezerwacjaDetailsRepo;

    @RequestMapping(value = "rezerwacjadetails/get", method = RequestMethod.GET)
    public RezerwacjaDetails getDetails(
            @RequestParam(value = "data") Date data,
            @RequestParam(value = "godzina") Time godzina,
            @RequestParam(value = "id_poradni") Integer id_poradni
    ) {
        if (rezerwacjaDetailsRepo.getRezerwacjaDetails(data, godzina, id_poradni) == null) {
            throw new RuntimeException("Nie działa!");
        }
        return rezerwacjaDetailsRepo.getRezerwacjaDetails(data, godzina, id_poradni);
    }
}
