package challenge.math;

public class Gcd {
    public static int gcd(int a, int b){
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
