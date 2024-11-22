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
        title = "SPORTING SORTING";
        GreenfootImage border = new GreenfootImage("Start_screen_background.png"); 
        border.scale(1000, 601);
        setBackground(border);
        Color colorVariable1 = new Color(1, 1,1);
        Color colorVariable2 = new Color(2, 2,2);
        Font ss = new Font("sport", true, false, 20);
        GreenfootImage s = new GreenfootImage(title,20,colorVariable1,colorVariable2);
        s.drawString("HI",50,50);
        s.setFont(ss);
        
        //s.toString("HI");
        
    }
    
}
