
import javax.swing.Timer;

public class GameEngine {

    private GameState currentState;
    private final int timerDelay = 16;
    private Timer timer;
    private final CreateUI ui;
    private final MainMenu menu;
    private final Playing playing;
    private final Lose lose;
    private final Win win;

    public GameEngine(CreateUI ui) {
        this.ui = ui;
        this.currentState = GameState.MENU;
        this.menu = new MainMenu(this);
        this.playing = new Playing(this);
        this.lose = new Lose(this);
        this.win = new Win(this);
    }

    public void setCurrentState(GameState newState) {
        this.currentState = newState;
    }

    public void stopTimer(){
        timer.stop();
    }

    public void update() {
        
        switch (currentState) {
            case MENU -> {

                menu.start();
                ui.setContentPane(menu);
                ui.repaint();
                ui.revalidate();
            }
            case PLAYING -> {
                Playing play = new Playing(this);
                ui.setContentPane(play);
                play.requestFocus();
                ui.repaint();
                ui.revalidate();

                timer = new Timer(timerDelay, ActionListener -> {
                    play.tick();
                });
                timer.start();
                
            }
            case WIN -> {

                win.start();
                ui.setContentPane(win);
                ui.repaint();
                ui.revalidate();
            }
            case LOSE -> {

                lose.start();
                ui.setContentPane(lose);
                ui.repaint();
                ui.revalidate();
            }
        }
    }
}
