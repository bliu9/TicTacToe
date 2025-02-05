import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private TicTacToe t;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final int TITLE_BAR_HEIGHT = 23;
    private final Image xImage, oImage;
    private final int TIE_START = 200;
    private final int WINNER_START = 150;

    public TicTacToeViewer(TicTacToe t)
    {

        xImage = new ImageIcon("Resources/X.png").getImage();
        oImage = new ImageIcon("Resources/O.png").getImage();

        this.t = t;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe :)");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);



        this.setVisible(true);
        createBufferStrategy(2);
    }

    public Image getxImage()
    {
        return xImage;
    }

    public Image getoImage()
    {
        return oImage;
    }

    public void paint(Graphics g) {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
        Graphics g2 = null;
        try {
            g2 = bf.getDrawGraphics();
            myPaint(g2);
        }
        finally {
            g2.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public void myPaint(Graphics g)
    {
        //print board numbers here
        for (int i = 0; i < 3; i ++)
        {
            g.setColor(Color.RED);
            g.drawString(String.valueOf(i),Square.X_START+(Square.SQUARE_SIZE/2)+(i*Square.SQUARE_SIZE), Square.Y_START-(Square.SQUARE_SIZE/4));
            g.drawString(String.valueOf(i),Square.X_START-(Square.SQUARE_SIZE/4), Square.Y_START+(Square.SQUARE_SIZE/2)+(i*Square.SQUARE_SIZE));
        }

        for (int i = 0; i< t.getBoard().length; i++)
        {
            for (int j = 0; j < t.getBoard()[i].length; j++)
            {
                t.getBoard()[i][j].draw(g);
            }
        }

        if (t.checkTie())
        {
            g.setFont(new Font("Serif",Font.BOLD,50));
            g.setColor(Color.BLACK);
            g.drawString("TIE",TIE_START,(4*Square.SQUARE_SIZE)+(Square.SQUARE_SIZE/2));
        }

        if (t.getGameOver())
        {
            g.setFont(new Font("Serif",Font.BOLD,50));
            g.setColor(Color.BLACK);
            g.drawString(t.getWinner()+" WINS!",WINNER_START,(4*Square.SQUARE_SIZE)+(Square.SQUARE_SIZE/2));
        }

    }
}
