import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Win extends JPanel{

    private final GameEngine ge;

    public Win(GameEngine ge){
        this.ge = ge;
        this.setLocation(0,250);
        this.setSize(800, 300);
        this.setLayout(null);
    }
    
    public void start(){
        JLabel winText = new JLabel("=====YOU WON=====");
        winText.setFont(new Font("Times Roman", Font.BOLD, 20));
        winText.setBounds(285, 250, 300, 100);
        createButton("Menu");

        this.add(winText);
    }
    private void createButton(String name){
        JButton button = new JButton(name);
        button.setFocusable(false);
        button.setBounds(300, 350, 200, 100);
        button.setFont(new Font("Times Roman", Font.BOLD, 20));
        button.setForeground(Color.black);
        button.setBackground(Color.white);
        button.setOpaque(true);
        if(name.equals("Menu")){
            button.addActionListener(e -> menu());
        }
        this.add(button);
    }

    private void menu() {
        ge.setCurrentState(GameState.MENU);
        ge.update();
    }
}
