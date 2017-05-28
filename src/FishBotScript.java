import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FishBotScript extends Thread
{
    private Thread thread;
    private Robot fishBot;
    private boolean waiting;
    private int casts;
    private int repeats;
    private int seconds;

    FishBotScript(boolean waiting, int casts, int repeats, int seconds)
    {
        try {
            fishBot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        this.waiting = waiting;
        this.casts = casts;
        this.repeats = repeats;
        this.seconds = seconds;
    }

    public void start ()
    {
        if (thread == null)
        {
            thread = new Thread (this);
            thread.start();
        }
    }

    public void run()
    {
        fishBot.delay(seconds * 1000);
        Point p = MouseInfo.getPointerInfo().getLocation();
        Color blockColor = fishBot.getPixelColor(p.x - 2, p.y - 2);
        fishBot.setAutoDelay(50);
        fishBot.setAutoWaitForIdle(true);
        macro(fishBot, p, casts, repeats, waiting, blockColor);
    }

    private static void click(Robot robot, int button)
    {
        robot.mousePress(InputEvent.getMaskForButton(button));
        robot.mouseRelease(InputEvent.getMaskForButton(button));
    }

    private static void pressEscape(Robot robot)
    {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    private static void macro(Robot robot, Point p, int casts, int repeats, boolean waiting, Color blockColor)
    {
        boolean keepGoing = waiting || repeats > 1;
        for (int i = 0; i < casts; i++)
        {
            click(robot, 3);
            robot.mouseMove(p.x, p.y + 69);
            click(robot, 3);
            pressEscape(robot);
            robot.delay(100);
            pressEscape(robot);
            robot.mouseMove(p.x, p.y);
            if (!robot.getPixelColor(p.x - 2, p.y - 2).equals(blockColor))
            {
                keepGoing = false;
                break;
            }
        }
        pressEscape(robot);
        robot.delay(1500);
        click(robot, 1);
        robot.delay(500);
        pressEscape(robot);

        if (keepGoing)
            macro(robot, p, casts, repeats-1, waiting, blockColor);

    }
}
