import static org.junit.Assert.*;
import org.junit.Test;

public class TooHotTest {
    @Test
    public void test1()
    {
        TooHot th = new TooHot();
        assertTrue(th.tooHot(65,true));
    }
    @Test
    public void test2()
    {
        TooHot th = new TooHot();
        assertTrue(th.tooHot(65,false));
    }
    @Test
    public void test3()
    {
        TooHot th = new TooHot();
        assertFalse(th.tooHot(115, true));
    }
    @Test
    public void test4()
    {
        TooHot th = new TooHot();
        assertFalse(th.tooHot(95, false));
    }
    @Test
    public void test5()
    {
        TooHot th = new TooHot();
        assertFalse(th.tooHot(20, true));
    }
    @Test
    public void test6()
    {
        TooHot th = new TooHot();
        assertFalse(th.tooHot(20, false));
    }
}