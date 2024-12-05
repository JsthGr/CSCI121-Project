import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)

/**
 * A button for "Yes" or "No" interactions.
 */
public class YesNoButton extends Actor {
    private String label;

    public YesNoButton(String label) {
        this.label = label;
        GreenfootImage image = new GreenfootImage(100, 50);
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, 100, 50);
        image.setColor(Color.WHITE);
        image.drawString(label, 30, 30);
        setImage(image);
    }

    public String getLabel() {
        return label;
    }
}
