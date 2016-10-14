
public class SequenceIterator 
{
    Sequence seqItr;    
    
    public SequenceIterator()
    {
        this.seqItr  = null;
    }
    
    //determine if two SequenceIterator objects point to the same element
    public boolean equal (SequenceIterator other)
    {
        if(this.seqItr.element == other.seqItr.element)
            return true;
        
        else
            return false;
    }

    //to advance a SequenceIterator to the next element in a Sequence object
    public SequenceIterator advance()
    {
           this.seqItr = this.seqItr.rest(); 
           
           return this;
    }
    
    //to return the object to which the SequenceIterator object points
    public Element get()
    {
        return this.seqItr.element;
    }
}