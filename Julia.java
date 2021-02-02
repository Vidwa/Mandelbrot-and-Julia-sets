public class Julia extends Complex_Numbers
{
    Julia()     //Default constructor
    {
        this.real=0;
        this.imag=0;
    }

    Julia(double real, double imag)       //Over loaded Constructor
    {
        this.real=real;
        this.imag=imag;
    }

    public int  Calculate(int row,int col,int No_of_iterations,double real_c,double imag_c,double real_left,double imag_down)
    {
        //compute the value of z note
        real=real_left+(col+0.5)*spacing[0];
        imag=imag_down+(row+0.5)*spacing[1];

        Julia c=new Julia(real_c,imag_c);   //Create an object for c and initialise it

        //Check for the convergence of z
        return Check_Convergence(this,c,No_of_iterations);
    }
}
