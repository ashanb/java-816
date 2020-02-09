package com.ocp11;

import com.ocp11.world.HelloWorld;
import com.ocp11.youtube.HelloYouTube;

public class Main {
    public static void main(String[] args) {
        HelloYouTube helloYouTube = new HelloYouTube();
        helloYouTube.print();

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.print();
    }
}
