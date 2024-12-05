import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Calendar;

/**
 * Write a description of class StopWatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor {
    private GreenfootImage stopwatchImage;
    private StopWatch stopWatch;
    public boolean isRunning;

    public Timer() {
        stopWatch = new StopWatch();
        Font font = new Font(true, false, 24);
        stopwatchImage = new GreenfootImage(250, 50);
        stopwatchImage.setColor(Color.BLUE);
        stopwatchImage.setFont(font);
        stopwatchImage.drawString(stopWatch.toString(), 0, 20);
        setImage(stopwatchImage);
        isRunning = false;
    }
    
    public void start() {
        stopWatch.startStop(); 
        isRunning = true;
    }
    
    private void updateDisplay() {
        stopwatchImage.clear();
        stopwatchImage.drawString(stopWatch.toString(), 0, 20);
        setImage(stopwatchImage);
    }

    public void act() {
        if (isRunning) {
            stopWatch.startStop(); 
            updateDisplay();
        }

        if (Greenfoot.isKeyDown("s")) {
            isRunning = !isRunning;
            Greenfoot.delay(10); 
        }            
    }
    
    
    public long getElapsedTimeInSeconds() {
        return stopWatch.elapsedTime() / 1000;
    }
}