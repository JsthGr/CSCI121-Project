import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;
/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private boolean timerAdded = false;
    private Timer timer;
    private ArrayList<Integer> numbersp; 
    private ArrayList<Integer> numbersr;
    private int currentIndex = 0; 
    private boolean isSorted = false; 
    private GreenfootImage display; 
    private YesNoButton yesButton;
    private YesNoButton noButton;
    private ArrayList<FootballJersey> jerseys; 
    private Arrow arrow; 
    private final int TIME_LIMIT = 60;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        GreenfootImage court = new GreenfootImage("basketball_court.png"); 
        court.scale(1000, 601);
        setBackground(court);
        
        numbersp = generateRandomNumbers(10, 1, 80);
        numbersr = generateRandomNumbers(10, 1, 20);
        
        boss boss1 = new boss();
        addObject(boss1, getWidth()/2 , getHeight() /2);
        boss1.setLocation(900,100);
    }
    
    private ArrayList<Integer> generateRandomNumbers(int count, int min, int max) {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumbers.add(Greenfoot.getRandomNumber(max - min + 1) + min);
        }
        return randomNumbers;
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("n")) {
           
            }
    }
}
