import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Calendar;

/**
 * Write a description of class StopWatch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private GreenfootImage stopwatchImage;
    private StopWatch stopWatch;
    public boolean isRunning;
    public Timer()
    {
        stopWatch = new StopWatch();
        Font font = new Font(true,false,24);
        stopwatchImage = new GreenfootImage(250,50);
        stopwatchImage.setColor(Color.BLUE);
        stopwatchImage.setFont(font);
        stopwatchImage.drawString(stopWatch.toString(),0,20);
        setImage(stopwatchImage);
        isRunning = false;
    }
    
    public void start() {
        stopWatch.startStop(); // Start the timer
        isRunning = true;
    }
    
    private void updateDisplay() {
        stopwatchImage.clear();
        stopwatchImage.drawString(stopWatch.toString(), 0, 20);
        setImage(stopwatchImage);
    }
    /**
     * Act - do whatever the StopWatch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (isRunning) {
            stopWatch.startStop(); // update current time
            updateDisplay();
        }

        
        if (Greenfoot.isKeyDown("s")) {
            isRunning = !isRunning;
            Greenfoot.delay(10); // small delay 
        }            
            
            
        
    }
}