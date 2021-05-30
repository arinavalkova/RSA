package data.rsa;

import data.rsa.keys.CloseKeyKeeper;
import data.rsa.keys.OpenKeySender;
import data.rsa.math.MathUtils;
import domain.Cipher;

public class RSA implements Cipher {

    private static final int PRIME_LOWER_BOUND = 16;
    private static final int PRIME_UPPER_BOUND = 100;

    private OpenKeySender openKeySender;
    private CloseKeyKeeper closeKeyKeeper;

    private final MathUtils mathUtils;

    public RSA() {
        this.mathUtils = new MathUtils();
    }

    @Override
    public int decode(int message) {
        return mathUtils.exponentiate(message, closeKeyKeeper.getD(), closeKeyKeeper.getN());
    }

    @Override
    public int encrypt(int message) {
        return mathUtils.exponentiate(message, openKeySender.receiveE(), openKeySender.receiveN());
    }

    @Override
    public void findKeys() {
        int p;
        int q;
        do {
            p = mathUtils.randomPrimeNumber(PRIME_LOWER_BOUND, PRIME_UPPER_BOUND);
            q = mathUtils.randomPrimeNumber(PRIME_LOWER_BOUND, PRIME_UPPER_BOUND);
        } while (p == q);

        int n = p * q;
        int phi = mathUtils.eulerFunction(p, q);
        int e = mathUtils.openExhibitor(phi);
        openKeySender = new OpenKeySender(e, n);
        int d = mathUtils.moduloInverse(e, phi);
        closeKeyKeeper = new CloseKeyKeeper(d, n);
    }
}
