
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class Playing extends JPanel{
    private final scoreText sT = new scoreText();
    private final Ball ball = new Ball(375, 375, 5, 5, 50, sT);
    private final Paddle paddle = new Paddle(50,340, 20, 150);
    private final enemyPaddle enemyPaddle = new enemyPaddle(720,340, 20, 150);
    private boolean wPressed, sPressed;
    private final GameEngine ge;

    public Playing(GameEngine ge){
        this.ge = ge;
        this.add(sT);
        this.addKeyListener(new KeyAdapter() {
            @Override 
            public void keyPressed(KeyEvent e){
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> wPressed = true;
                    case KeyEvent.VK_S -> sPressed = true;
                }
            }
            @Override 
            public void keyReleased(KeyEvent e){
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W -> wPressed = false;
                    case KeyEvent.VK_S -> sPressed = false;
                }
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(ball.X,ball.Y,ball.size,ball.size);
        g.setColor(Color.black);
        g.fillRect(paddle.x, paddle.y, paddle.WIDTH, paddle.HEIGHT);
        g.setColor(Color.black);
        g.fillRect(enemyPaddle.x, enemyPaddle.y, enemyPaddle.WIDTH, enemyPaddle.HEIGHT);
    }
    public void tick(){
            ball.move(paddle.getBounds(), enemyPaddle.getBounds());
            paddle.move(wPressed, sPressed);
            enemyPaddle.move(ball.getBounds());
            sT.updateScore();
            checkWinner();
            repaint();
    }

    private void checkWinner() {
        if(sT.getEScore() >= 5){
            ge.stopTimer();
            ge.setCurrentState(GameState.LOSE);
            ge.update();
        }
        if(sT.getPScore() >= 5){
            ge.stopTimer();
            ge.setCurrentState(GameState.WIN);
            ge.update();
        }
    }
}
