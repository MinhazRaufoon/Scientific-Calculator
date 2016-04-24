package LogicalUnit;

interface UserInterface
{
    void CheckError() throws CalculationException;
    void Solve();
    void TakeInput(String S);
    String TakeOutput();
}