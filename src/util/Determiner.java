package util;

import data.Cards;
import data.Suites;
import data.Value;
import data.WinningCombos;

import java.util.*;

public class Determiner {

    public static int getHandPoints(List<Cards> playerHand, List<Cards> tableCards) {

        List<Cards> set = mergeCards(playerHand, tableCards);
        List<Integer> points = new ArrayList<>();
        HashMap<Cards, Integer> cardCounts = mapCardsToQuantity(set);

        boolean containsStraight = isStraight(set);

        if (containsStraight) {
            points.add(WinningCombos.STRAIGHT.getVal());
        }

        if (isPair(set)) {
            if (isThreeOfAKind(cardCounts)) {
                if (isFullHouse(cardCounts)) {
                    points.add(WinningCombos.FULL_HOUSE.getVal());
                } else if (isFourOfAKind(cardCounts)) {
                    points.add(WinningCombos.FOUR_OF_A_KIND.getVal());
                }
                points.add(WinningCombos.THREE_OF_A_KIND.getVal());
            }
            points.add(WinningCombos.PAIR.getVal());
        }


        if (isFlush(set)) {
            // if it is a flush and a straight from earlier, is straight flush. no need to check again
            if (containsStraight) {
                if (isRoyalFlush(set)) {
                    points.add(WinningCombos.ROYAL_FLUSH.getVal());
                }
                points.add(WinningCombos.STRAIGHT_FLUSH.getVal());
            }
            points.add(WinningCombos.FLUSH.getVal());
        }

        int possiblePoints = mapMaxFromPoints(points);

        if(possiblePoints == 0) {
            int highCardVal = findHighCard(set);
            System.out.println(Value.getWordFromPoints(highCardVal));
            return highCardVal;
        } else {
            return possiblePoints;
        }
    }

    private static int findHighCard(List<Cards> cards) {
        int max = Integer.MIN_VALUE;
        for(Cards card : cards) {
            int currentCardValue = card.getVal().getValue();
            if(currentCardValue > max) {
                max = currentCardValue;
            }
        }
        return max;
    }

    // check every card against each other for a match..
    private static boolean isPair(List<Cards> cards) {
        Set<Cards> cardSet = new HashSet<>();
        for (Cards card : cards) {
            if (cardSet.contains(card)) return true;
            cardSet.add(card);
        }
        return false;
    }

    private static boolean isThreeOfAKind(HashMap<Cards, Integer> cardCounts) {
        for(int val : cardCounts.values()) {
            if(val >= 3) return true;
        }
        return false;
    }

    // how can I account for ace...
    private static boolean isStraight(List<Cards> cards) {
        /* sort the cards by value, iterate and check next is 1+ of prev for 5 runs*/

        List<Cards> sortedCards = Util.sortDeck(cards, cards.size());
        int base = 1;
        for (int i = 0; i < sortedCards.size() - 1; i++) {
            int curr = sortedCards.get(i).getVal().getValue();
            int next = sortedCards.get(i + 1).getVal().getValue();
            if (curr + 1 == next) {
                base++;
            } else {
                base = 1;
            }
            if (base > 4) return true;
        }
        return false;
    }

    // add each Suite to a set, if one contains at least 5 of a Suite, flush
    private static boolean isFlush(List<Cards> cards) {
        HashMap<Suites, Integer> suitesSet = new HashMap<>();
        for (Cards c : cards) {
            Suites suites = c.getSuite();
            suitesSet.merge(suites, 1, Integer::sum);
        }
        for(int val : suitesSet.values()) {
            if(val >= 5) return true;
        }
        return false;
    }

    private static boolean isFullHouse(HashMap<Cards, Integer> cardCounts) {
        boolean threeFound = false;
        boolean twoFound = false;
        for(int val : cardCounts.values()) {
            if(val == 3) threeFound = true;
            if(val == 2) twoFound = true;
        }
        return threeFound && twoFound;
    }

    private static boolean isFourOfAKind(HashMap<Cards, Integer> cardCounts) {
        for(int val : cardCounts.values()) {
            if(val >= 4) return true;
        }
        return false;
    }


    private static boolean isRoyalFlush(List<Cards> cards) {
        // only runs when a flush is already present
        // easy check for existence of each card 10 -> ace ? boring but will work..
        List<Value> cardValuesNeeded = new ArrayList<>(Arrays.asList(Value.TEN, Value.JACK, Value.QUEEN, Value.KING, Value.ACE));
        for(Cards c : cards) {
            Value cardVal = c.getVal();
            cardValuesNeeded.remove(cardVal);
        }
        return cardValuesNeeded.size() < 1;
    }


    private static List<Cards> mergeCards(List<Cards> playerHand, List<Cards> tableCards) {
        List<Cards> set = new ArrayList<>(tableCards);
        set.addAll(playerHand);
        return set;
    }

    private static int mapMaxFromPoints(List<Integer> pointList) {
        int maxPointVal = getMax(pointList);
        System.out.println(WinningCombos.matchVal(maxPointVal));
        return maxPointVal;
    }

    private static int getMax(List<Integer> list) {
        if(list.size() < 1) return 0;
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                idx = i;
                max = list.get(i);
            }
        }
        return list.get(idx);
    }

    private static HashMap<Cards, Integer> mapCardsToQuantity(List<Cards> cards) {
        HashMap<Cards, Integer> map = new HashMap<>();
        for(Cards c : cards) {
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }

}
