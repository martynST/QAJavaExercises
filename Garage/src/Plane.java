public class Plane extends Vehicle {
    private int numberOfpropellers;


    public Plane(String vehicleMake, String vehicleModle, int numberOfpropellers, int numberOfWheels)
    {
        super(vehicleMake, vehicleModle,"Plane", numberOfWheels);
        this.numberOfpropellers = numberOfpropellers;
    }
    public void travel()
    {
        System.out.println("Flies");
    }
    public String toString()
    {
        return super.toString() + " and has " + numberOfpropellers + " propellers.";
    }
    public int getNumberOfpropellers() {
        return numberOfpropellers;
    }
}
