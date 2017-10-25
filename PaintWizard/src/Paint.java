public class Paint {
    private int coverage;
    private double cost;
    private String name;
    private int capacity;

    public Paint(String name, double cost, int coverage, int capacity)
    {
        this.name = name;
        this.cost = cost;
        this.coverage = coverage;
        this.capacity = capacity;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public int getCoverage() {
        return coverage;
    }

    public int getCapacity() {
        return capacity;
    }

    public int waste(int coverageNeeded)
    {
        int bucketsNeeded = bucketsNeeded(coverageNeeded);
        return bucketsNeeded * coverage - coverageNeeded;
    }
    public double cost(int coverageNeeded)
    {
        int bucketsNeeded = bucketsNeeded(coverageNeeded);
        return bucketsNeeded * cost;
    }
    public int bucketsNeeded(int coverageNeeded)
    {
        return (int) Math.ceil((double) coverageNeeded/this.coverage/this.capacity);
    }
    public String toString()
    {
        return name + " costs" + " £" + cost + " and covers " + coverage + "m^2 per litre";
    }
}
