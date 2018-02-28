import java.util.Random;
/**
 * Maman 16 - 20407 - Data Structures and Introduction to algorithms project
 * @author Guy Komari - 313286395
 * @version 23.2.2018
 */
public class Main 
{
	static Random rand = new Random();//random variable		
	/**
	 * Generates input array values and stores it in the "MedianHeap" data structure
	 */
	public static void setHeap(double array[])
	{
		int n = array.length;
		System.out.println("An array of " + n +" values");
		for (int i=0;i<n;i++)// O(n)
		{
			// generate double numbers in range 0 - 1023
			array[i] = Math.round((0 + (1023)*rand.nextDouble())*100.00)/ 100.00; 
		}

		int n1=n/4;// first checking point
		int n2=n/2;// second checking point
		int n3=(3*n)/4;// third checking point
		MedianAlgorithm m = new MedianAlgorithm(array,n1,n2,n3);

		/*--- Check MIN/MAX heaps ---*/

		System.out.println();
		MinHeap min = m.getMinHeap(); 
		MaxHeap max = m.getMaxHeap();
		System.out.println("minimum heap (size " +min.getCurrentHeapSize()+")");
		min.print();
		System.out.println();
		System.out.println("maximum heap (size " +max.getCurrentHeapSize()+")");
		max.print();
		System.out.println("---------------------------------------------------");
	}
	/**
	 * The main function - 
	 * create three different sized arrays and run the program
	 */
	public static void main(String[] args) 
	{
		double[] a = new double [200];
		double[] b = new double [400];
		double[] c = new double [800];
		setHeap(a); 
		setHeap(b);
		setHeap(c);
	}
}//end of main
