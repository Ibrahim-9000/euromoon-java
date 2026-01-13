package ticket;

import personen.Passagier;
import reis.Reis;

public class Ticket {

    private Passagier passagier;
    private Reis reis;
    private Klasse klasse;

    public Ticket(Passagier passagier, Reis reis, Klasse klasse) {
        this.passagier = passagier;
        this.reis = reis;
        this.klasse = klasse;
    }

    public Passagier getPassagier() {
        return passagier;
    }
}
