import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Main extends JPanel
{
    static double values[];     //store region of interest,c,state,error
    static int width=800;       //width of the canvas
    static int height=800;      //height of the canvas
    public void paint(Graphics g)
    {
        double temp;
        BufferedImage buf=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        if (values[7]==1.0 && values[8]==0.0) {    //Whether 1st argument is Mandelbrot and there is no error
            Mandelbrot mandelbrot = new Mandelbrot();   //Create an object for mandelbrot
            mandelbrot.Find_Spacing(values[0], values[1], values[2], values[3],width,height);      //Find the spacings in the canvas

            //Fill the canvas
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    temp=mandelbrot.Calculate(i, j, (int)values[4],values[0],values[2]);
                    if(temp==values[4])
                    {
                        buf.setRGB(j,height-i-1,0X00000000);
                    }
                    else
                    {
                        buf.setRGB(j,height-i-1,Color.HSBtoRGB((float)(temp/(values[4])),0.9f,1));
                    }
                }
            }
            g.drawImage(buf,0,0,null);
        }
        else if (values[7]==2.0 && values[8]==0.0)      //Whether 1st argument is Julia and there is no error
        {
            Julia julia = new Julia();      //Create an object for julia
            julia.Find_Spacing(values[0], values[1], values[2], values[3],width,height);        //Find the spacings in the canvas

            //Fill the canvas
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    temp=julia.Calculate(i, j, (int) values[4],values[5], values[6],values[0],values[2]);
                    if(temp==values[4])
                    {
                        buf.setRGB(j,height-i-1,0X00000000);
                    }
                    else
                    {
                        buf.setRGB(j,height-i-1,Color.HSBtoRGB((float)(temp/(values[4])),0.9f,1));
                    }
                }
            }
            g.drawImage(buf,0,0,null);
        }
    }

    public static void main(String[] args)
    {
        Check_Errors num=new Check_Errors(args);    //Find the array values and check for errors
        values=num.Return_value();      //get the array values
        if (values[8]==0.0)     //Whether there are no errors
        {
            JFrame var1 = new JFrame(args[0] + " Set");     //Create a frame and set the title
            var1.getContentPane().add(new Main());
            var1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            var1.setPreferredSize(new Dimension(width, height));    //Set width and height of the window
            var1.pack();
            var1.setLocationRelativeTo(null);
            var1.setVisible(true);
        }
    }


}
