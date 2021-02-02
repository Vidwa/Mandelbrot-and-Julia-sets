public class Mandelbrot extends Complex_Numbers {
    Mandelbrot()    //Default constructor
    {
        this.real=0;
        this.imag=0;
    }

    Mandelbrot(double a, double b)     //Over loaded constructor
    {
        real=a;
        imag=b;
    }

    public int  Calculate(int i,int j,int No_of_iterations,double real_left,double imag_down)
    {
        //assign z note as 0+0i
        real=0;
        imag=0;

        //Create an object for c and get the value of c
        Complex_Numbers c=new Mandelbrot(real_left+(j+0.5)*spacing[0],imag_down+(i+0.5)*spacing[1]);

        //Check the convergence of z
        return Check_Convergence(this,c,No_of_iterations);
    }
}
