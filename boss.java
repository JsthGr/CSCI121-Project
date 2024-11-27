import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boss extends Actor
{
    public boss(){
        GreenfootImage image = new GreenfootImage("boss.png");

        image.scale(200, 225);
        
        
        setImage(image);
    }
}
