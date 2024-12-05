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

        // Create boss object
        boss boss1 = new boss();
        addObject(boss1, getWidth() - 100, 150); // Position boss on the right side

        // Add speech bubble
        speechBubble = new Speech();
        addObject(speechBubble, 400, 250); // Position the bubble to the left and lower

        // Display the first piece of text
        speechBubble.setText(
            "Boss: Hey, are you here to get hired for the Assistant Equipment \n" +
            "Manager position? For you to get hired, you first have to sort \n" +
            "the jerseys from least to greatest to sort the jerseys from least\n" +
            "to greatest in a short amount of time. Before you start, \n"+
            "let me explain the type of sorting method you’ll be using."
        );

        // Bottom-right text for continuing to the next stage
        showText("Press 'C' to continue.", getWidth() - 200, getHeight() - 50);
    }

    public void act() {
        if (textStage == 0 && Greenfoot.isKeyDown("c")) {
            // Display the second piece of text
            speechBubble.setText(
                "It’s called Bubble Sorting, and here’s how it works:\n" +
                "Start at the beginning of the list and compare the first two jerseys.\n" +
                "If the first one is larger than the second, swap them. If not, leave them.\n" +
                "After you’ve compared and swapped the first two, move to the next pair\n" +
                "and do the same thing. Keep doing this all the way through the list.\n" +
                "Once you’ve gone through the entire list, the largest jersey will be at the end.\n" +
                "Then, start again at the beginning but ignore the last jersey since it’s sorted.\n" +
                "Repeat this process until no swaps are needed."
            );

            // Update bottom-right text
            showText("Press 'L' to start Level 1.", getWidth() - 200, getHeight() - 50);
            textStage = 1;
        } else if (textStage == 1 && Greenfoot.isKeyDown("l")) {
            // Transition to Level1
            Greenfoot.setWorld(new Level1());
        }
    }
}