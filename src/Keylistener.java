import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyListener extends KeyAdapter {
    char direction = 'R';
    SnakeBody snakeBody;
    public KeyListener(SnakeBody snakeBody)
    {
        this.snakeBody = snakeBody;
    }
    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                if (direction != 'R') {
                    direction = 'L';
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (direction != 'L') {
                    direction = 'R';
                }
                break;
            case KeyEvent.VK_DOWN:
                if (direction != 'U') {
                    direction = 'D';
                }
                break;
            case KeyEvent.VK_UP:
                if (direction != 'D') {
                    direction = 'U';
                }
                break;
        }
        this.snakeBody.setDirection(direction);
    }

}