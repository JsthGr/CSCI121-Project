import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Failed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Failed extends World
{
    private Speech speechBubble;
    /**
     * Constructor for objects of class Failed.
     * 
     */
    public Failed()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        boss boss1 = new boss();
        addObject(boss1, getWidth()/2 , getHeight() /2);
        boss1.setLocation(900,100); 
        
        speechBubble = new Speech();
        addObject(speechBubble, 400, 250);
        speechBubble.setText("You failed the task. Your clearly not\n"+
         "prepared to work here. Come back when you're prepared.");
    }
}
