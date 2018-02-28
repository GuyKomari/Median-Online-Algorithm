/**
 * Heap abstract class implemented by double values array
 */
public abstract class Heap 
{
	protected int currentHeapSize; // heap size insertion 
	protected int maxHeapSize; // maximum heap size capacity 
	protected double[] heap; // double array representing heap data structure
	/**
	 * Initializing heap
	 * @param maxsize - size of the heap
	 */
	public Heap(int maxsize){
		this.maxHeapSize = maxsize;
		this.currentHeapSize = 0; 
		this.heap = new double[this.maxHeapSize+1];
	}
	/**
	 * @param i - node index
	 * @return the parent of the index node
	 */
	protected int parent(int i)
	{
		return i/2;
	}
	/**
	 * @param i - node index
	 * @return the left child of the node
	 */
	protected int left(int i)
	{
		return 2*i>0?2*i:1;
	}
	/**
	 * @param i - node index
	 * @return the right child of the node
	 */
	protected int right(int i)
	{
		return 2*i+1>1?2*i+1:2;
	}
	/**
	 * Swap 2 nodes in heap by their indexes
	 * @param index1
	 * @param index2
	 */
	protected void swap(int index1, int index2)
	{
		double tmp = this.heap[index1];
		this.heap[index1]=this.heap[index2];
		this.heap[index2]=tmp;
	}
	/**
	 * @return the root value of the heap if the heap is not empty
	 */
	public double getTopValue()
	{
		return !isEmpty()? this.heap[0]:-1;
	}
	/**
	 * @return current heap size
	 */
	public int getCurrentHeapSize()
	{
		return this.currentHeapSize;
	}
	/**
	 * @return true if the heap is empty, otherwise return false
	 */
	private boolean isEmpty(){
		return this.currentHeapSize<=0?true:false;
	}
	/**
	 * print the heap
	 */
	public void print()
	{
		int i,j,count=-1;
		for(i=0;i<this.currentHeapSize;i++){
			for(j=0;j<Math.pow(2,i)&&j+Math.pow(2,i)<=this.currentHeapSize;j++){
				System.out.print(this.heap[j+(int)Math.pow(2,i)-1]+" | ");
			}
			if (count<Math.log(this.currentHeapSize)/Math.log(2))
				System.out.println();
			count++;
		}	
	}
	/**
	 * @param key - insert value to heap
	 */
	abstract void insert(double key);
	/**
	 * Remove the root value of the heap and returns it
	 * @return top value of the heap
	 */
	abstract double removeTop();
	/**
	 * Fixing sub-tree according to heap policy (max or min)
	 * @param i - heapify from index i
	 */
	abstract void HEAPIFY (int i);
}//end of class
