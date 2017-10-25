public class Basic {
    public static void main(String[] args)
    {
        int a = 3;
        int b = 6;
        int n = 10;
        boolean tf = true;
        String myString = getString();
        printString(myString);
        System.out.println(addNum(a,b));
        conditional(a,b,tf);
        conditional2(a,b,tf);
        iteration(n,a);
        int[] arrayOfInt = makeArray(n);
        array(arrayOfInt);
        printArray(arrayOfInt);
        itterArray(n);

    }
    private static void printString(String myString)
    {
        System.out.println(myString);
    }
    private static String getString()
    {
        return "Hello, World!";
    }
    private static int addNum(int a, int b)
    {
        return a+b;
    }
    private static int conditional(int a, int b, boolean tf)
    {
        if (tf)
        {
            return a+b;
        } else {
            return a*b;
        }
    }
    private static int conditional2(int a, int b, boolean tf)
    {
        if (a == 0)
        {
            return b;
        } else if (b == 0){
            return a;
        } else if (tf) {
            return a+b;
        } else {
            return a*b;
        }
    }
    private static void iteration(int n, int a)
    {
        for (int i = 0; i < n; i++)
        {
            conditional2(a,i,true);
        }
    }
    private static int[] makeArray(int n)
    {
        int[] arrayOfInt = new int[n];
        for (int i = 0; i < n; i++)
        {
            arrayOfInt[i] = i*2+3;
        }
        return arrayOfInt;
    }
    private static void array(int[] arrayOfInt)
    {
        for (int i = 0; i < arrayOfInt.length-1; i++)
        {
            conditional2(arrayOfInt[i], arrayOfInt[i+1], true);
        }
    }
    private static void printArray(int[] arrayOfInt)
    {
        for (int i : arrayOfInt)
        {
            System.out.println(i);
        }
    }
    private static void itterArray(int n)
    {
        int[] myArr = new int[n];
        System.out.println("Creating Array");
        for (int i = 0; i < n; i++)
        {
            System.out.println(myArr[i] = (i*12+33)%15);
        }
        System.out.println("Changing Array");
        for (int i = 0; i < n; i++)
        {
            System.out.println(myArr[i] *= 10);
        }
    }
}
