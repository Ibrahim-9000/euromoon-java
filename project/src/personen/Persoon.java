package personen;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Persoon {
    protected String voornaam;
    protected String achternaam;
    protected String rijksregisternummer;
    protected LocalDate geboortedatum;


    public Persoon(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.rijksregisternummer = rijksregisternummer;
        this.geboortedatum = geboortedatum;
    }


    @Override
    public String toString() {
        return voornaam + "" + achternaam + "(Rijksregisternummer: " + rijksregisternummer + ", Geboortedatum: " + geboortedatum + ")";
    }
}


