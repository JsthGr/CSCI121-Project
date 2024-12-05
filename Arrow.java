import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoccerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Arrow extends Actor {
    public Arrow() {
        GreenfootImage image = new GreenfootImage("arrow2.png");
        image.scale(75, 150);
        setImage(image);
    }

    public void pointTo(int x, int y) {
        setLocation(x, y + 120); // Position the arrow above the target
        setRotation(0); // Ensure arrow points upwards
    }
}
