import java.awt.Rectangle;

public class Paddle {

    int x, y, WIDTH, HEIGHT;

    public Paddle(int x, int y, int WIDTH, int HEIGHT) {
        this.x = x;
        this.y = y;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void move(boolean wPressed, boolean sPressed){
        if(wPressed && y > 0){
            this.y -= 5;
        }
        if(sPressed && y + HEIGHT + 30 < 800){
            this.y += 5;
        }
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
