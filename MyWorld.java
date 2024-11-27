import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        
        GreenfootImage border = new GreenfootImage("Start_screen_background.png"); 
        border.scale(1000, 601);
        setBackground(border);
        
        Football_Player player = new Football_Player();
        addObject(player, getWidth()/2 , getHeight() /2);
        player.setLocation(200,300);
        
        SoccerPlayer player2 = new SoccerPlayer();
        addObject(player2, getWidth()*2 , getHeight() );
        player2.setLocation(800,300);
        
        showText("SPORTING SORTING", getWidth() / 2, getHeight() / 2 - 50);
        showText("Press ENTER to Start", getWidth() / 2, getHeight() / 2 + 50);
        
        
    }
    /**
    public void act() {
        
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level2()); 
        }
    }**/
}
