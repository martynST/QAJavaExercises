import java.util.ArrayList;

public class Garage {
    private int maxCapacity;
    private ArrayList<Vehicle> garage = new ArrayList<Vehicle>();

    public Garage(int maxCapacity)
    {
        this.maxCapacity = maxCapacity;
    }

    public void addVehicle(Vehicle v)
    {
        garage.add(v);
    }

    public void removeVehicle(int ID)
    {
        for (int i = 0; i < garage.size(); i++)
            if (ID == garage.get(i).getID())
            {
                garage.remove(garage.get(i));
            }
    }
    public void removeVehicle(String vehicleType)
    {
        for (int i = garage.size()-1; i >= 0; i--)
            if (garage.get(i).getVehicleType().equals(vehicleType))
            {
                garage.remove(garage.get(i));
            }
    }
    public void removeAll()
    {
        garage.removeAll(garage);
    }
    public String toString()
    {
        String returnString = "";
        for(int i = 0; i < garage.size(); i++)
        {
            returnString += "ID: " + garage.get(i).getID() + " " + garage.get(i).toString() + "\n";
        }
        return returnString;
    }
    public int calculateBill()
    {
        int cost = 0;
        for (Vehicle v : garage)
            cost += calculateCost(v);
        return cost;
    }
    private int calculateCost(Vehicle v)
    {

        switch (v.getVehicleType()){
            case "Car":
                return ((((Car) v).getIsConverable()) ? 20000 : 10000) +  v.getNumberOfWheels()*250;
            case "Motorcycle":
                return (((Motorcycle) v).getHasCarrage() ? 15000 : 7500) + v.getNumberOfWheels()*250;
            case "Plane":
                return 20000 + ((Plane) v).getNumberOfpropellers()*500 + v.getNumberOfWheels()*250;
            default:
                return 0;
        }
    }
}
