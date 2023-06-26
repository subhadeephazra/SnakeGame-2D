import javax.swing.*;

public class SnakeGame extends JFrame
{
    GameControl control;
    SnakeGame()
    {
        control = new GameControl();
        add(control);
        setVisible(true);
        pack();
        setResizable(false);

    }
    public static void main(String args[])
    {
        SnakeGame obj = new SnakeGame();
    }
}
