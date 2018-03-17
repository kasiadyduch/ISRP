package app.controller;

import app.config.Validator;
import app.model.classes.Pacjent;
import app.model.repos.PacjentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.PackageElement;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Karolina on 29.11.2017.
 */
@Slf4j
@RestController
@CrossOrigin
public class PacjentController {
    @Autowired
    PacjentRepo pacjentRepo;

    @Autowired
    Validator validator;

    @RequestMapping(value = "/pacjenci/all", method = RequestMethod.GET)
    public Iterable<Pacjent> getPacjenci() {
        return pacjentRepo.findAll();
    }

    @RequestMapping(value = "/pacjenci/{pacjentid}", method = RequestMethod.GET)
    public Pacjent getSinglePacjent(
            @PathVariable(value = "pacjentid") Integer pacjentid
    ) {
        if (pacjentRepo.findOne(pacjentid) == null) {
            throw new RuntimeException("Nie ma pacjenta o podanym id!");
        }
        return pacjentRepo.findOne(pacjentid);
    }

    @RequestMapping(value = "pacjenci/bynazwisko", method = RequestMethod.GET)
    public Iterable<Pacjent> getPacjentByNazwisko(
            @RequestParam(value = "nazwisko", required = true) String nazwisko
    ) {
        if (pacjentRepo.findPacjentsByNazwiskoContaining(nazwisko).isEmpty()) {
            throw new RuntimeException("Nie ma pacjenta o podanym nazwisku!");
        }
        return pacjentRepo.findPacjentsByNazwiskoContaining(nazwisko);
    }

    @RequestMapping(value = "pacjenci/bypesel", method = RequestMethod.GET)
    public Pacjent getPacjentByPesel(
            @RequestParam(value = "pesel", required = true) String pesel
    ) {
        if (pacjentRepo.findPacjentByPeselContaining(pesel) == null) {
            throw new RuntimeException("Nie ma pacjenta o podanym peselu!");
        }
        return pacjentRepo.findPacjentByPeselContaining(pesel);
    }

    @RequestMapping(value = "pacjenci/add", method = RequestMethod.POST)
   @ResponseStatus(HttpStatus.CREATED)
   @ResponseBody
    public void createPacjent(@RequestBody Pacjent pacjent) {
        if (!validator.isPacjentValid(pacjent)) {
            throw new RuntimeException("Złe dane pacjenta!");
        }
        pacjentRepo.save(new Pacjent(0, pacjent.getImie(), pacjent.getNazwisko(), pacjent.getPesel(), pacjent.getNr_telefonu(), pacjent.getUlica(), pacjent.getNr_domu(), pacjent.getKod_pocztowy(), pacjent.getMiejscowosc(), pacjent.getEmail(), pacjent.getId_zakladu(), pacjent.getNr_lokalu()));
    }

    @RequestMapping(value = "pacjenci/{pacjentid}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePacjent(
            @PathVariable(value = "pacjentid") Integer pacjentid,
            @RequestBody Pacjent pacjent
    ) {
        if (pacjentRepo.findOne(pacjentid) == null) {
            throw new RuntimeException("Nie ma pacjenta o podanym id!");
        }
        Pacjent p = pacjentRepo.findOne(pacjentid);
        p.setImie(pacjent.getImie());
        p.setNazwisko(pacjent.getNazwisko());
        p.setPesel(pacjent.getPesel());
        p.setNr_telefonu(pacjent.getNr_telefonu());
        p.setUlica(pacjent.getUlica());
        p.setNr_domu(pacjent.getNr_domu());
        p.setKod_pocztowy(pacjent.getKod_pocztowy());
        p.setMiejscowosc(pacjent.getMiejscowosc());
        p.setEmail(pacjent.getEmail());
        p.setId_zakladu(pacjent.getId_zakladu());
        if (!validator.isPacjentValid(p)) {
            throw new RuntimeException("Złe dane pacjenta");
        }
        pacjentRepo.save(p);
    }

    @RequestMapping(value = "/pacjenci/{pacjentid}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePacjent(
            @PathVariable(value = "pacjentid") Integer pacjentid
    ) {
        pacjentRepo.delete(pacjentid);
    }
}
