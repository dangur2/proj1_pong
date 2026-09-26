
import java.awt.Rectangle;

public class enemyPaddle extends Paddle{
    
    public enemyPaddle(int x, int y, int WIDTH, int HEIGHT) {
        super(x, y, WIDTH, HEIGHT);
    }

    public void move(Rectangle x) {
        double difference = x.y - y;
        this.y += difference * 0.04;
        if(y < 0 ){
            this.y = 0;
        }
        if(y + HEIGHT > 800){
            this.y = 800 - HEIGHT;
        }
    }
}
