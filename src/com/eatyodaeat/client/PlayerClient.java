package com.eatyodaeat.client;

/*
 * Runner object for the MVC
 * Main starter method or entry point for BabyYodaEat memory game
 */

import com.eatyodaeat.model.Music;


public class PlayerClient {

    public static void main(String[] args) {
//        BabyYodaEatApp baseApp = new BabyYodaEatApp();
//        baseApp.startGame();

        String filepath = "resources/gameThemeSong.wav";
        Music music = new Music();
        music.playMusic(filepath);


    }
}
