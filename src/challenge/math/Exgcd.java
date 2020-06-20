package challenge.math;

public class Exgcd {
    int x, y;
    int exgcd(int a, int b) {
        int d = a;
        if (b != 0) {
            d = exgcd(b, a % b);
            y -= (a / b) * x;
        } else {
            x = 1;
            y = 0;
        }
        return d;
    }
}
