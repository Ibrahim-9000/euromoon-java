package trein;

public class Trein {
    private Locomotief locomotief;

    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
    }


    public int getCapaciteit() {
        return locomotief.getCapaciteit();
    }
}
