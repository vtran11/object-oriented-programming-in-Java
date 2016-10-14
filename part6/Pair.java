public class Pair extends Element
{
     MyChar Key;
     Element Value;
    
    public Pair(MyChar key, Element value)
    {
        Key = key;
        Value = value;
    }
    
    public void Print()
    {
        System.out.print("(");
        Key.Print(); System.out.print(" "); Value.Print();
        System.out.print(")");
    }
    
}