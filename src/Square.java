import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * display. It maintains information on the marker, its
 * location on the display, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;
    public static final int SQUARE_SIZE = 100;
    public static final int X_START = 100;
    public static final int Y_START = 100;
    private static final int BORDER_THICKNESS = 1;
    private Image xImage, oImage;
    private TicTacToeViewer display;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe display
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer display) {
        this.row = row;
        this.col = col;

        this.display = display;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;

        xImage = display.getxImage();
        oImage = display.getoImage();
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g)
    {

        g.setColor(Color.darkGray);
        g.drawRect(X_START+(SQUARE_SIZE*col),Y_START+(SQUARE_SIZE*row),SQUARE_SIZE,SQUARE_SIZE);

        if (isEmpty())
        {
            return;
        }
        if (isWinningSquare)
        {
            g.setColor(Color.GREEN);
            g.fillRect(X_START+(SQUARE_SIZE*col)+BORDER_THICKNESS,Y_START+(SQUARE_SIZE*row)+BORDER_THICKNESS,SQUARE_SIZE-(BORDER_THICKNESS),SQUARE_SIZE-(BORDER_THICKNESS));
        }

        if (marker.equals("X"))
        {
            g.drawImage(xImage,X_START+(SQUARE_SIZE*col),Y_START+(SQUARE_SIZE*row), SQUARE_SIZE,SQUARE_SIZE,display);
        }
        if (marker.equals("O")) {
            g.drawImage(oImage, X_START + (SQUARE_SIZE * col), Y_START + (SQUARE_SIZE * row), SQUARE_SIZE, SQUARE_SIZE, display);
        }

    }
}
