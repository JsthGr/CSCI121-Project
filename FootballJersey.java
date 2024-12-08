import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * FootballJersey represents a jersey that displays a number.
 */
public class FootballJersey extends Actor {
    /**
     * Constructor to create a FootballJersey with a specific number.
     */
    public FootballJersey(int number) {
        GreenfootImage image = new GreenfootImage("football_jersey.png");
        image.scale(100, 150); 
        GreenfootImage text = new GreenfootImage("" + number, 24, Color.WHITE, new Color(0, 0, 0, 0));
        image.drawImage(text, image.getWidth() / 2 - text.getWidth() / 2, image.getHeight() / 2 - text.getHeight() / 2);
        setImage(image);
    }
}
