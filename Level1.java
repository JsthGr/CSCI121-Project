import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.*;  
import java.util.ArrayList;
import java.util.Collections;

public class Level1 extends World {
    private boolean timerAdded = false;
    private Timer timer;
    private ArrayList<Integer> numbers; 
    private int currentIndex = 0; 
    private boolean isSorted = false; 
    private GreenfootImage display; 
    private YesNoButton yesButton;
    private YesNoButton noButton;
    private ArrayList<FootballJersey> jerseys; 
    private Arrow arrow; 
    private final int TIME_LIMIT = 60;
    public Level1() {    
        super(1000, 600, 1); 
        
        numbers = generateRandomNumbers(10, 1, 100);
        
        boss boss1 = new boss();
        addObject(boss1, getWidth() / 2, getHeight() / 2);
        boss1.setLocation(900, 100); 
        
        GreenfootImage stadium = new GreenfootImage("football_background.png"); 
        stadium.scale(1000, 601);
        setBackground(stadium);
        
        yesButton = new YesNoButton("Yes");
        noButton = new YesNoButton("No");
        addObject(yesButton, 400, 500);
        addObject(noButton, 600, 500);
        
        jerseys = new ArrayList<>();
        displayJerseys();
        
        timer = new Timer();

        arrow = new Arrow();
        addObject(arrow, 0, 0); // Add the arrow but place it off-screen initially
        updateArrowPosition();
        
        showText("Press SPACE to Start", getWidth()/2 , getHeight()/2  + 80);
    }
    
    private ArrayList<Integer> generateRandomNumbers(int count, int min, int max) {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumbers.add(Greenfoot.getRandomNumber(max - min + 1) + min);
        }
        return randomNumbers;
    }

    private void displayJerseys() {
        for (FootballJersey jersey : jerseys) {
            removeObject(jersey);
        }
        jerseys.clear();

        int x = 100; 
        int y = 200; 
        for (int number : numbers) {
            FootballJersey jersey = new FootballJersey(number);
            addObject(jersey, x, y);
            jerseys.add(jersey);
            x += 90; 
        }
    }

    private boolean isSorted() {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void nextStep() {
        currentIndex++;
        if (currentIndex >= numbers.size() - 1) {
            currentIndex = 0;
            isSorted = isSorted();
        }
        displayJerseys();
        updateArrowPosition();
    }

    private void updateArrowPosition() {
        if (currentIndex < jerseys.size() - 1) {
            FootballJersey leftJersey = jerseys.get(currentIndex);
            arrow.pointTo(leftJersey.getX(), leftJersey.getY());
        }
    }

    public void act() {
    if (!timerAdded && Greenfoot.isKeyDown("space")) {
        addObject(timer, 129, 30);
        timer.start(); 
        timerAdded = true; 
    }

    // Check if the time limit has been exceeded
    if (timerAdded && timer.getElapsedTimeInSeconds() > TIME_LIMIT) {
        Greenfoot.setWorld(new Failed()); // Transition to the Failed screen
    }

    if (!isSorted) {
        if (Greenfoot.mouseClicked(yesButton)) {
            if (numbers.get(currentIndex) > numbers.get(currentIndex + 1)) {
                Collections.swap(numbers, currentIndex, currentIndex + 1);
                nextStep();
            }
        } else if (Greenfoot.mouseClicked(noButton)) {
            if (numbers.get(currentIndex) <= numbers.get(currentIndex + 1)) {
                nextStep();
            }
        }
    }

    if (isSorted) {
        Greenfoot.setWorld(new Level2Intro());
    }

    if (Greenfoot.isKeyDown("n")) {
        Greenfoot.setWorld(new Level2Intro()); 
    }
    }
}
