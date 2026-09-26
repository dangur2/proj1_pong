import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu  extends JPanel{

    private final GameEngine ge;

    public MainMenu(GameEngine ge){
        this.ge = ge;
        this.setLocation(0,250);
        this.setSize(800, 300);
        this.setLayout(new GridBagLayout());
    }
    
    public void start(){
        createButton("play");
        createButton("exit");
    }

    private void createButton(String name){
        JButton button = new JButton(name);
        button.setFocusable(false);
        button.setPreferredSize(new Dimension(250,125));
        button.setFont(new Font("Times Roman", Font.BOLD, 20));
        button.setForeground(Color.black);
        button.setBackground(Color.white);
        button.setOpaque(true);
        if(name.equals("play")){
            button.addActionListener(e -> play());
        } else if (name.equals("exit")){
            button.addActionListener(e -> exit());
        }
        this.add(button);
    }

    private void play() {
        ge.setCurrentState(GameState.PLAYING);
        ge.update();
    }
    private void exit() {
        System.exit(1);
    }
}
