package data.rsa.keys;

public class OpenKeySender {

    private final int e;
    private final int n;

    public OpenKeySender(int e, int n) {
        this.e = e;
        this.n = n;
    }

    public int receiveE() {
        return e;
    }

    public int receiveN() {
        return n;
    }
}
