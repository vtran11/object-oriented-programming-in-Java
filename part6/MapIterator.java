
public class MapIterator 
{
    Map MapItr;    
    
    public MapIterator()
    {
        this.MapItr  = null;
    }
    
    //determine if two MapIterator objects point to the same Pair
    public boolean equal (MapIterator other)
    {
        if(this.MapItr.element.Key == other.MapItr.element.Key)//*****Value or Key?
            return true;
        
        else
            return false;
    }

    //to advance a MapIterator to the next Pair in a Map object
    public MapIterator advance()
    {
           this.MapItr = this.MapItr.rest(); 
           
           return this;
    }
    
    //to return the object to which the SequenceIterator object points
    public Pair get()
    {
        return this.MapItr.element;
    }
}