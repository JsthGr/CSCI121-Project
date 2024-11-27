import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TennisRacket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TennisRacket extends Actor
{
    public TennisRacket(){
        GreenfootImage image = new GreenfootImage("tennis.png");

        image.scale(150, 150);
        
        
        setImage(image);
    }
}
