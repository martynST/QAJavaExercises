public class TooHot {
    public static void main()
    {

    }
    boolean tooHot(int temperature, boolean isSummer)
    {
        return (isSummer) ? (temperature >= 60 && temperature <= 100) ? true : false : (temperature >= 60 && temperature <= 90) ? true : false;
    }
}