import data.*;
import util.Determiner;
import util.Input;
import util.Rules;
import util.Util;

import java.util.*;

public class Game {

    public static void main(String[] args) {
        Deck.init();

        List<Cards> testTable = new ArrayList<>();
        List<Cards> testHand = new ArrayList<>();

        Cards ace = new Cards(Value.ACE, Suites.DIAMOND);
        Cards two = new Cards(Value.TWO, Suites.CLOVER);
        Cards three = new Cards(Value.THREE, Suites.SPADE);
        Cards four = new Cards(Value.FOUR, Suites.HEART);
        Cards five = new Cards(Value.FIVE, Suites.CLOVER);
        Cards six = new Cards(Value.SIX, Suites.HEART);
        Cards seven = new Cards(Value.SEVEN, Suites.HEART);
        Cards eight = new Cards(Value.EIGHT, Suites.HEART);
        Cards nine = new Cards(Value.NINE, Suites.HEART);
        Cards ten = new Cards(Value.TEN, Suites.SPADE);

        Cards jack = new Cards(Value.JACK, Suites.SPADE);
        Cards queen = new Cards(Value.QUEEN, Suites.SPADE);
        Cards king = new Cards(Value.KING, Suites.SPADE);
        Cards king2 = new Cards(Value.KING, Suites.SPADE);

        testTable.add(two);
        testTable.add(ace);
        testTable.add(ace);
        testTable.add(four);
        testTable.add(queen);

        testHand.add(ace);
        testHand.add(ace);


        System.out.println(Determiner.getHandPoints(testHand, testTable));


        // show player hand

        // place bet

        // 3 cards from dealer

        // bet

        // 4th from dealer

        // bet

        // 5th from dealer

        // bet

        // determine winning hands if any and compare winningCombo point values



    }

}
