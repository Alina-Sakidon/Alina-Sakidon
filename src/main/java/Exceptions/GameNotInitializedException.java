package com.company;

public class GameNotInitializedException extends Exception{
    public GameNotInitializedException() {
        super();
    }

    public GameNotInitializedException(String s) {
        super(s);
    }
}
