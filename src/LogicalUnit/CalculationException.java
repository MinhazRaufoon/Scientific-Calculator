package LogicalUnit;

public final class CalculationException extends Exception
{
    private String MSG;
    
    CalculationException(String S)
    {
        MSG = S;
    }
    
    public String toString()
    {
        return MSG;
    }
}
