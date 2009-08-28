package hexadoku;

/**
 * Represents a partially-filled board.
 *
 * @author Sam Fredrickson <kinghajj@gmail.com>
 */
public class Mask
{
    private Board board;
    private Type type;
    private boolean[] cellVisible;

    /**
     * This class is thrown if you attempt to create a Mask with an invalid
     * board.
     */
    private class InvalidBoardException extends Exception
    {
    }

    public enum Type
    {
        ONE,
        TWO,
        THREE,
    }

    /**
     * Creates a new mask with an arrangement specified by 'type' with the given
     * board.
     *
     * @param board the board to put the mask over.
     * @param type which type of mask to place over the board.
     * @throws hexadoku.Mask.InvalidBoardException if the board is invalid.
     */
    public Mask(Board board, Type type) throws InvalidBoardException
    {
        if(!board.isValid())
            throw new InvalidBoardException();

        this.board = board;
        this.type = type;
        this.cellVisible = new boolean[Board.NUM_CELLS];
    }
}
