package personen;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Personeelslid extends Persoon{
    protected List<String> certificaties = new ArrayList<>();

    public Personeelslid(String voornaam, String achternaam, String rijksregisternummer, LocalDate geboortedatum) {
        super(voornaam, achternaam, rijksregisternummer, geboortedatum);
    }
    public void addCertificatie(String certificatie) {
        certificaties.add(certificatie);
    }

}
