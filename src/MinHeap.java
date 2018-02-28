/**
 * Minimum heap 
 */
public class MinHeap extends Heap
{
	/**
	 * Initializing Minimum heap
	 * @param maxsize - size of the Minimum heap
	 */
	public MinHeap(int maxSize)
	{
		super(maxSize);
		this.heap[0]=Double.MAX_VALUE;//the first value should get the maximum value of double
	}
	/**
	 * This method maintaining the minimum heap properties 
	 * Time complexity O(log(n)) - traverse sub-tree path (height is log(n))
	 */
	protected void HEAPIFY (int i)
	{
		int l = left(i);
		int r = right(i);
		int lowest;
		if (l <= this.currentHeapSize && this.heap[l] < this.heap[i])
			lowest=l;
		else
			lowest=i;
		if (r <= this.currentHeapSize && this.heap[r] < this.heap[lowest])
			lowest = r;
		if (lowest != i){
			swap(i,lowest);
			HEAPIFY(lowest);
		}
	} 
	/**  
	 * This method adds a new key to the heap while maintaining the minimum heap properties
	 * Time complexity is O(log(n))
	 */
	public void insert(double key)
	{
		int pos = this.currentHeapSize;
		this.currentHeapSize++;
		for(; pos > 0 && key<this.heap[pos/2]; pos = pos/2 )
		{
			heap[pos] = heap[pos/2];
		}
		heap[pos] = key;
	}
	/**
	 *  this method removes the top value of the heap and return the removed value
	 */
	public double removeTop()
	{
		double removed = this.heap[0]; 
		swap(0,this.currentHeapSize-1);
		this.heap[this.currentHeapSize-1]=Integer.MAX_VALUE;
		this.currentHeapSize--;
		HEAPIFY(0);
		return removed;
	}
}//end of class

