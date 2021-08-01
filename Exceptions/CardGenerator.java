package com.company;

import java.util.List;
import java.util.Random;

public class CardGenerator {
    public int GetNewCard(List<Integer> usedCards) {
        Random random = new Random(1);

        int newCard;
        do {
            newCard = random.nextInt(52);
        } while(usedCards.contains(newCard));

        return newCard;
    }
}
