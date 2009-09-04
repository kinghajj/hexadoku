package hexadoku;

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
            System.out.println(new MaskedBoard(new RandomBoard()));
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
