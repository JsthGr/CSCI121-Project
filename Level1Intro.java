import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1Intro here.
 * 
 * @author 
 * @version 
 */
public class Level1Intro extends World {
    private int textStage = 0; // Tracks which text is currently shown

    /**
     * Constructor for objects of class Level1Intro.
     */
    public Level1Intro() {    
        super(1000, 600, 1);

        // Create boss object
        boss boss1 = new boss();
        addObject(boss1, getWidth() / 2, getHeight() / 2);
        boss1.setLocation(900, 100); 

        // Display the first piece of text
        showText(
            "Boss: Hey, are you here to get hired for the Assistant Equipment Manager position?\n" +
            "For you to get hired, you have to sort the jerseys from least to greatest in a short amount of time.\n" +
            "Can you handle it? Before you start, let me explain the type of sorting method you’ll be using.", 
            getWidth() / 2, getHeight() / 2
        );

        // Bottom-right text for continuing to the next stage
        showText("Press 'C' to continue.", getWidth() - 200, getHeight() - 50);
    }

    public void act() {
        if (textStage == 0 && Greenfoot.isKeyDown("c")) {
            // Display the second piece of text
            showText(
                "It’s called Bubble Sorting, and here’s how it works. Start at the beginning of the list\n" +
                "and compare the first two jerseys. If the first one is larger than the second, swap them.\n" +
                "If not, leave them as they are. After you’ve compared and swapped the first two, move to\n" +
                "the next pair, which are the second and third jerseys, and do the same thing. Keep doing this\n" +
                "all the way through the list from left to right. Once you’ve gone through the entire list, the\n" +
                "largest jersey will have moved to the end. Then, start again at the beginning, but this time\n" +
                "ignore the last jersey since it is already in the correct spot. Keep repeating this process,\n" +
                "checking fewer jerseys each time, until no more swaps are needed. When no swaps happen in\n" +
                "a full pass through the list, the sorting is finished.", 
                getWidth() / 2, getHeight() / 2
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