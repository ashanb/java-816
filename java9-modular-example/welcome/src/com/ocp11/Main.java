package com.ocp11;

import com.ocp11.world.HelloWorld;
import com.ocp11.youtube.HelloYouTube;
//import main.java1.DEF; can not access
import main.java2.ABC; // class without a module.

public class Main {
    public static void main(String[] args) {
        HelloYouTube helloYouTube = new HelloYouTube();
        helloYouTube.print();

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.print();
        ABC abc = new ABC();
        //DEF def = new DEF();
    }
}
