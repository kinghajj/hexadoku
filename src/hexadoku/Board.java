package hexadoku;

/**
 * Represents the abstract interface to all Hexadoku boards.
 *
 * @author Sam Fredrickson <kinghajj@gmail.com>
 */
public abstract class Board
{
    // The number of cells on the board.
    public static final int NUM_CELLS = 256;
    // The number of possible digits.
    public static final int NUM_DIGITS = 16;
    // The number of rows and columns of square zones.
    public static final int NUM_SQRS = (int)Math.sqrt(NUM_DIGITS);

    public abstract char getCellValue(int index);
    public abstract boolean isValid();
}
