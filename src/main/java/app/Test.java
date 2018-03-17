package app;

import app.config.SmallConfig;
import app.model.repos.RezerwacjaDetailsRepo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Karolina on 29.11.2017.
 */

//Klasa do testowania off-line!
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SmallConfig.class);
//        LekarzRepo lekarzRepo = ctx.getBean(LekarzRepo.class);
//        GodzinyPrzyjecRepo godzinyPrzyjecRepo = ctx.getBean(GodzinyPrzyjecRepo.class);
//        RezerwacjaRepo rezerwacjaRepo = ctx.getBean(RezerwacjaRepo.class);

        RezerwacjaDetailsRepo rezerwacjaDetails = ctx.getBean(RezerwacjaDetailsRepo.class);


//        System.out.println("\n");
//
//        for (Pacjent p : pacjentRepo.findAll()) {
//            System.out.println(p);
//        }
//
//        System.out.println("\n");
//
//        for (Lekarz l : lekarzRepo.findAll()) {
//            System.out.println(l);
//        }

//        System.out.println("##################################");
//
//        for (Poradnia p : poradniaRepo.findAll()) {
//            System.out.println(p);
//        }

//        for (Lekarz l : lekarzRepo.findLekarzsByNazwiskoContaining("Kot")) {
//            System.out.println(l);
//        }

//        System.out.println(lekarzRepo.findLekarzByPwzContaining("1234567"));

        System.out.println("####################");

//        for (Lekarz l : lekarzRepo.gfindLekarzsByOpisPoradni("Alergologiczna dla dzieci")) {
//            System.out.println(l);
//            System.out.println("####################");
//        }0

//        "2018-02-16", "09:00", 8


        System.out.println( rezerwacjaDetails.getRezerwacjaDetails( Date.valueOf( "2018-02-23" ), Time.valueOf( "10:15:00" ), 1 ) );
        ctx.close();
    }
}
