
public class MyChar extends Element
{
    char character;
    
    public MyChar()
    {
       character = 0; 
    }
    
    public MyChar(char val)
    {
        character = val;
    }
    
    public char Get()
    {
        return character;
    }
    
    public void Set(char val)
    {
        character = val;
    }
    
    public void Print()
    {
        System.out.print("'" + character + "'");
    }
    
    public int toInt()
    {
        int charToInt = (int)character;
        return charToInt;
    }
}