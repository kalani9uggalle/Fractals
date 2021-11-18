

public class Mandelbrot  {

	protected static double minRealO=-1;
	protected static double maxRealO= 1;
    protected static double minImagO=-1;
	protected static double maxImagO= 1;
	protected static int    iterO   = 1000;
    protected double start_x;
    protected double start_y;
	protected double xSet;
	protected double ySet;
    public    int    outM;
	
	
    
    //overloading mandelbrotSet for 0 arguments
	//Initialising class variables      
	public static void mandelbrotSet() {

    }

    //overloading mandelbrotSet for 4 arguments
	//Initialising class variables
	public static void mandelbrotSet(double minReal,double maxReal,double minImag,double maxImag) {

		minRealO = minReal;
		maxRealO = maxReal;
		minImagO = minImag;
		maxImagO = maxImag;
        iterO    = 1000;     
		
    }
	
	//overloading mandelbrotSet for 5 arguments
	//Initialising class variables
	public static void mandelbrotSet(double minReal,double maxReal,double minImag,double maxImag,int iter) {

		minRealO = minReal;
		maxRealO = maxReal;
		minImagO = minImag;
		maxImagO = maxImag;
		iterO    = iter;
		
    } 
	/**
	public void run() {
		
	}**/
   
    //loop for check if bound
    public  boolean print(double xSet,double ySet) {
       // run();
		//set starting values Z0
	      
		double funcX = 0;
	    double funcY = 0;
	    
	    int i=0;
	   
		for( i=1;i < iterO;i++){
		
	        //check if unbounded      
		    if(Double.compare(Math.pow(funcX,2)+Math.pow(funcY,2),4) > 0){
	            
		    	outM = i;
	            return false;  
		    }

	        else{

			    double a = Math.pow(Math.abs(funcX),2);
	            double b = Math.pow(Math.abs(funcY),2);
	                    
			    double ab = funcX*funcY*2;
	                    
	            //set Z(i+1)       
			    double real = a - b +xSet ;
	            double imag = ab+ySet;

	            funcX = real;
	            funcY = imag;
	              
	        }
	    }
	    
	    //if bounded 
	    outM=i;   
	 
	    return true;
	}
    
  
		
}

