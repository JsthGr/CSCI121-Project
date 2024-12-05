import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Failed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Failed extends World
{

    /**
     * Constructor for objects of class Failed.
     * 
     */
    public Failed()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        showText("You failed the task.", getWidth() / 2, getHeight() / 2 - 50);
    }
}
