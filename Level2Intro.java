import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Intro extends World
{

    /**
     * Constructor for objects of class Level1Intro.
     * 
     */
    public Level2Intro()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        
        boss boss1 = new boss();
        addObject(boss1, getWidth()/2 , getHeight() /2);
        boss1.setLocation(900,100); 
        
    }
    
    public void act() {
        
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Level1()); 
        }
    }
    
}

