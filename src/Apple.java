import java.awt.*;
import java.util.Random;

public class Apple {
    private int appleX;
    private int appleY;
    private final Random random;
    public Apple()
    {
        random = new Random();
        changeLocation();
    }
    public void Draw(Graphics g)
    {
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, Finals.UNIT_SIZE, Finals.UNIT_SIZE);
    }

    public int getAppleX()
    {
        return this.appleX;
    }

    public int getAppleY()
    {
        return this.appleY;
    }

    public void changeLocation()
    {
        appleX = random.nextInt((int) (Finals.SCREEN_WIDTH / Finals.UNIT_SIZE)) * Finals.UNIT_SIZE;
        appleY = random.nextInt((int) (Finals.SCREEN_HEIGHT / Finals.UNIT_SIZE)) * Finals.UNIT_SIZE;

    }
}
