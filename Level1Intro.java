import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1Intro here.
 * 
 * @author 
 * @version 
 */
public class Level1Intro extends World {
    private int textStage = 0; // Tracks which text is currently shown
    private Speech speechBubble;

    public Level1Intro() {    
        super(1000, 600, 1);

        
        boss boss1 = new boss();
        addObject(boss1, getWidth() - 100, 150); 
        //baclground
        GreenfootImage stadium = new GreenfootImage("football_background.png"); 
        stadium.scale(1000, 601);
        setBackground(stadium);
        //speech bubble
        speechBubble = new Speech();
        addObject(speechBubble, 400, 250); 

        //first piece of text
        speechBubble.setText(
            "Boss: Hey, are you here to get hired for the Assistant Equipment \n" +
            "Manager position? For you to get hired, you first have to sort \n" +
            "the football teams jerseys from lowest to highest\n" +
            "in a short amount of time. Before you start, \n"+
            "let me explain the type of sorting method you’ll be using."
        );

        //text for continuing to the next stage
        showText("Press 'C' to continue.", getWidth() - 200, getHeight() - 50);
    }

    public void act() {
        if (textStage == 0 && Greenfoot.isKeyDown("c")) {
            //second piece of text
            speechBubble.setText(
                "It’s called Bubble Sorting, and here’s how it works:\n" +
                "Start at the beginning of the list and compare the first two jerseys.\n" +
                "If the first one is larger than the second, swap them. If not, leave\n" +
                "them. After you’ve compared and swapped the first two, move to\n" +
                "the next pair and do the same thing. Keep doing this all the\n" +
                "way through the list. Once you’ve gone through the entire list,\n" +
                "the largest jersey will be at the end. Then, start again at\n" +
                "the beginning but ignore the last jersey since it’s sorted.\n"+
                "Repeat this process until no swaps are needed."
            );

            // Update bottom right text
            showText("Press 'L' to start Level 1.", getWidth() - 200, getHeight() - 50);
            textStage = 1;
        } else if (textStage == 1 && Greenfoot.isKeyDown("l")) {
            // Transition to Level1
            Greenfoot.setWorld(new Level1());
        }
        if(Greenfoot.isKeyDown("f")){
            Greenfoot.setWorld(new Failed());
        }
    }
}