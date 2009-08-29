package hexadoku;

/**
 * Represents a partially-filled board.
 *
 * @author Sam Fredrickson <kinghajj@gmail.com>
 */
public class MaskedBoard implements Board
{
    private static boolean[][] masks = new boolean[][]
    {
        // TODO: create real masks.
        {
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,

true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,

true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,

true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,   true ,  true ,  true ,  true ,
        },
    };

    private RandomBoard board;
    private boolean[] cellVisible;

    /**
     * This class is thrown if you attempt to create a MaskedBoard with an invalid
     * board.
     */
    private class InvalidBoardException extends Exception
    {
    }

    /**
     * Creates a new mask with an arrangement specified by 'type' with the given
     * board.
     *
     * @param board the board to put the mask over.
     * @param type which type of mask to place over the board.
     * @throws hexadoku.MaskedBoard.InvalidBoardException if the board is invalid.
     */
    public MaskedBoard(RandomBoard board) throws InvalidBoardException
    {
        if(!board.isValid())
            throw new InvalidBoardException();

        this.board = board;
        this.cellVisible = new boolean[RandomBoard.NUM_CELLS];
    }

    /**
     * Gets a cell's value by index only if it is visible.
     *
     * @param index the index of the cell to use.
     * @return either the cell's value, or '\0' if the index is invalid or if
     * the cell is masked.
     */
    public char getCellValue(int index)
    {
        return cellVisible[index] ? board.getCellValue(index) : '\0';
    }

    /**
     * Tests whether the board is valid. A MaskedBoard is always valid.
     *
     * @return true.
     */
    public boolean isValid()
    {
        return true;
    }
}
