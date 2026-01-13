package personen;

import java.time.LocalDate;

public class Conducteur extends Personeelslid{
    public Conducteur(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum) {
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
    }
}
