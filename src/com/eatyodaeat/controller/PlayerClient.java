package com.eatyodaeat.controller;

/*
 * Runner object for the MVC
 * Main starter method or entry point for BabyYodaEat memory game
 */

public class PlayerClient {

    public static void main(String[] args) {
        BabyYodaEatApp baseApp = new BabyYodaEatApp();
        baseApp.startGame();

        new ProgressBar();



    }
}
