package com.eatyodaeat.controller;

/*
 * Runner object for the MVC
 * Main starter method or entry point for BabyYodaEat memory game
 */

import com.eatyodaeat.controller.BabyYodaEatApp;
import com.eatyodaeat.model.ProgressBar;

public class PlayerClient {

    public static void main(String[] args) {
        BabyYodaEatApp baseApp = new BabyYodaEatApp();
        baseApp.startGame();

        ProgressBar progressBar = new ProgressBar();



    }
}
