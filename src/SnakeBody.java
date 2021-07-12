import java.awt.*;
import java.util.Random;

public class SnakeBody {

    private int bodyParts = 6;
    private char direction = 'R';
    final int x[] = new int[Finals.GAME_UNITS];
    final int y[] = new int[Finals.GAME_UNITS];
    private final Random random;

    public SnakeBody()
    {
        random = new Random();
    }

    public void Draw(Graphics g)
    {
        for (int i = 0; i < bodyParts; i++) {
            if (i == 0) {
                g.setColor(Color.green);
                g.fillRect(x[i], y[i], Finals.UNIT_SIZE, Finals.UNIT_SIZE);
            } else {
                g.setColor(new Color(45, 180, 0));
                g.fillRect(x[i], y[i], Finals.UNIT_SIZE, Finals.UNIT_SIZE);
            }
        }
    }

    public boolean checkAppleEaten(Apple apple)
    {
        if ((x[0] == apple.getAppleX()) && (y[0] == apple.getAppleY())) {
            bodyParts++;
            return true;
        }
        return false;
    }

    public boolean collideWithBorders()
    {

        for (int i = bodyParts; i > 0; i--) {
            if ((x[0]) == x[i] && (y[0] == y[i])) {
                return false;
            }
        }

        if (x[0] < 0) {
            return false;
        }

        if (x[0] > Finals.SCREEN_WIDTH) {
            return false;
        }


        if (y[0] < 0) {
            return false;
        }

        if (y[0] > Finals.SCREEN_HEIGHT) {
            return false;
        }

        return true;

    }

    public void setDirection(char direction){
        this.direction = direction;
    }

    public void move()
    {
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - Finals.UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + Finals.UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - Finals.UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + Finals.UNIT_SIZE;
                break;
        }
    }
}
