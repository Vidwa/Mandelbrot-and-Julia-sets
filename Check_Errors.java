public class Check_Errors {
    //{real_left,real_right,complex_down,complex_up,no_of_iterations,real_c,complex_c,state,err}
    private double values[]={-1,1,-1,1,1000,-0.4,0.6,0,0};
    /*
        real_left,real_right     =>  real value range in the region of interest
        complex_down,complex_up  =>  imaginary value range in the region of interest
        no_of_iterations         =>  No of times that the convergence of z is checked
        real_c                   =>  real part of the complex number c
        complex_c                =>  imaginary part of the complex number c
        state                    =>  Stores whether the set is Mandelbrot (store 1) or Julia (store 2)
        err                      =>  When there is an error err becomes 1. Otherwise it is 0
     */


    Check_Errors(String[] args)     //Constructor
    {
        if (args.length >= 1)   //check whether no. of arguments>=1
        {
            try          //Exception handling when converting string to double
            {
                if (new String("Mandelbrot").equals(args[0]))       //Check whether 1st argument is Mandelbrot
                {
                    values[7] = 1;
                    switch (args.length)        //Check and store the next arguments to the array values
                    {
                        case 1:     //No arguments excluding 1st one
                            break;
                        case 5:     //4 arguments excluding 1st one
                            for (int i = 0; i < 4; i++)
                            {
                                values[i] = Double.parseDouble(args[i + 1].trim());
                            }
                            break;
                        case 6:     //5 arguments excluding 1st one
                            for (int i = 0; i < 5; i++)
                            {
                                values[i] = Double.parseDouble(args[i + 1].trim());
                            }
                            break;
                        default:    //Invalid number of arguments
                            values[8] = 1;
                            System.out.println("Incorrect number of arguments. Mandelbrot can have 0,4 or 5 arguments.");
                    }
                }
                else if (new String("Julia").equals(args[0]))   //Check whether 1st argument is Julia
                {
                    values[7] = 2;
                    switch (args.length) {
                        case 1:     //No arguments excluding 1st one
                            break;
                        case 3:     //2 arguments excluding 1st one
                            for (int i = 0; i < 2; i++)
                            {
                                values[i + 5] = Double.parseDouble(args[i + 1].trim());
                            }
                            break;
                        default:        //Invalid number of arguments
                            values[8] = 1;
                            System.out.println("Incorrect number of arguments. Julia can have 0 or 2 arguments.");
                    }
                } else {        //When 1st argument is wrong
                    values[8] = 1;
                    System.out.println("First argument should be Mandelbrot or Julia.");
                }
            }
            catch (NumberFormatException error)
            {
                System.out.println("NumberFormatException: " + error.getMessage());
                values[8]=1;
            }
        } else {        //When number of arguments are incorrect
            values[8] = 1;
            System.out.println("Incorrect number of arguments");
        }
        if ((values[0]>=values[1]) || (values[2]>=values[3]))       //Check whether region of interest is existing
        {
            values[8]=1;
            System.out.println("Incorrect range for region of interest.");
        }
    }

    public double[] Return_value()      //return the value of the array values
    {
        return values;
    }
}
