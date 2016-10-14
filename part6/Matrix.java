
class Matrix extends Sequence 
{
    private int row;
    private int col;
  
    //creating a matrix of specific number of rows and columns
    public Matrix(int rowsize, int colsize)
    { 
        this.row = rowsize;
        this.col = colsize;

        //adding numbers to the matrix at ith position
        for(int i = 0; i< rowsize*colsize ; i++)
        {
            MyInteger integer = new MyInteger();
            super.add(integer, i);
        }

    }
    
    // set the value of an element
    public void Set(int rowsize, int colsize, int value)
    {
        //Matrix[row,col] = Array[row*col_size + col]
        MyInteger integer = (MyInteger)index(rowsize*col + colsize);
        integer.Set(value);
    }

    // get the value of an element
    public int Get(int rowsize, int colsize)
    {  
        //Matrix[row,col] = Array[row*col_size + col]
        MyInteger integer = (MyInteger)index(rowsize*col + colsize);
        return integer.Get();
    }
    
    
    // return the sum of two matrices: mat & this
    public Matrix Sum(Matrix mat)
    {
        Matrix sum_matrix = new Matrix(row, col);
        int element1,element2;
        int sum = 0;
       
        if(mat.row == this.row && mat.col == this.col){ //row and col of both have to be match
            for(int i=0; i < row; i++){
                for(int j=0; j < col; j++){
                element1 = mat.Get(i,j);
                element2 = this.Get(i,j);
                sum = element1 + element2;
                sum_matrix.Set(i,j,sum);
                }
            }
        }
        else //check for error 
        {
            System.out.println("Matrix dimensions incompatible for Sum");
            System.exit(1);
        }
        return sum_matrix;
    }
    
    // return the product of two matrices: mat & this
    public Matrix Product(Matrix mat)
    {
        Matrix product_mat = new Matrix(this.row,mat.col);
        
        for(int i =0; i < product_mat.row; i++){
            for(int j = 0; j< product_mat.col; j++){
                int product =0;
                for(int k =0; k< this.col; k++)
                {
                    product += this.Get(i,k) * mat.Get(k,j); 
                }
                product_mat.Set(i,j,product);
            }
        }
        
        if(mat.row != this.col){ //error checking
            System.out.println("Matrix dimensions incompatible for Product");
            System.exit(1);
        }
        
        return product_mat;
    }
    
    
    //Print the matrix in the right form
    public void Print()
    {  
        Sequence current = this;
        if(current.next != null){
            for( int i = 0; i < row; i++){
                
                System.out.print("[ ");
                for( int j =0; j < col; j++)
                {
                    current.element.Print();
                    System.out.print(" ");
                    current = current.next;
                }
                System.out.println("]");
            }
        }
    }
}