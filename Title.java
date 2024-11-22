import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    /**
     * Act - do whatever the Title wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Title(){
        GreenfootImage title = new GreenfootImage(300,150);
        title.drawString("SPORTING SORTING",150,102);
        setImage(title);
    }
    public void act()
    {
        GreenfootImage title = new GreenfootImage(300,150);
        title.drawString("SPORTING SORTING",150,102);
        setImage(title);
        title.clear();
        title.drawImage(title, 150,102);
        Title title1 = new Title(); 
    }
}
