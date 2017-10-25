import static org.junit.Assert.*;
import org.junit.Test;

public class UniqueSumTest {
    @Test
    public void test1()//3 unique
    {
        UniqueSum us = new UniqueSum();
        assertEquals(6,us.uniqueSum(1,2,3));
    }
    @Test
    public void test2()//1 unique
    {
        UniqueSum us = new UniqueSum();
        assertEquals(2,us.uniqueSum(3,2,3));
    }
    @Test
    public void test3()//0 unique
    {
        UniqueSum us = new UniqueSum();
        assertEquals(0,us.uniqueSum(3,3,3));
    }
    @Test
    public void test4()//negatives
    {
        UniqueSum us = new UniqueSum();
        assertEquals(1,us.uniqueSum(3,-3,1));
    }
}