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
        
        boxesP = new ArrayList<>();
        displayBoxPoint();
        
        boxesR = new ArrayList<>();
        displayBoxReb();
        
        
        
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
    
    private void displayBoxPoint() {
        for (Box boxes : boxesP) {
            removeObject(boxes);
        }
        boxesP.clear();

        int x = 100; 
        int y = 200; 
        for (int number : numbersp) {
            Box boxes = new Box(number);
            addObject(boxes, x, y);
            boxesP.add(boxes);
            x += 90; 
        }
    }
    
    private void displayBoxReb() {
        for (Box boxes : boxesR) {
            removeObject(boxes);
        }
        boxesR.clear();

        int x = 100; 
        int y = 400; 
        for (int number : numbersr) {
            Box boxes = new Box(number);
            addObject(boxes, x, y);
            boxesP.add(boxes);
            x += 90; 
        }
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
    
    private void nextPointStep() {
        currentIndex++;
        if (currentIndex >= numbersp.size() - 1) {
            currentIndex = 0;
            isPointsSorted = isPointsSorted();
        }
        updatePointArrowPosition();
    }
    
    private void nextRebStep() {
        currentIndex++;
        if (currentIndex >= numbersr.size() - 1) {
            currentIndex = 0;
            isReboundsSorted = isReboundsSorted();
        }
        updateRebArrowPosition();
    }
    
    private void updatePointArrowPosition() {
        if (currentIndex < boxesP.size() - 1) {
            Box leftBoxP = boxesP.get(currentIndex);
            arrowP.pointDown(leftBoxP.getX(), leftBoxP.getY());
        }
    }
    
    private void updateRebArrowPosition() {
        if (currentIndex < boxesR.size() - 1) {
            Box leftBoxR = boxesR.get(currentIndex);
            arrowR.pointDown(leftBoxR.getX(), leftBoxR.getY());
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
    
    if (!isPointsSorted) {
        if (Greenfoot.mouseClicked(yesPointButton)) {
            if (numbersp.get(currentIndex) > numbersp.get(currentIndex + 1)) {
                Collections.swap(numbersp, currentIndex, currentIndex + 1);
                displayBoxPoint();
                nextPointStep();
            }
        } else if (Greenfoot.mouseClicked(noPointButton)) {
            if (numbersp.get(currentIndex) <= numbersp.get(currentIndex + 1)) {
                nextPointStep();
            }
        }
    }
    
    if (!isReboundsSorted) {
        if (Greenfoot.mouseClicked(yesReboundButton)) {
            if (numbersr.get(currentIndex) > numbersr.get(currentIndex + 1)) {
                Collections.swap(numbersr, currentIndex, currentIndex + 1);
                //displayPointReb();
                nextRebStep();
            }
        } else if (Greenfoot.mouseClicked(noReboundButton)) {
            if (numbersr.get(currentIndex) <= numbersr.get(currentIndex + 1)) {
                nextRebStep();
            }
        }
    }
    
    if (isPointsSorted && isReboundsSorted) {
        Greenfoot.setWorld(new Hired());
    }
    
    if (Greenfoot.isKeyDown("h")) {
        Greenfoot.setWorld(new Hired());
    }
    }
}
