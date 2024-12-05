import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speech here.
 * 
 * @author 
 * @version 
 */
public class Speech extends Actor {
    public Speech() {
        GreenfootImage image = new GreenfootImage("speech_bubble.png");
        image.scale(650, 400); // Increased size of the bubble
        setImage(image);
    }

    public void setText(String text) {
        GreenfootImage bubbleImage = getImage(); // Get the speech bubble image
        bubbleImage.clear(); // Clear existing image

        // Redraw the bubble background
        GreenfootImage bubbleBackground = new GreenfootImage("speech_bubble.png");
        bubbleBackground.scale(650, 400); // Match bubble size
        bubbleImage.drawImage(bubbleBackground, 0, 0);

        // Add the text to the bubble
        bubbleImage.setFont(new Font(true, false, 18)); // Set font size
        bubbleImage.setColor(Color.BLACK);

        // Manually position text
        int x = 20;
        int y = 50; // Start below the top edge
        for (String line : text.split("\n")) {
            bubbleImage.drawString(line, x, y);
            y += 25; // Move down for each line
        }
        setImage(bubbleImage);
    }
}