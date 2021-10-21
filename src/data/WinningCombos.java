package data;

import java.util.ArrayList;
import java.util.List;

public enum WinningCombos {

    HIGH_CARD(0),
    PAIR(1),
    TWO_PAIR(2),
    THREE_OF_A_KIND(3),
    STRAIGHT(4),
    FLUSH(5),
    FULL_HOUSE(6),
    FOUR_OF_A_KIND(7),
    STRAIGHT_FLUSH(8),
    ROYAL_FLUSH(9);

    private final int val;

    WinningCombos(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public static String matchVal(int val) {
        List<WinningCombos> notWorthDoingMaybe = new ArrayList<>();
        notWorthDoingMaybe.add(WinningCombos.HIGH_CARD);
        notWorthDoingMaybe.add(WinningCombos.PAIR);
        notWorthDoingMaybe.add(WinningCombos.TWO_PAIR);
        notWorthDoingMaybe.add(WinningCombos.THREE_OF_A_KIND);
        notWorthDoingMaybe.add(WinningCombos.STRAIGHT);
        notWorthDoingMaybe.add(WinningCombos.FLUSH);
        notWorthDoingMaybe.add(WinningCombos.FULL_HOUSE);
        notWorthDoingMaybe.add(WinningCombos.FOUR_OF_A_KIND);
        notWorthDoingMaybe.add(WinningCombos.STRAIGHT_FLUSH);
        notWorthDoingMaybe.add(WinningCombos.ROYAL_FLUSH);
        return notWorthDoingMaybe.get(val).toString();
    }
}
