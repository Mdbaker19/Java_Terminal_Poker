package util;

import data.Cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static void print(List<Cards> deck, int size){
        deck = Util.sortDeck(deck, size);
        for(Cards c : deck) {
            System.out.println();
            System.out.println(c.getVal().getValue());
            System.out.println(c.getVal());
            System.out.println(c.getSuite());
        }
    }

    public static List<Cards> sortDeck(List<Cards> deck, int size) {
        Cards[] d = new Cards[size];
        for(int i = 0; i < size; i++) {
            d[i] = deck.get(i);
        }
        return new ArrayList<>(Arrays.asList(sort(d)));
    }

    private static Cards[] sort(Cards[] d) {
        for(int i = 0; i < d.length - 1; i++) {
            int next = i;
            while(next >= 0 && d[next].getVal().getValue() > d[next + 1].getVal().getValue()) {
                swap(d, next, next + 1);
                next--;
            }
        }
        return d;
    }

    private static void swap(Cards[] d, int prev, int next) {
        Cards c = d[prev];
        d[prev] = d[next];
        d[next] = c;
    }

}
