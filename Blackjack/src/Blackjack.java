public class Blackjack {
    public int blackjack(int a, int b)
    {
        return (a <= 21 && b <= 21) ? (a < b) ? b : a : (a <= 21 ^ b <= 21) ? a <= 21 ? a : b : 0;
    }
}
