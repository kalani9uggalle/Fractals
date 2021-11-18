


public class Julia extends Mandelbrot{
	
	
      
	private static double xSetJ =-0.4;
	private static double ySetJ =0.6;
	public  static int    iter  =1000;
	public  int    outJ;
	 
	  
    //overloading juliaSet for 0 arguments
	//Initialising class variables
	public static void juliaSet() {
	
    }
      
    //overloading juliaSet for 2 arguments
	//Initialising class variables
    public static void juliaSet(double real,double imag) {
    	 
	    xSetJ=real;
	    ySetJ=imag;
	    iter =1000;


    }
      
    //overloading juliaSet for 3  arguments
	//Initialising class variables
    public static void juliaSet(double real,double imag,int iters) {
	    	 
	    xSetJ=real;
	    ySetJ=imag;
	    iter =iters;


    }
   /**
    @Override
	public void run() {
		
	}**/
    @Override
    public boolean print(double start_x,double start_y){
        
    	//run();
	    //set starting values Z0
	
		double funcX = start_x;
		double funcY = start_y;

		//Initialise complex point C
		double xSet = xSetJ;
	    double ySet = ySetJ;

	    //maximum iterations
		iterO = iter;
		
	    int i=0;
	   
		for( i=1;i < iterO;i++){
		
	            //check if unbounded  
			    if(Double.compare(Math.pow(funcX,2)+Math.pow(funcY,2),4) > 0){

	                //set iterations done by point object in Julia class        
			    	outJ=i;

			    	//return false for the function call at fractal class
	                return false;  
			    }

	            else{

			    double a = Math.pow(Math.abs(funcX),2);
	            double b = Math.pow(Math.abs(funcY),2);
	                    
			    double ab=funcX*funcY*2;
	                    
	            //set Z(i+1)       
			    double real = a - b +xSet ;
	            double imag = ab+ySet;

	            funcX = real;
	            funcY = imag;
	                   
	                    
			    }
	    }
	    
	    //if bounded 
	    //set iterations done by point object in Julia class 
	    outJ=i;   
	    //return true for the function call at fractal class	
		return true;
	}
		
		

	
}

