package reis;

import personen.Personeelslid;
import trein.Trein;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reis {
    private String van;
    private String naar;
    private LocalDateTime tijdstip;
    private Trein trein;
    private List<Personeelslid> personeel = new ArrayList<>();

    public Reis(String van, String naar, LocalDateTime tijdstip) {
        this.van = van;
        this.naar = naar;
        this.tijdstip = tijdstip;
    }

    public void setTrein(Trein trein) {
        this.trein = trein;
    }

    public void voegPersoneelToe(Personeelslid personeelslid) {
        personeel.add(personeelslid);
    }

    public String getBestandsNaam() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        return van.replace(" ", "_") + "_" + naar.replace(" ", "_") + "_" + tijdstip.format(formatter);
    }

    public Trein getTrein() {
        return trein;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public String getVan() {
        return van;
    }

    public String getNaar() {
        return naar;
    }
}
