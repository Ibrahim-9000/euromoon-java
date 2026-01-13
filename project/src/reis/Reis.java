package reis;

import personen.*;
import trein.Trein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reis {
    private String van;
    private String naar;
    private LocalDate tijdstip;
    private Trein trein;
    private List<Personeelslid> personeel = new ArrayList<>();



    public Reis(String van, String naar, LocalDate tijdstip) {
        this.van = van;
        this.naar = naar;
        this.tijdstip = tijdstip;
    }

    public void setTrein(Trein trein) {
        this.trein = trein;
    }

    public void voegPersoneelToe(Personeelslid  personeelslid) {
        personeel.add(personeelslid);
    }

    public String getBestandsNaam() {
        return van+" "+naar+" "+tijdstip;
    }

    public Trein getTrein() {
        return trein;
    }




}
