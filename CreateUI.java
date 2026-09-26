import javax.swing.JFrame;

public class CreateUI extends JFrame{

    private final int sizeX;
    private final int sizeY;
    
    public CreateUI(int sizeX, int sizeY){
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.setSize(sizeX, sizeY);
        this.setDefaultCloseOperation(1);
        this.setResizable(false);
        this.setVisible(true);
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
}
