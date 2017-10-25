public class UniqueSum {
    public static void main()
    {

    }
    public int uniqueSum(int a, int b, int c)
    {
        int[] myIntArr = {a,b,c};
        int sum = 0;
        for (int i = 0; i < myIntArr.length; i++) {
            boolean match = false;
            for (int j = 0; j < myIntArr.length; j++)
            {
                if (i != j)
                {
                    if (myIntArr[i] == myIntArr[j])
                    {
                        match = true;
                        break;
                    }
                }
            }
            if (!match)
            {
                sum += myIntArr[i];
            }
        }
        return sum;
    }
}
