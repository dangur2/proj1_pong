public class Main {

    public static void main(String[] args) {
        CreateUI ui = new CreateUI(800, 800);
        GameEngine ge = new GameEngine(ui);
        ge.update();
    }
}
