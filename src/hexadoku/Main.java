package hexadoku;

import java.io.PrintStream;

/**
 * The entry point to the application.
 *
 * @author Sam Fredrickson <kinghajj@gmail.com>
 */
public class Main
{
    /**
     * The entry point to the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            RandomBoard rboard = new RandomBoard();
            MaskedBoard mboard = new MaskedBoard(rboard);
            long millis = System.currentTimeMillis();
            HtmlGenerator.generate(mboard, new PrintStream("G" + millis + ".html"), mboard.getNumVisible());
            HtmlGenerator.generate(rboard, new PrintStream("K" + millis + ".html"), Board.NUM_CELLS);
            System.out.println("Finished.");
        }
        catch(Exception ex)
        {
            System.err.println("Exception!");
            System.err.println(ex.getMessage());
            System.err.println(ex);
        }
    }
}
