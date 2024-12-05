import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Speech here.
 * 
 * @author 
 * @version 
 */
public class Speech extends Actor {
    private GreenfootImage bubbleImage;
    private GreenfootImage textImage;
    private int bubbleWidth = 500;
    private int bubbleHeight = 300;

    public Speech() {
        bubbleImage = new GreenfootImage("speech_bubble.png");
        bubbleImage.scale(bubbleWidth, bubbleHeight);
        setImage(bubbleImage);
    }

    public void setText(String text) {
        // Clear the existing text
        textImage = new GreenfootImage(bubbleWidth - 20, bubbleHeight - 40); // Padding inside bubble
        textImage.setFont(new Font(true, false, 18)); // Font size
        textImage.setColor(Color.BLACK);
        textImage.clear();

        // Wrap the text and draw it inside the speech bubble
        String[] words = text.split(" ");
        String line = "";
        int y = 20; // Start drawing text from the top
        for (String word : words) {
            if (textImage.getFontMetrics().stringWidth(line + word) > textImage.getWidth()) {
                textImage.drawString(line, 10, y);
                line = word + " ";
                y += 20; // Move to the next line
            } else {
                line += word + " ";
            }
        }
        textImage.drawString(line, 10, y); // Draw the last line

        // Overlay the text onto the speech bubble
        bubbleImage.clear();
        bubbleImage.drawImage(new GreenfootImage("speech_bubble.png"), 0, 0);
        bubbleImage.scale(bubbleWidth, bubbleHeight);
        bubbleImage.drawImage(textImage, 10, 20);
        setImage(bubbleImage);
    }
}
