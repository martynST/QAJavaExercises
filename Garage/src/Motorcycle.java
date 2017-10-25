public class Motorcycle extends Vehicle{

    private boolean hasCarrage;

    public Motorcycle(String vehicleMake, String vehicleModle, int numberOfWheels, boolean hasCarrage)
    {
        super(vehicleMake, vehicleModle, "Motorcycle", numberOfWheels);
    }
    public boolean getHasCarrage()
    {
        return hasCarrage;
    }
    public String toString()
    {
        if (hasCarrage)
            return super.toString() + " and has a side carrage.";
        else
            return super.toString() + " and does not have a side carrage.";
    }
    public void travel()
    {
        System.out.println("Drives");
    }
}
