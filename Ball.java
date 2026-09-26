
import java.awt.Rectangle;
import java.util.Random;

public class Ball {

    int X, Y, dX, dY, size;
    private final int gameX = 800;
    private final int gameY = 800;
    private final scoreText sT;

    public Ball(int X, int Y, int dX, int dY, int size, scoreText sT) {
        this.X = X;
        this.Y = Y;
        this.dX = dX;
        this.dY = dY;
        this.size = size;
        this.sT = sT;
    }

    public void move(Rectangle paddleBox, Rectangle enemyPaddle) {
        X += dX;
        Y += dY;

        if (getBounds().intersects(paddleBox) || getBounds().intersects(enemyPaddle)) {
            dX *= -1;

        }
        if (X + 50 > gameX) {
            resetBall();
            sT.increaseScore("p");
        }
        if (X < 0) {
            resetBall();
            sT.increaseScore("e");
        }

        if (Y + 50 > gameY || Y < 0) {
            dY *= -1;
        }
    }

    public void resetBall() {
        X = 375;
        Y = 375;
        randomDirection();
    }

    public void randomDirection() {
        Random r = new Random();
        dX = 3;
        dY = 3;
        switch (r.nextInt(0, 2)) {
            case 0 -> {
                dX *= r.nextInt(-3,-1);
            }
            case 1 -> {
                dY *= r.nextInt(-2,-1);
            }
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(X, Y, size, size);
    }
}
