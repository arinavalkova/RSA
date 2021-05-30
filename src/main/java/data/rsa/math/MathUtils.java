package data.rsa.math;

public class MathUtils {

    public int randomPrimeNumber(int lowerBound, int upperBound) {
        int number;
        int i;
        do {
            number = lowerBound + (int) (Math.random() * upperBound);
            for (i = 2; i < number; i++) {
                if (number % i == 0) {
                    break;
                }
            }
        } while (i != number);
        return number;
    }

    public int eulerFunction(int p, int q) {
        return (p - 1) * (q - 1);
    }

    public int openExhibitor(int phi) {
        int primeLessThanPhi;
        do {
            primeLessThanPhi = randomPrimeNumber(2, phi);
        } while (!isMutuallySimple(primeLessThanPhi, phi));
        return primeLessThanPhi;
    }

    private boolean isMutuallySimple(int a, int b) {
        return greatestCommonFactor(a, b) == 1;
    }

    private int greatestCommonFactor(int a, int b) {
        if (a == b)
            return a;
        else if (a > b)
            return greatestCommonFactor(a - b, b);
        else
            return greatestCommonFactor(b - a, a);
    }

    public int moduloInverse(int e, int phi) {
        int k = 1 + (int) (Math.random() * 10);
        while ((k * phi + 1) % e != 0) {
            k++;
        }
        return (k * phi + 1) / e;
    }

    public int exponentiate(int message, int a, int b) {
        int result = 1;
        while (a > 0) {
            if ((a & 1) == 1) {
                result = (result * message) % b;
                a -= 1;
            }
            message = (message * message) % b;
            a = a / 2;
        }
        return result;
    }
}
