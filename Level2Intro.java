import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1Intro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2Intro extends World
{
    private Speech speechBubble;
    private int textStage = 0;
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
        
        GreenfootImage court = new GreenfootImage("basketball_court.png"); 
        court.scale(1000, 601);
        setBackground(court);
        
        //speech bubble
        speechBubble = new Speech();
        addObject(speechBubble, 400, 250); 

        //first piece of text
        speechBubble.setText(
            "Boss: Good Job, you passed the first test. \n" +
            "Now Im gonna need some help with the basketball team."
        );

        //text for continuing to the next stage
        showText("Press 'C' to continue.", getWidth() - 200, getHeight() - 50);
    }
    
    public void act() {
        if (textStage == 0 && Greenfoot.isKeyDown("c")){
            speechBubble.setText(
                "Your task is still sorting but do it \n"+
                "alphabetically this time. "
            );

            // Update bottom right text
            showText("Press 'L' to start Level 2.", getWidth() - 200, getHeight() - 50);
            textStage = 1;
        }
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new Level1()); 
        }
    }
    
}

