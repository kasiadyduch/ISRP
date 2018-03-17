package app.config;

import app.model.classes.Lekarz;
import app.model.classes.Pacjent;
import app.model.classes.Rezerwacja;
import app.model.classes.ZakladyPracy;
import org.springframework.stereotype.Component;

/**
 * Created by Karolina on 28.12.2017.
 */
@Component
public class Validator {

    public boolean isLekarzValid(Lekarz l) {
        return !(isEmptyString(l.getNazwisko()) || isEmptyString(l.getPwz()));
    }

    public boolean isPacjentValid(Pacjent p) {
        return !(isEmptyString(p.getNazwisko()) || isEmptyString(p.getPesel()));
    }
    public boolean isZakladValid(ZakladyPracy z) {
        return !isEmptyString(z.getNazwa());
    }

    private boolean isEmptyString(String s) {
        return (s == null || s.trim().length() == 0);
    }
}
