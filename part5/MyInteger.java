
class MyInteger extends Element
{
    private int integer;
    
    public MyInteger() 
    { 
        integer = 0;
    }
    
    public MyInteger(int value)
    {
        integer = value;
    }
    
    public int Get() 
    { 
        return integer;
    }

    public void Set(int val) 
    { 
        integer = val;
    }

    public void Print()
    {
        System.out.print(integer);
    }
}
