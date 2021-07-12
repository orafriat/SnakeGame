import javax.swing.JPanel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {


    private int applesEaten;
    private boolean running = false;
    private Timer timer;
    private final Apple apple;
    private final SnakeBody snakeBody;

    GamePanel() {

        this.setPreferredSize(new Dimension(Finals.SCREEN_WIDTH, Finals.SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.apple = new Apple();
        this.snakeBody = new SnakeBody();
        this.addKeyListener(new KeyListener(snakeBody));
        startGame();

    }

    public void startGame() {
        running = true;
        timer = new Timer(Finals.DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        if (running) {
            apple.Draw(g);
            snakeBody.Draw(g);
            g.setColor(Color.cyan);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score:" + applesEaten, (Finals.SCREEN_WIDTH - metrics.stringWidth("Score:" + applesEaten)) / 2, g.getFont().getSize());
        } else {
            gameOver(g);
        }
    }



    public void gameOver(Graphics g) {

        g.setColor(Color.cyan);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score:" + applesEaten, (Finals.SCREEN_WIDTH - metrics1.stringWidth("Score:" + applesEaten)) / 2, g.getFont().getSize());

        g.setColor(Color.cyan);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (Finals.SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, Finals.SCREEN_HEIGHT / 2);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            snakeBody.move();
            if(snakeBody.checkAppleEaten(apple))
            {
                applesEaten++;
                apple.changeLocation();
            }
            if(!snakeBody.collideWithBorders())
            {
                running = false;
                timer.stop();
            }

        }
        repaint();

    }
}

