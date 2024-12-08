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
    private boolean isPointsSorted = false;
    private boolean isReboundsSorted = false;
    private GreenfootImage display; 
    private YesNoButton yesPointButton;
    private YesNoButton noPointButton;
    private YesNoButton yesReboundButton;
    private YesNoButton noReboundButton;
    private ArrayList<Box> boxesP; 
    private ArrayList<Box> boxesR;
    private Arrow arrowP;
    private Arrow arrowR;
    private final int TIME_LIMIT = 120;
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
        
        yesPointButton = new YesNoButton("Yes");
        noPointButton = new YesNoButton("No");
        addObject(yesPointButton, 100, 500);
        addObject(noPointButton, 300, 500);
        
        yesReboundButton = new YesNoButton("Yes");
        noReboundButton = new YesNoButton("No");
        addObject(yesReboundButton, 700, 500);
        addObject(noReboundButton, 900, 500);
        
        boss boss1 = new boss();
        addObject(boss1, getWidth()/2 , getHeight() /2);
        boss1.setLocation(900,100);
        
        arrowP = new Arrow();
        addObject(arrowP, 0, 0); 
        updatePointArrowPosition();
        
        arrowR = new Arrow();
        addObject(arrowR, 0, 0); 
        updateRebArrowPosition();
        
        timer = new Timer();
        
        showText("Rebounds", getWidth() - 200, getHeight() - 50);
        showText("Points", getWidth() - 800, getHeight() - 50);
        showText("Press SPACE to Start", getWidth()/2  , getHeight()/2  -  200);
    }
    
    private ArrayList<Integer> generateRandomNumbers(int count, int min, int max) {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumbers.add(Greenfoot.getRandomNumber(max - min + 1) + min);
        }
        return randomNumbers;
    }
    
    private boolean isPointsSorted() {
        for (int i = 0; i < numbersp.size() - 1; i++) {
            if (numbersp.get(i) > numbersp.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isReboundsSorted() {
        for (int i = 0; i < numbersr.size() - 1; i++) {
            if (numbersr.get(i) > numbersr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    private void updatePointArrowPosition() {
        if (currentIndex < boxesP.size() - 1) {
            Box leftBox = boxesP.get(currentIndex);
            arrowP.pointTo(leftBox.getX(), leftBox.getY());
        }
    }
    
    private void updateRebArrowPosition() {
        if (currentIndex < boxesP.size() - 1) {
            Box leftBox = boxesP.get(currentIndex);
            arrowP.pointTo(leftBox.getX(), leftBox.getY());
        }
    }
    
    public void act(){
        if (!timerAdded && Greenfoot.isKeyDown("space")) {
        addObject(timer, 129, 30);
        timer.start(); 
        timerAdded = true; 
    }
    
    if (timerAdded && timer.getElapsedTimeInSeconds() > TIME_LIMIT) {
        Greenfoot.setWorld(new Failed()); 
    }
    
    if (isPointsSorted && isReboundsSorted) {
        Greenfoot.setWorld(new Hired());
    }
    
    }
}
