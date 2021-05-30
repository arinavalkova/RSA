package domain;

public interface Cipher {

    int decode(int message);

    int encrypt(int message);

    void findKeys();
}
