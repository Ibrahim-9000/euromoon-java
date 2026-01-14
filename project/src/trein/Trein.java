package trein;

public class Trein {
    private Locomotief locomotief;

    public Trein(Locomotief locomotief) {
        this.locomotief = locomotief;
    }

    public int getCapaciteit() {
        return locomotief.getCapaciteit();
    }


    public Locomotief getLocomotief() {
        return locomotief;
    }


    @Override
    public String toString() {
        return "Locomotief: " + locomotief.getType();
    }
}
