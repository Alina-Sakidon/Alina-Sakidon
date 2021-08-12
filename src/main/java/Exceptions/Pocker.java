//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Pocker {

    private String[] cardNames;
    private CardGenerator generator;
    private int gameUsers;
    private boolean isInitialize=false;

    public Pocker(int numberUsers)
    {
        if (numberUsers<2){
            throw new IllegalArgumentException("Numbers of users should be greater than 1");
        }
        gameUsers=numberUsers;
    }
    public void initialize(){
        generator = new CardGenerator();
        cardNames = getCardNames();
        isInitialize=true;
    }
    public void Play() throws GameNotInitializedException {
        if(!isInitialize){
          throw new GameNotInitializedException("Game isn't initialized. Invoke initialize method before Play");
        }
        System.out.println("Game started");

        List<Integer> usedCards = new ArrayList();

        for(int lapCard = 1; lapCard <= 5; ++lapCard) {
            System.out.println("Lap " + lapCard);

            for(int user = 1; user <= gameUsers; ++user) {
                int newCard = generator.GetNewCard(usedCards);
                usedCards.add(newCard);
                System.out.println("Игрок " + user + " получает карту " + cardNames[newCard]);
            }
        }
    }
    private String[] getCardNames() {
        String[] suits = {
                "Пик", "Бубен", "Черв", "Треф"
        };

        String[] rank = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Валет", "Королева", "Король", "Туз"};
        String[] cardNames = new String[52];
        int i = 0;
        for (String s:suits
             ) {
            for (String r : rank
                 ) {
                cardNames[i++] = s + r;
            }
        }
        return cardNames;
    }
}

