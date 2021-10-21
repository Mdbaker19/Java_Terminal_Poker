package data;

import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {

    private static final int size = 52;
    private static List<Cards> deck;
    private static List<Suites> suitesList;

    public static void init() {

        suitesList = new ArrayList<>();
        suitesList.add(Suites.SPADE);
        suitesList.add(Suites.HEART);
        suitesList.add(Suites.DIAMOND);
        suitesList.add(Suites.CLOVER);

        deck = createDeck();

//        print(deck, size);
    }

    private static List<Cards> createDeck() {
        List<Cards> deckList = new ArrayList<>();
        int suiteCount = 0;
        int valueCount = 0;
        for(int i = 0; i < size; i++) {
            suiteCount %= 4;
            valueCount %= Value.valueRefList.size();
            Cards card = new Cards(Value.valueRefList.get(valueCount), suitesList.get(suiteCount));
            deckList.add(card);
            suiteCount++;
            valueCount++;
        }
        return deckList;
    }

    private static List<Cards> shuffleDeck(List<Cards> cards) {
        Cards[] shuffledDeck = new Cards[52];
        for(int i = 0; i < cards.size(); i++) {
            // create a random number between i and size
            // set shuffledDeck[ranNum] to this card (?)
            //int ran = ;
        }
        return new ArrayList<>(Arrays.asList(shuffledDeck));
    }


}
