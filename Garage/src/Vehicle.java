public abstract class Vehicle {
    private String vehicleMake;
    private String vehicleModle;
    private String vehicleType;
    private int numberOfWheels;
    private int ID;
    private static int count = 0;

    public Vehicle (String vehicleMake, String vehicleModle, String vehicleType, int numberOfWheels)
    {
        this.vehicleMake = vehicleMake;
        this.vehicleModle = vehicleModle;
        this.vehicleType = vehicleType;
        this.numberOfWheels = numberOfWheels;
        this.ID = ++count;
    }

    public String getVehicleType()
    {
        return this.vehicleType;
    }
    public int getNumberOfWheels()
    {
        return this.numberOfWheels;
    }
    public String toString()
    {
        return "This vehicle is a " + vehicleType + " of make " +  vehicleModle + " and model " + vehicleModle;
    }
    public int getID()
    {
        return ID;
    }
    public boolean equals(Vehicle v)
    {
        return this.getID() == v.getID();
    }
    public abstract void travel();
}
