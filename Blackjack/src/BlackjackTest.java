import static org.junit.Assert.*;
import org.junit.Test;

public class BlackjackTest {
    @Test
    public void test1() {// b > a, a < 22, b < 22
        Blackjack b = new Blackjack();
        assertEquals(10,b.blackjack(5,10));
    }
    @Test
    public void test2() {// b < a, a < 22, b < 22
        Blackjack b = new Blackjack();
        assertEquals(15,b.blackjack(15,10));
    }
    @Test
    public void test3() {// b < a, a > 22, b < 22
        Blackjack b = new Blackjack();
        assertEquals(10,b.blackjack(62,10));
    }
    @Test
    public void test4() {// b > a, a < 22, b > 22
        Blackjack b = new Blackjack();
        assertEquals(5,b.blackjack(5,46));
    }
    @Test
    public void test5() {// b > a, a > 22, b > 22
        Blackjack b = new Blackjack();
        assertEquals(0,b.blackjack(445,654));
    }
    @Test
    public void test6() {// b < a, a > 22, b > 22
        Blackjack b = new Blackjack();
        assertEquals(0,b.blackjack(756,654));
    }
}