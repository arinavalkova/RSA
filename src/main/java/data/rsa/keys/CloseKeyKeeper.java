package data.rsa.keys;

public class CloseKeyKeeper {

    private final int d;
    private final int n;

    public CloseKeyKeeper(int d, int n) {
        this.d = d;
        this.n = n;
    }

    public int getD() {
        return d;
    }

    public int getN() {
        return n;
    }
}
