
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lose extends JPanel {

    private final GameEngine ge;

    public Lose(GameEngine ge) {
        this.ge = ge;
        this.setLocation(0, 250);
        this.setSize(800, 300);
        this.setLayout(null);
    }

    public void start() {
        JLabel loseText = new JLabel("=====YOU LOST=====");
        loseText.setFont(new Font("Times Roman", Font.BOLD, 20));
        loseText.setBounds(285, 250, 300, 100);

        this.add(loseText);
        createButton("Menu");
    }

    private void createButton(String name) {
        JButton button = new JButton(name);
        button.setFocusable(false);
        button.setBounds(300, 350, 200, 100);
        button.setFont(new Font("Times Roman", Font.BOLD, 20));
        button.setForeground(Color.black);
        button.setBackground(Color.white);
        button.setOpaque(true);
        if (name.equals("Menu")) {
            button.addActionListener(e -> menu());
        }
        this.add(button);
    }

    private void menu() {
        ge.setCurrentState(GameState.MENU);
        ge.update();
    }
}
