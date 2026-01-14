package trein;

public abstract class Locomotief {
    protected int maxWagons;
    protected int capaciteit = 80;

    public int getCapaciteit() {
        return capaciteit;
    }

    public int getMaxWagons() {
        return maxWagons;
    }


    public abstract String getType();
}
