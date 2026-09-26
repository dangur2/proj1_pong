
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class scoreText extends JLabel{
    private int eScore = 0;
    private int pScore = 0;
    public scoreText(){
        this.setLocation(375, 0);
        this.setFont(new Font("Times Roman", Font.BOLD, 150));
        this.setForeground(new Color(0, 0, 0, 30));
    }
    public void increaseScore(String e){
        switch(e){
            case "e" ->
                eScore += 1;
            case "p" ->
                pScore += 1;
        }
    }
    public int getPScore(){
        return pScore;
    }
    public int getEScore(){
        return eScore;
    }
    public void updateScore(){
        this.setText(pScore+":"+eScore);
    }
}
