package data;

public class Cards {

    private final Value val;
    private Suites suite;

    public Cards(Value val, Suites suite) {
        this.val = val;
        this.suite = suite;
    }

    public Suites getSuite() {
        return suite;
    }

    public void setSuite(Suites suite) {
        this.suite = suite;
    }

    public Value getVal() {
        return val;
    }
}
