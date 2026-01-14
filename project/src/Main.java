import personen.Passagier;
import reis.Reis;
import trein.Class373;
import trein.Trein;
import ticket.Klasse;
import ticket.Ticket;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final List<Passagier> passagiers = new ArrayList<>();
    private static final List<Reis> reizen = new ArrayList<>();
    private static final List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        boolean applicatieActief = true;

        while (applicatieActief) {
            toonMenu();

            int keuzeMenu = leesInt("Keuze: ");
            switch (keuzeMenu) {
                case 1 -> registreerPassagier();
                case 2 -> maakReisAan();
                case 3 -> verkoopTicket();
                case 4 -> printBoardinglijst();
                case 0 -> applicatieActief = false;
                default -> System.out.println("Ongeldige keuze");
            }
        }

        System.out.println("Applicatie afgesloten");
    }

    private static void toonMenu() {
        System.out.println("\n=== EUROMOON MENU ===");
        System.out.println("1. Registreer passagier");
        System.out.println("2. Maak reis aan");
        System.out.println("3. Verkoop ticket");
        System.out.println("4. Afdrukken boardinglijst");
        System.out.println("0. Afsluiten");
    }

    private static void registreerPassagier() {
        String voornaam = leesTekst("Voornaam: ");
        String achternaam = leesTekst("Achternaam: ");
        String rijksregisternummer = leesTekst("Rijksregisternummer: ");

        int geboortejaar = leesInt("Geboortejaar: ");
        int geboortemaand = leesInt("Geboortemaand: ");
        int geboortedag = leesInt("Geboortedag: ");

        try {
            Passagier nieuwePassagier = new Passagier(
                    voornaam,
                    achternaam,
                    rijksregisternummer,
                    LocalDate.of(geboortejaar, geboortemaand, geboortedag)
            );

            passagiers.add(nieuwePassagier);
            System.out.println("Passagier geregistreerd");
        } catch (Exception fout) {
            System.out.println("Ongeldige datum ingevoerd");
        }
    }

    private static void maakReisAan() {
        String vertrekstation = leesTekst("Vertrekstation: ");
        String aankomststation = leesTekst("Aankomststation: ");

        Reis nieuweReis = new Reis(vertrekstation, aankomststation, LocalDateTime.now());
        nieuweReis.setTrein(new Trein(new Class373()));

        reizen.add(nieuweReis);
        System.out.println("Reis aangemaakt");
    }

    private static void verkoopTicket() {
        if (passagiers.isEmpty()) {
            System.out.println("Geen passagiers beschikbaar. Registreer eerst een passagier.");
            return;
        }

        if (reizen.isEmpty()) {
            System.out.println("Geen reizen beschikbaar. Maak eerst een reis aan.");
            return;
        }

        Passagier gekozenPassagier = passagiers.get(0);
        Reis gekozenReis = reizen.get(0);

        System.out.println("Kies klasse: 1 = EERSTE, 2 = TWEEDE");
        int keuzeKlasse = leesInt("Klasse: ");
        Klasse gekozenKlasse = (keuzeKlasse == 1) ? Klasse.EERSTE : Klasse.TWEEDE;

        Ticket nieuwTicket = new Ticket(gekozenPassagier, gekozenReis, gekozenKlasse);
        tickets.add(nieuwTicket);

        System.out.println("Ticket verkocht aan " + gekozenPassagier.getVoornaam());
    }

    private static void printBoardinglijst() {
        if (tickets.isEmpty()) {
            System.out.println("Geen tickets gevonden. Verkoop eerst een ticket.");
            return;
        }

        Reis gekozenReis = tickets.get(0).getReis();
        String bestandsNaam = gekozenReis.getBestandsNaam() + ".txt";

        try (FileWriter bestandsSchrijver = new FileWriter(bestandsNaam)) {

            bestandsSchrijver.write("=== BOARDINGLIJST ===\n");
            bestandsSchrijver.write("Traject: " + gekozenReis.getVan() + " -> " + gekozenReis.getNaar() + "\n");
            bestandsSchrijver.write("Tijdstip: " + gekozenReis.getTijdstip() + "\n\n");

            for (Ticket huidigTicket : tickets) {
                bestandsSchrijver.write(huidigTicket.getPassagier().toString() + "\n");
            }

            System.out.println("Boardinglijst aangemaakt: " + bestandsNaam);

        } catch (Exception fout) {
            System.out.println("Fout bij schrijven van bestand: " + fout.getMessage());
        }
    }

    private static String leesTekst(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int leesInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String invoer = scanner.nextLine();

            try {
                return Integer.parseInt(invoer);
            } catch (NumberFormatException fout) {
                System.out.println("Ongeldige invoer, geef een getal in.");
            }
        }
    }
}
