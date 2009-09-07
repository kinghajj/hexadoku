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

    /**
     * An interface for an object than finds the cell index of the given zone
     * and sub-cell indexes.
     */
    public static interface CellFinder
    {
        int findCell(int i, int rcs);
    }

    // A cell-finder for rows.
    public static final CellFinder ROW_FINDER = new CellFinder()
    {
        public int findCell(int i, int row)
        {
            return row * NUM_DIGITS + i;
        }
    };

    // A cell-finder for columns.
    public static final CellFinder COLUMN_FINDER = new CellFinder()
    {
        public int findCell(int i, int col)
        {
            return NUM_DIGITS * i + col;
        }
    };

    // A cell-finder for squares.
    public static final CellFinder SQUARE_FINDER = new CellFinder()
    {
        public int findCell(int i, int sqr)
        {
            /*
            final int sqr_x = sqr % NUM_SQRS;
            final int sqr_y = sqr / NUM_SQRS;
            final int dig_x = i % NUM_SQRS;
            final int dig_y = i / NUM_SQRS;
            final int x = sqr_x * NUM_SQRS + dig_x;
            final int y = sqr_y * NUM_SQRS + dig_y;
            final int index = y * NUM_DIGITS + x;
            return index;
             */

            return ((sqr / NUM_SQRS) * NUM_SQRS + (i / NUM_SQRS)) * NUM_DIGITS +
                    ((sqr % NUM_SQRS) * NUM_SQRS + (i % NUM_SQRS));
        }
    };

    /**
     * Converts a digit from a character to an integer.
     *
     * @param c a character that represents a valid digit.
     * @return the integer form of the digit, or -1 if invalid.
     */
    public static int digitCharToInt(char c)
    {
        if(c >= '0' && c <= '9')
            return (int)c - (int)'0';
        if(c >= 'A' && c <= 'F')
            return (int)c - (int)'A' + 10;

        return -1;
    }

    /**
     * Converts an integer to a character digit.
     *
     * @param i to integer that represents a valid digit.
     * @return the character form of the digit, or '\0' if invalid.
     */
    public static char intToDigitChar(int i)
    {
        if(i >= 0 && i <= 9)
            return (char)(i + (int)'0');
        if(i >= 10 && i <= 15)
            return (char)(i - 10 + (int)'A');

        return '\0';
    }

    public abstract char getCellValue(int index);
    public abstract boolean isValid();
}
