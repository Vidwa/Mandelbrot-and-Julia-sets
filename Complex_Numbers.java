public abstract class Complex_Numbers
{
    protected double real;
    protected double imag;
    protected double spacing[]={0,0};

    Complex_Numbers()   //default constructor
    {
        this.real=0;
        this.imag=0;
    }

    Complex_Numbers(double real,double imag)    //over loaded constructor
    {
        this.real=real;
        this.imag=imag;
    }

    //Find the correct complex number in the canvas
    public void Find_Spacing(double real_left,double real_right,double imag_down,double imag_up,int width,int height )
    {
        spacing[0]=(real_right-real_left)/(width);
        spacing[1]=(imag_up-imag_down)/(height);
    }

    private void Find_Next_Term(Complex_Numbers c)      //Compute the next z
    {
        double temp1,temp2;
        temp1=real*real-imag*imag+c.real;
        temp2=2*real*imag+c.imag;
        real=temp1;
        imag=temp2;
    }

    private double Magnitude()      //Get the magnitude of the complex number. (Here its square is returned)
    {
        return real*real+imag*imag;
    }

    protected int Check_Convergence(Complex_Numbers z,Complex_Numbers c,int no_of_iterations)   //Check the convergence of z
    {
        for (int k=0;k<no_of_iterations;k++)
        {
            z.Find_Next_Term(c);        //Compute the next z
            if(z.Magnitude()>4.0)
            {
                return k;
            }
        }
        return no_of_iterations;
    }
}
