/**
 * Maximum heap 
 */
public class MaxHeap extends Heap
{
	/**
	 * Initializing Maximum Heap
	 * @param maxsize - the size of the Maximum heap
	 */
	public MaxHeap(int maxSize)
	{
		super(maxSize);
		this.heap[0]=Double.MIN_VALUE;//the first value should get the minimum value of double 
	}
	/**
	 * This method maintaining the maximum heap properties 
	 * Time complexity O(log(n)) - traverse sub-tree path (height is log(n))
	 */
	protected void HEAPIFY (int i)
	{
		int l = left(i);
		int r = right(i);
		int largest;
		if (l <= this.currentHeapSize && this.heap[l] > this.heap[i])
			largest=l;
		else
			largest=i;
		if (r <= this.currentHeapSize && this.heap[r] > this.heap[largest])
			largest = r;
		if (largest != i){
			swap(i,largest);
			HEAPIFY(largest);
		}
	}
	/**  
	 * This method adds a new key to the heap while maintaining the maximum heap properties
	 * Time complexity is O(log(n))
	 */
	public void insert(double x)
	{
		int pos = this.currentHeapSize;
		this.currentHeapSize++;
		for(; pos > 0 && x>this.heap[pos/2]; pos = pos/2 )
		{
			heap[pos] = heap[pos/2];
		}
		heap[pos] = x;
	}
	/**
	 *  this method removes the top value of the heap and return the removed value
	 */
	public double removeTop()
	{
		double removed = this.heap[0]; 
		swap(0,this.currentHeapSize-1);
		this.heap[this.currentHeapSize-1]=Integer.MIN_VALUE;
		this.currentHeapSize--;
		HEAPIFY(0);
		return removed;
	}
}//end of class
