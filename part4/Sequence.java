
public class Sequence extends Element
{
//******************************part 1 method*******************************   

    Sequence next;
    Element element;
     
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
    
   // The constructor: sets element & next to null.
    public Sequence()
    {
        this.element = null;
        this.next = null;
    } 
    
    
    
//******************************part 2 method**************************    

    //return the number of elements in a Sequence object
    public int length()
    {
        int count = 0;
        Sequence current = this;

        if( current == null) //no element, length = 0
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
       
        //If pos is not between 0 and the Sequence object's length, flag an error and exit.
       if(pos<0 || pos> length()) 
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



//******************************part 3 methods*****************************
    //Index method: Returns the element at the desired position.
    public Element index(int pos)
    {
        Sequence current = this;
        
        //find the element at the given position
        for( int i = 0; i< pos; i++)
        {
            current = current.next;
        }
        
        //if pos is out of bound
       if(pos<0 || pos> length()) 
            {
                System.out.printf("Position %d is out of bound.", pos);
                System.exit(1);
            }
            
        return current.element;
    }
    
    //Flatten method: Returns a flattened version of "this" sequence.
    public Sequence flatten()
    {
        Sequence flattened = new Sequence();
        Sequence current = this;
        int pos = 0;
        
        while(current.next != null)  
        {
            //check whether the element is a type of Sequence
            if(current.element instanceof Sequence) 
            {
            Sequence subSequence = ((Sequence)current.element).flatten(); //keep creating new subseq

               while(subSequence.element != null) //adding each element of subseq to the flatterned seq
               {
                   flattened.add(subSequence.element, pos); 
                   pos++;
                   subSequence = subSequence.next;
               }
            }
            else if(current.element instanceof MyChar || current.element instanceof MyInteger)
            {
                flattened.add(current.element, pos);
                pos++;
            }
            current = current.next;
        }
        return flattened;
    } 
    
    //Copy: Returns a deep copy of "this" sequence.
    public Sequence copy()
    {
        int pos = 0;
        Sequence newSequence = new Sequence();
        Sequence current = this;
        
        while (current.next != null)
        {
        //Check the type of each element, whether it is a property of Sequence,MyChar or MyInteger
            
            //Create subseq to copy this element's seq over and add to the newSequence
            if( current.element instanceof Sequence)
            {
                Sequence newSeq = ((Sequence)current.element).copy(); 

                   newSequence.add(newSeq, pos); 
                   pos++;
            }
            
            else if( current.element instanceof MyChar)
            {
                MyChar newChar = new MyChar(); //create new char
                char character = ((MyChar)current.element).Get(); //get the character at current in old sequence
                newChar.Set(character); //set that character to the new char
                newSequence.add(newChar, pos); //add that new char to new sequence
                pos++;
            }
                
            else if(current.element instanceof MyInteger)
            {
                MyInteger newInt = new MyInteger(); //create new integer
                int integer = ((MyInteger)current.element).Get(); //get the integer at current in old sequence
                newInt.Set(integer);        //set that integer to the new integer
                newSequence.add(newInt, pos);   //add that new integer to new sequence
                pos++;
            }
            
            current = current.next;    
        }
        return newSequence;
    }
    

// ******************************part 4 methods*****************************

    //returns a SequenceIterator object that points to the first element of the sequence
    public SequenceIterator begin()
    {
        SequenceIterator seq = new SequenceIterator();
        seq.seqItr = this;       //point the object itr to seq's first element

        return seq;
    }
    
    //returns a SequenceIterator object that points to a special value after the last element
    public SequenceIterator end()
    {
        SequenceIterator seq = new SequenceIterator();
        Sequence current = this;
        
        //copy the sequence to the object of seq Itr
        for( int i = 0;i < this.length(); i++)
        {
            current = current.next;
            
            if(current.next != null)
            {
                seq.seqItr = current.next;
            }
        }
        
        return seq;
    }
    
}

