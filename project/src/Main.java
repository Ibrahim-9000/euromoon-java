import personen.*;
import reis.Reis;
import trein.*;
import ticket.*;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static List<Passagier> passagiers = new ArrayList<>();
    static List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Passagier passagier = new Passagier(
                "Lionel",
                "Messi",
                "12345",
                LocalDate.of(2025, 12, 31)
        );
        passagiers.add(passagier);

        Reis reis = new Reis(
                "Barcelona",
                "Rosario",
                LocalDate.now()
        );
        reis.setTrein(new Trein(new Class373()));

        tickets.add(new Ticket(passagier, reis, Klasse.TWEEDE));

        FileWriter fw = new FileWriter(reis.getBestandsNaam() + ".txt");
        for (Ticket ticket : tickets) {
            fw.write(ticket.getPassagier().toString() + "\n");
        }
        fw.close();

        System.out.println("Boardinglijst aangemaakt");
    }
}
