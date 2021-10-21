package data;

import java.util.ArrayList;
import java.util.List;

public enum Value {

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    private final int val;
    public static List<Value> valueRefList = initValueRefList();

    Value(int val) {
        this.val = val;
    }

    public int getValue() {
        return val;
    }

    public static Value getWordFromPoints(int points) {
        return valueRefList.get(points - 2);
    }

    private static List<Value> initValueRefList() {
        List<Value> valueRefList = new ArrayList<>();
        valueRefList.add(Value.ACE);
        valueRefList.add(Value.TWO);
        valueRefList.add(Value.THREE);
        valueRefList.add(Value.FOUR);
        valueRefList.add(Value.FIVE);
        valueRefList.add(Value.SIX);
        valueRefList.add(Value.SEVEN);
        valueRefList.add(Value.EIGHT);
        valueRefList.add(Value.NINE);
        valueRefList.add(Value.TEN);
        valueRefList.add(Value.JACK);
        valueRefList.add(Value.QUEEN);
        valueRefList.add(Value.KING);
        return valueRefList;
    }
}
