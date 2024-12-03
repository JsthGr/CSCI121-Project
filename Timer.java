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
        stopWatch.startStop();
    }

    public void stopped(){
        stopWatch.startStop();
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
        stopWatch.startStop();
        if(Greenfoot.isKeyDown("a")) {
            
        }
        
        if (Greenfoot.isKeyDown("s")) {
            if (!isRunning) {
                stopWatch.startStop();
                isRunning = true;
            } else {
                stopWatch.startStop();
                isRunning = false;
            }
            Greenfoot.delay(10); // Small delay to avoid multiple triggers
        }

        // Update the display continuously if the timer is running
        if (isRunning) {
            stopWatch.startStop(); // Update the current time
            updateDisplay();
        }
            /**
            if(Greenfoot.isKeyDown("enter")){
                
                while(stopWatch.elapsedTime()<100000000){ 
                    stopWatch.startStop();
                    stopwatchImage.clear();
                    stopwatchImage.drawString(stopWatch.toString(), 0, 20);
                    setImage(stopwatchImage); 
            }
            }
            **/
            
            
            
        
    }
}