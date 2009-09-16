package hexadoku;

import java.util.Arrays;

/**
 * Contains various methods for determining whether a mboard can be solved.
 *
 * @author Sam Fredrickson <kinghajj@gmail.com>
 */
public class Solver
{
    private static void eliminateByFinder(MaskedBoard board, int rcs, boolean[] seen, Board.CellFinder finder)
    {
        int i, j;

        for(i = 0; i < Board.NUM_DIGITS; ++i)
        {
            // Get the int form of the ith digit with the finder.
            // Skip if invalid.
            if((j = Board.digitCharToInt(board.getCellValue(finder.findCell(i, rcs)))) == -1)
                continue;

            seen[j] = true;
        }
    }

    private static void eliminatePossibilities(MaskedBoard board, int i, boolean[] seen)
    {
        // Calculate the column, row, and square for the given index.
        int col = i % Board.NUM_DIGITS,
            row = i / Board.NUM_DIGITS,
            sqr = (row / 4) * 4 + col / 4;

        // Eliminate possibilities by examining the column, row, and square.
        eliminateByFinder(board, col, seen, Board.COLUMN_FINDER);
        eliminateByFinder(board, row, seen, Board.ROW_FINDER);
        eliminateByFinder(board, sqr, seen, Board.SQUARE_FINDER);
    }

    /**
     * Determines whether the given mboard can be easily solved.
     * @param mboard the mboard to attempt to solve.
     * @return true if the mboard can be easily solved, else false.
     */
    public static boolean canEasilySolve(MaskedBoard mboard)
    {
        boolean changed;
        boolean[] seen = new boolean[Board.NUM_DIGITS];
        int i;

        if(mboard == null)
            return false;

        do
        {
            changed = false;

            // Pass through all the cells.
            for(i = 0; i < Board.NUM_CELLS; ++i)
            {
                // Skip this cell if it's visible.
                if(mboard.getCellValue(i) != '\0')
                    continue;

                // Assume that everything's possible.
                Arrays.fill(seen, false);

                // eliminate the possibilities
                eliminatePossibilities(mboard, i, seen);

                // Find out how many possibilities were unseen, and remember
                // the last found possibility.
                int unseenCount = 0, unseenIndex = 0;
                for(int j = 0; j < seen.length; ++j)
                    if(!seen[j])
                    {
                        if(++unseenCount > 1)
                            break;
                        unseenIndex = j;
                    }

                // Only one possibility! We've found it!
                if(changed = unseenCount == 1)
                    // Reveal the correct answer and mark the board as changed.
                    mboard.reveal(i, Board.intToDigitChar(unseenIndex));
            }
            // If the last pass changed the mboard, do another pass to see if any
            // more cells can be deduced.
        } while(changed);

        // Now see if there are still any more invisible cells. If there are,
        // then we were unsuccessful in trying to easily solve the mboard.
        for(i = 0; i < Board.NUM_CELLS; ++i)
            if(mboard.getCellValue(i) == '\0')
                return false;

        // Otherwise, we've revealed all cells, so it worked!
        return true;
    }
}
