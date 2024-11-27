import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        GreenfootImage court = new GreenfootImage("basketball_court.png"); 
        court.scale(1000, 601);
        setBackground(court);
        
        boss boss1 = new boss();
        addObject(boss1, getWidth()/2 , getHeight() /2);
        boss1.setLocation(900,100);
    }
}
