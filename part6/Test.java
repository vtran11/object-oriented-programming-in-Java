public class Test
{
    public static void main(String[] args)
    {
        
        /************Test class Pair******************
        MyChar key = new MyChar('3');
        MyChar value = new MyChar('4');
        Pair p = new Pair(key, value);
        p.Print();
        
        //*************Test class Map**************************/
        
        MyChar c1 = new MyChar('0');
        MyChar c2 = new MyChar('3');
        MyChar c3 = new MyChar('2');
        MyChar c4 = new MyChar('3');
        
        Pair p1 = new Pair(c1, c1);
        Pair p2 = new Pair(c2, c2);
        Pair p3 = new Pair(c3, c3);
        Pair p4 = new Pair(c4, c1);
        Map m1 = new Map();
        m1.add(p1);
        m1.add(p2);
        m1.add(p3);
        m1.add(p4);
        m1.Print();
        
        
       /* MapIterator m2= m1.begin();
        m2.MapItr.first().Print();
        m2.advance();
        m2.MapItr.first().Print();
        m2.advance();
        m2.MapItr.first().Print();
        m2 = m1.end();
        m2.MapItr.first().Print();
        
        
        
        
        
        m2 = m1.find(c3);
        Pair k = m2.get();
       // k.Print();*/
       MapIterator it1, it2;
       for (it1 = m1.begin(); !it1.equal(m1.end()); it1.advance()) {
	   for (it2 = m1.begin(); !it2.equal(m1.end()); it2.advance()) {
		p1 = it1.get();
		p2 = it2.get();
		p1.Print();	
		System.out.print(" X ");
		p2.Print();
		System.out.println();
	   }}
    }
}