import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameControl extends JPanel implements ActionListener
{
    int HEIGHT =400;
    int WIDTH =400;
    int MAX_DOTS=1600;
    int DOT_SIZE=10;
    int DOTS; //SIZE OF THE SNAKE
    int[] x =new int[MAX_DOTS];
    int[] y =new int[MAX_DOTS];

    int apple_x, apple_y;

    Image head, body, apple;
    Timer timer;
    int DELAY = 150;
    boolean leftdirection=true;
    boolean rightdirection=false;
    boolean updirection=false;
    boolean downdirection=false;
    boolean ingame=true;


   GameControl()
   {

        TAdapter tAdapter=new TAdapter();
        addKeyListener(tAdapter);
        setFocusable(true);
        setPreferredSize(new Dimension(HEIGHT,WIDTH));
        setBackground(Color.BLACK);
        initGame();
        LoadImage();

   }

   //INITIALISING GAME OBJECTS POSITION
    private void initGame()
    {
        //INITIALISING APPLE POSITION
        DOTS=3;
        x[0]=150;
        y[0]=150;
        for(int i=1;i<DOTS;i++)
        {
            x[i]=x[0]+DOT_SIZE*i;
            y[i]=y[0];
        }
        //INITIALISING APPLE POSITION
        LocateApple();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    //INITIALISE LOADING IMAGES
    private void LoadImage()
    {
        ImageIcon headIcon = new ImageIcon("src/resources/head.png");
        head = headIcon.getImage();
        ImageIcon bodyIcon = new ImageIcon("src/resources/body.png");
        body = bodyIcon.getImage();
        ImageIcon appleIcon = new ImageIcon("src/resources/apple.png");
        apple = appleIcon.getImage();
    }

    //Drawing images from resources folder
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        DoDrawing(g);
    }

    public void DoDrawing(Graphics g)
    {
        if(ingame) {
            g.drawImage(apple, apple_x, apple_y, this);

            for (int i = 0; i < DOTS; i++)
            {
                if (i == 0)
                {
                    g.drawImage(head, x[0], y[0], this);
                } else
                {
                    g.drawImage(body, x[i], y[i], this);
                }
            }
        }
        else
        {
            gameover(g);
            timer.stop();
        }

    }

    //RANDOMISING THE APPLE POSITION
    public void LocateApple()
    {
        apple_x=((int)(Math.random()*39))*DOT_SIZE;
        apple_y=((int)(Math.random()*39))*DOT_SIZE;
    }
    //CHECK COLLISION //refer line no.145
    public void checkCollision()
    {
        for (int i = 1; i <DOTS ; i++) {
            if(i>4 && x[0]==x[i] && y[0]==y[i]){
                ingame=false;
            }
        }
        if(x[0]<0){
            ingame=false;
        }
        if(y[0]<0){
            ingame=false;
        }
        if(x[0]>=HEIGHT){
            ingame=false;
        }
        if(y[0]>=WIDTH){
            ingame=false;
        }
    }

    //GAMEOVER
    public void gameover(Graphics g)
    {
        String msg="GAME OVER";
        int score=(DOTS-3)*100;
        String scoreMsg="Score: "+Integer.toString(score);
        Font small=new Font("Helvetica",Font.BOLD,14);
        FontMetrics fontMetrics=getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg,(WIDTH-fontMetrics.stringWidth(msg))/2,HEIGHT/4);
        g.drawString(scoreMsg,(WIDTH-fontMetrics.stringWidth(scoreMsg))/2,3*(HEIGHT/4));
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (ingame)
        {
            checkCollision(); //refer line no.106
            checkapple();    //refer line no.181
            move();          //refer line no.154

        }
        repaint();
    }

    //MOVE SNAKE //refer line no.148
    public void move()
        {
            for (int i = DOTS - 1; i >= 1; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            if (leftdirection)
            {
                x[0] -= DOT_SIZE;
            }
            if(rightdirection)
            {
                x[0]+=DOT_SIZE;
            }
            if(updirection)
            {
                y[0]-=DOT_SIZE;
            }
            if(downdirection)
            {
                y[0]+=DOT_SIZE;
            }
        }


    //refer line no.147
    public void checkapple()
        {
            if(apple_x==x[0] && apple_y==y[0]){
                DOTS++;
                LocateApple();
            }
        }

    private class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent keyEvent){
            int key=keyEvent.getKeyCode();
            if(key==keyEvent.VK_LEFT && !rightdirection){
                leftdirection=true;
                updirection=false;
                downdirection=false;
            }
            if(key==keyEvent.VK_RIGHT && !leftdirection){
                rightdirection=true;
                updirection=false;
                downdirection=false;
            }
            if(key==keyEvent.VK_UP && !downdirection){
                leftdirection=false;
                updirection=true;
                rightdirection=false;
            }
            if(key==keyEvent.VK_DOWN && !updirection){
                leftdirection=false;
                rightdirection=false;
                downdirection=true;

           }
       }
   }

}

