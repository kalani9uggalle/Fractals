/**e/16/290**/


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.*;

//inherits JPanel 
@SuppressWarnings("serial")
public class Fractal extends JPanel{ 

	private boolean bound;
	private final int WIDTH=800;
	private final int HEIGHT=800;
    private char fractal;
	Mandelbrot mb  = null;
	Julia      ju  = null;

	
	//select content panel
	public Fractal(char select)
	{   
		if(select=='M'){
            
            //set selected Mandelbrot object 
		    fractal = 'M';
	        mb      =  new Mandelbrot();

		}

		else if(select=='J'){

            //set selected Julia object 
			fractal = 'J';
	        ju      = new Julia();
		}

		// set the panel size 
		setPreferredSize(new Dimension(WIDTH,HEIGHT));

	}
	
	
	
	//print points in the given coordinates with a given color
	private static void printPoint(Graphics2D frame, Color c,double x,double y){

	    frame.setColor(c); 
	    frame.draw(new Line2D.Double(x,y,x,y)); 
	}	
	 
	//call paintComponent from parent class 
	public void paintComponent(Graphics g){

		// call paintComponent from parent class 
		super.paintComponent(g); 
		Color color=null;
	  
		

		//public  void run() {
		//select a pixel from panel
		for(int i=0;i<=800;i++){

			for(int j=0;j<=800;j++){
				
				//set a point in the panel with default or set range for mandelbrot fractal
				double xSet    = (((double)i*(Mandelbrot.maxRealO-Mandelbrot.minRealO))/800)-Math.abs(Mandelbrot.minRealO);
				double ySet    = (((double)j*(Mandelbrot.maxImagO-Mandelbrot.minImagO))/800)-Math.abs(Mandelbrot.minImagO);

				
				//checks the type of fractal
				if(fractal=='M'){	

					
					this.bound = mb.print(xSet,ySet) ;
					
					//color iteration for different points
					color      = Color.getHSBColor((float)mb.outM*20.0f/(float)Mandelbrot.iterO,1.0f,1.0f);
				}
                
                //checks the type of fractal
				else if(fractal=='J'){

					this.bound = ju.print(xSet,ySet) ;
              
					//color iteration for different points
					
					color      = Color.getHSBColor((float)ju.outJ*20.0f/(float)Julia.iter,1.0f,1.0f);
				}	

				//checks the point bounded
				if(bound){	 

					printPoint((Graphics2D)g,Color.BLACK,i,j); 
				}

				else{

					printPoint((Graphics2D)g,color,i,j);
				}
			}	
		}		
	}	
	
	//Usage Details
	public static void printUsage(){

		System.out.println("Usage:");
    	System.out.println("java Fractal Mandelbrot x_start x_end y_start y_end iterations");
    	System.out.println("java Fractal Julia x y iterations");
    	System.exit(0);
	}
	
	public static void main(String[]args){	
		
		//define variables for args
		Double arg1  = null;
		Double arg2  = null;
		Double arg3  = null;
		Double arg4  = null;
        JFrame frame = null;

	    if(args.length >= 1){

	    	if(args[0].equalsIgnoreCase("Mandelbrot")){

	    	
	    		if((args.length == 1)||(args.length == 5)||(args.length == 6)) {
	    			
	    			if (args.length != 1) {
	    				
	    				 arg1=Double.parseDouble(args[1]);
	    				 arg2=Double.parseDouble(args[2]);
	    				 arg3=Double.parseDouble(args[3]);
	    				 arg4=Double.parseDouble(args[4]);
	    			}
                    
	    			
	    			
	    			if(args.length == 6){
	    				
	    				//check if arguments are given correctly as maxReal after minReal and minImag after maxImag 
	    				if((arg1>arg2)||(arg3>arg4)) {
		    				
	    					System.out.println("error in the format..");printUsage();
		    				System.exit(-1);
	    				}

    	                //set the Mandelbrot class static variables with 5 arguments
    					Mandelbrot.mandelbrotSet(arg1,arg2,arg3,arg4,Integer.parseInt(args[5]));
    				}
                    else if(args.length == 5){
                    	
                    	//check if arguments are given correctly as maxReal after minReal and minImag after maxImag 
                    	if((arg1>arg2)||(arg3>arg4)) {
    	    				
                    		System.out.println("error in the format..");printUsage();
    	    				System.exit(-1);
    	    				
                    	}
    	                
    	                //set the Mandelbrot class static variables with 4 arguments
                    	Mandelbrot.mandelbrotSet(arg1,arg2,arg3,arg4);
                 	}
                    else{

                        //set the Mandelbrot class static variables with 0 arguments
                 		Mandelbrot.mandelbrotSet();
    				}	
                 	
    			}

	    		else{

	    			System.out.println("\nOops Error Encountered");
	    			printUsage();
	    		}

	    		frame = new JFrame("Mandelbrot Set");   
	    		// set the content of the frame
	    		frame.setContentPane(new Fractal('M'));
	    		/**Runnable r=new Mandelbrot();
		    	Thread task=new Thread(r);
		    	task.start();**/

	    	}	



	    	else if(args[0].equalsIgnoreCase("Julia")){
	    		
	    		if((args.length == 3)||(args.length == 1)||(args.length == 4)){
                   
	    			if(args.length!=1) {
	    				arg1=Double.parseDouble(args[1]);
	    				arg2=Double.parseDouble(args[2]);	
	    				
	    			}
                    
	    			if(args.length == 3){

    	                //set the julia class static variables with 2 arguments
			    		Julia.juliaSet(arg1,arg2);
			    	}

			    	else if(args.length == 1) {
                         
                        //set the julia class static variables with 0 arguments
			    		Julia.juliaSet();
			    	}

			    	else{
                        
                        //set the julia class static variables with 3 arguments
			    		Julia.juliaSet(arg1,arg2,Integer.parseInt(args[3]));
			    	}

    			}

	    		else{

	    			System.out.println("\nOops Error Encountered");
	    			printUsage();
	    		}

	    		frame = new JFrame("Julia Set"); 

	    		// set the content of the frame as one of this panel
	    		/**Runnable r=new Julia();
		    	Thread task=new Thread(r);
		    	task.start();*/
	    		//frame.setContentPane(new Fractal('J'));
		    	frame.setContentPane(new Fractal('J'));
	    	}



	    	else{

	    		System.out.println("\nThe Passed Argument for the Fractal Type is not Identified");
		    	printUsage();
	    	}
            
	    	
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack(); 
			frame.setLocationRelativeTo(null); 
			frame.setVisible(true); 	

	    }



	    else{

	    	System.out.println("\nNot enough arguments");
	    	printUsage();
	    }
	}
}

  


