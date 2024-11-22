import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //static final Color BLACK;
    //static final Color BLUE;
    private String title;
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
        addObject(player, getWidth() / 2, getHeight() / 2);

        
        showText("SPORTING SORTING", getWidth() / 2, getHeight() / 2 - 50);
        showText("Press ENTER to Start", getWidth() / 2, getHeight() / 2 + 50);
        
        
    }
    
    /**public void act() {
        
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new MainGameWorld()); 
        }
    }**/
}
