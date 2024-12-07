import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hired here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hired extends World
{
    private Speech speechBubble;
    public Hired()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        boss boss1 = new boss();
        addObject(boss1, getWidth()/2 , getHeight() /2);
        boss1.setLocation(900,100); 
        
        speechBubble = new Speech();
        addObject(speechBubble, 400, 250);
        speechBubble.setText("Congrats. You clearly have the \n"+
         "skills to work here when can you start.");
         
        
            
    }
}
