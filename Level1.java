import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Collections;

/**
 * Level1 world with football jerseys displaying randomized numbers for sorting.
 */
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

    /**
     * Constructor for objects of class Level1.
     */
    public Level1() {    
        super(1000, 600, 1); 
        
        numbers = generateRandomNumbers(10, 1, 100);
        
        // Adding boss character
        boss boss1 = new boss();
        addObject(boss1, getWidth() / 2, getHeight() / 2);
        boss1.setLocation(900, 100); 
        
        // Setting up background
        GreenfootImage stadium = new GreenfootImage("football_background.png"); 
        stadium.scale(1000, 601);
        setBackground(stadium);
        
        // Adding buttons
        yesButton = new YesNoButton("Yes");
        noButton = new YesNoButton("No");
        addObject(yesButton, 400, 500);
        addObject(noButton, 600, 500);
        
        // Jersey array
        jerseys = new ArrayList<>();
        displayJerseys();
        
        // Initialize the timer
        timer = new Timer();
    }
    
    /**
     * Generate a list of random numbers.
     */
    private ArrayList<Integer> generateRandomNumbers(int count, int min, int max) {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumbers.add(Greenfoot.getRandomNumber(max - min + 1) + min);
        }
        return randomNumbers;
    }

    /**
     * Display the jerseys with the current numbers.
     */
    private void displayJerseys() {
        // Clear any existing jerseys
        for (FootballJersey jersey : jerseys) {
            removeObject(jersey);
        }
        jerseys.clear();

        // Add jerseys with updated numbers
        int x = 100; 
        int y = 200; 
        for (int number : numbers) {
            FootballJersey jersey = new FootballJersey(number);
            addObject(jersey, x, y);
            jerseys.add(jersey);
            x += 90; // Adjust spacing between jerseys
        }
    }
    
    /**
     * Check if the list is sorted.
     */
    private boolean isSorted() {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Move to the next step of the bubble sort.
     */
    private void nextStep() {
        currentIndex++;
        if (currentIndex >= numbers.size() - 1) {
            currentIndex = 0; // Reset to the first index
            isSorted = isSorted(); // Check if the numbers are sorted
        }
        displayJerseys(); // Update the jerseys
    }
    
    /**
     * Act method for user interaction and timer functionality.
     */
    public void act() {
        // Start the timer when space is pressed
        if (!timerAdded && Greenfoot.isKeyDown("space")) {
            addObject(timer, 129, 30);
            timer.start(); 
            timerAdded = true; 
        }

        // Handle sorting interaction
        if (!isSorted) {
            if (Greenfoot.mouseClicked(yesButton)) {
                // Swap only if numbers are out of order
                if (numbers.get(currentIndex) > numbers.get(currentIndex + 1)) {
                    Collections.swap(numbers, currentIndex, currentIndex + 1);
                    nextStep();
                }
            } else if (Greenfoot.mouseClicked(noButton)) {
                // Move to the next pair only if numbers are in order
                if (numbers.get(currentIndex) <= numbers.get(currentIndex + 1)) {
                    nextStep();
                }
            }
        }

        // Check if sorting is complete
        if (isSorted) {
            Greenfoot.setWorld(new Level2Intro());
        }

        // Transition to next level
        if (Greenfoot.isKeyDown("n")) {
            Greenfoot.setWorld(new Level2Intro()); 
        }
    }
}
