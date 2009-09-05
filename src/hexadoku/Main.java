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
            HtmlGenerator.generate(mboard, new PrintStream("output.html"));
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
