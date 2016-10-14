
public class Map 
{


    Map next;
    Pair element;
     
   // The constructor: sets element to dummy last Element & next to null.
        MyChar c= new MyChar('Z');
        Pair p = new Pair(c, c);
    public Map()
    {
        
        this.element = p;
        this.next = null;
        
    } 
    
     //return the first element of the sequence
    public Pair first()
    {
        return this.element;
    }
    
    //returns the rest of the elements of the seqence
    public Map rest()
    {
        return this.next;
    }
    
    //Adds a pair to its proper positon in the map such that the added pair key is
    //bigger than or equal to the previous pair in the map.
    public void add(Pair elm)
    {
            Map current = this;
            Map nw = new Map();
            
             while(current.next !=null && elm.Key.toInt() >= current.element.Key.toInt())
            {
                current = current.next;
            }
            
         
            nw.element = current.element;  //Save current.element first before overwriting current
            current.element = elm;  //set current.element to the new element
            nw.next = current.next;// connect the new sequence part to the sequence part after current
            current.next = nw; // connect current to the nw.
       
       
    }
    
    
    public MapIterator find(MyChar key)
    {
        Map current = this;
        MapIterator m = this.end();
    
        while (current.next != null )
        {
           if(current.element.Key.character == key.character )
           {
                m.MapItr = current;
                break;
           }
           current = current.next;
        }
        
        return m;
    }
    
    // Print: prints the sequence.
    public void Print()
    {
       Map current = this;
        System.out.print("[ ");
        
        //Check each element in the sequence and print them out
        while(current.next != null)
        {
            // call the object's print method
            current.element.Print();
            System.out.print(" ");
            current = current.next;
            
        }
        System.out.print("]");
    }


    //returns a SequenceIterator object that points to the first element of the sequence
    public MapIterator begin()
    {
        MapIterator map = new MapIterator();
        map.MapItr = this;   //vy    //point the object itr to seq's first element

        return map;
    }
    
    //returns a SequenceIterator object that points to a special value after the last element
    public MapIterator end()
    {
        MapIterator map = new MapIterator();
        Map current = this;

        //copy the sequence to the object of seq Itr
        for( int i = 0;i < this.length(); i++)
        {
            current = current.next;
            
            if(current != null)
            {
                map.MapItr = current;
            }
        }
        
        return map; 
    }
    
     //return the number of elements in a Sequence object
    public int length()
    {
        int count = 0;
        Map current = this;

        if( current == null) //no element, length = 0
            count = 0;
          
        while(current.next != null) //count increases when there is an element at the pos
        {
            count+=1;
            current = current.next; //move to next position
        }
        return count;    
    }
    
}

