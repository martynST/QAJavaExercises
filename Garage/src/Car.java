public class Car extends Vehicle {
    private boolean isConvertable;

    public Car(String vehicleMake, String vehicleModle, int numberOfWheels, boolean isConvertable)
    {
        super(vehicleMake, vehicleModle, "Car", numberOfWheels);
        this.isConvertable = isConvertable;
    }
    public void travel()
    {
        System.out.println("Drives");
    }
    public String toString()
    {
        String myString = super.toString();
        if (isConvertable)
            myString += " and is a convertable.  ";
        else
            myString += " and is not a convertable.";
        return myString;
    }
    public boolean getIsConverable()
    {
        return this.isConvertable;
    }
}
