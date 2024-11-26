import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoccerPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoccerPlayer extends Actor
{
    public SoccerPlayer(){
        GreenfootImage image = new GreenfootImage("soccer_player.png");

        image.scale(250, 400);
        
        
        setImage(image);
    }
}
