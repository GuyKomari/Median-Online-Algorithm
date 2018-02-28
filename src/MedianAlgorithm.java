/**
 * median class implemented by minimum and maximum heaps and holds the current median 
 */
public class MedianAlgorithm {
	private MaxHeap maxHeap; // maximum heap
	private MinHeap minHeap; // minimum heap
	private double currentMedian = 0; // lower median policy
	/**
	 * @param arr - double array to initialize the heaps
	 * @param n1 - first point to print the median
	 * @param n2 - second point to print the median
	 * @param n3 - third point to print the median
	 */
	public MedianAlgorithm(double arr[], int n1, int n2, int n3) 
	{
		this.maxHeap = new MaxHeap(arr.length / 2);
		this.minHeap = new MinHeap(arr.length / 2);
		// O(n)
		int i;
		for (i = 0; i < arr.length; i++) 
		{
			insert(arr[i]);
			if (i == n1 - 1 || i == n2 - 1 || i == n3 - 1)
				printMedian(i);
		}
		printMedian(i-1);
	}
	/**
	 * this method decides which heap to insert the new value
	 * @param value - new value to be inserted to one of the heaps
	 */
	public void insert(double value) 
	{
		int state = compare(this.maxHeap.getCurrentHeapSize(), this.minHeap.getCurrentHeapSize());//state - compares the heaps size
		switch (state) {

		case 1: // case - There are more elements in the maximum heap
			if (value < this.currentMedian) // the new value to be inserted is smaller than the current median	
			{
				this.minHeap.insert(this.maxHeap.removeTop()); //remove the top value of the maximum heap and insert this value to the minimum heap 
				this.maxHeap.insert(value);// insert the new value to the maximum heap
			} 
			else// the new value to be inserted is equal to or greater than the current median
			{
				this.minHeap.insert(value);// insert the new value to the maximum heap
			}
			this.currentMedian = Math.min(this.maxHeap.getTopValue(), this.minHeap.getTopValue());// update the current median by lower median policy
			break;

		case 0: // case - The heaps contain the same number of elements
			if (value < this.currentMedian) // the new value to be inserted is smaller than the current median
			{
				this.maxHeap.insert(value);// insert the new value to the maximum heap
				this.currentMedian = this.maxHeap.getTopValue();// update the current median to be the root of the maximum heap - because this heap has more elements
			} 
			else //otherwise
			{
				this.minHeap.insert(value);// insert the new value to the minimum heap
				this.currentMedian = this.minHeap.getTopValue();//update the current median to be the root of the minimum heap - because this heap has more elements
			}
			break;

		case -1: // There are more elements in the minimum heap
			if (value < this.currentMedian)// the new value to be inserted is smaller than the current median
			{
				this.maxHeap.insert(value);// insert the new value to the maximum heap
			}
			else 
			{
				this.maxHeap.insert(this.minHeap.removeTop());//remove the top value of the minimum heap and insert this value to the maximum heap
				this.minHeap.insert(value);//// insert the new value to the minimum heap
			}
			this.currentMedian = Math.min(this.maxHeap.getTopValue(), this.minHeap.getTopValue());//update the current median
			break;
		default: break;
		}
	}
	/**
	 * @return :
	 * 0 if the heaps have the same value, 
	 * 1 if the first heap has more elements than the second,
	 * -1 if the first heap has less elements than the second
	 * @param a - size of heap 
	 * @param b - size of another heap
	 * @return
	 */
	int compare(int a, int b) {
		if (a == b)
			return 0;
		return a > b ? 1 : -1;
	}
	/**
	 * @return the minimum heap
	 */
	public MinHeap getMinHeap() {
		return this.minHeap;
	}
	/**
	 * @return the maximum heap
	 */
	public MaxHeap getMaxHeap() {
		return this.maxHeap;
	}
	/**
	 * prints the current median - time complexity Theta(1)
	 * @param i - checking point number 
	 */
	public void printMedian(int i) {
		System.out.println("The median value at the checking point " + (i + 1) + " is : " + this.currentMedian);
	}
}//end of class
