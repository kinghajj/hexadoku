package hexadoku;

/**
 * Represents the interface to all Hexadoku boards.
 *
 * @author Sam Fredrickson <kinghajj@gmail.com>
 */
public interface Board
{
    public char getCellValue(int index);
    public boolean isValid();
}
