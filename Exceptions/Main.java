package com.company;

public class Main {
    public static final String RESET = "\033[0m";  // Text Reset
    public static final String RED = "\033[0;31m";
    public static final String YELLOW = "\033[0;33m";
    public static void main(String[] args)  {
        //to check the incorrect number of users
        try {
            Pocker invalidGame=new Pocker(0);
        } catch (Exception e) {
            System.out.println(YELLOW+e.getMessage()+RESET);
        }
        Pocker game = new Pocker(4);
        //game.initialize();
        try {
            // to check start playing without initializing
            game.Play();
        } catch (GameNotInitializedException e) {
            System.out.println(RED+e.getMessage()+RESET);
        }
    }

}



