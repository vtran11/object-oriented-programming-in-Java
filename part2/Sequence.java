
public class Sequence
{
//****************************Part 1**********************************
    private Sequence next = null;   //next is a pointer to the next element in the sequence.
    private Element element;        //the current sequence element content.
    
    //return the first element of the sequence
    public Element first()
    {
        return this.element;
    }
    
    //returns the rest of the elements of the seqence
    public Sequence rest()
    {
        return this.next;
    }
  
//****************************Part 2**********************************  
    //return the number of elements in a Sequence object
    public int length()
    {
        int count = 0;
        Sequence current = this;

        if( current == null) //no element, length = 0.
            count = 0;

        while(current.next != null) //count increases when there is an element at the pos
        {
            count+=1;
            current = current.next; //move to next position
        }
        return count;    
    }
    
    //method add to add an element at a specified position
    //follow the hints in discussion slides
    public void add(Element elm, int pos)
    {
            Sequence current = this;
            Sequence nw = new Sequence();
            
            for (int i = 0; i< pos; i++)
            {
                current = current.next;
            }
         
            nw.element = current.element;  //Save current.element first before overwriting current
            current.element = elm;  //set current.element to the new element
            nw.next = current.next;// connect the new sequence part to the sequence part after current
            current.next = nw; // connect current to the nw.

        //If pos is not between 0 and the length of the Sequence object,
        //flag an error and exit.
       if(pos<0 || pos> this.length()) 
            {
                System.out.printf("Position %d is out of bound.", pos);
                System.exit(1);
            }
    }
    
    //delete method to remove an element at a specified position
    //After deleting the element at pos, all elements to the right 
    //of pos are pushed to the left. 
    public void delete(int pos)
    {
        Sequence current = this;
        
        for( int i = 0; i< pos; i++)
        {
            current = current.next;
        }

        current.element = current.next.element;
        current.next = current.next.next;
        
        //if pos is out of bound
       if(pos<0 || pos> length()) 
            {
                System.out.printf("Position %d is out of bound.", pos);
            }
    }
    
    // Print: prints the sequence.
    public void Print()
    {
        Sequence current = this;
        System.out.print("[ ");
        
        //Check each element in the sequence and print them out
        while(current.element != null)
        {
            // call the object's print method
            current.element.Print();
            System.out.print(" ");
            current = current.next;
            
        }
        System.out.print("]");
    }
}

