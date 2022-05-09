package Client;

public class CouldNotCreateOrderException extends Exception
{
    public CouldNotCreateOrderException(String message)
    {
        super(message);
    }
}
