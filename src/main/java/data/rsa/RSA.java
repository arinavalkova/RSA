package data.rsa;

import domain.Cipher;

public class RSA implements Cipher {

    @Override
    public int decode(int message) {
        return message;
    }

    @Override
    public int encrypt(int message) {
        return message;
    }
}
