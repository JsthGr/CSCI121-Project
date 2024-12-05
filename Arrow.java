import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoccerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    public Arrow(){
        GreenfootImage image = new GreenfootImage("soccer_player.png");

        image.scale(75, 150);
        
        
        setImage(image);
    }
}
