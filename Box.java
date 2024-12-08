import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    public Box(int number) {
        GreenfootImage image = new GreenfootImage("boc.png");
        image.scale(100, 100); 
        GreenfootImage text = new GreenfootImage("" + number, 24, Color.WHITE, new Color(0, 0, 0, 0));
        image.drawImage(text, image.getWidth() / 2 - text.getWidth() / 2, image.getHeight() / 2 - text.getHeight() / 2);
        setImage(image);
    }
}
