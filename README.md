# Median-Online-Algorithm

The continues median problem requires adding elements to a structure and in any time be able to retrieve and print the current median of the elements added so far in ϴ(1) access time. Inserting elements to the structure should take running complexity of ϴ (logn).

The solution is implemented with 2 heaps - Minimum heap with all the elements that are bigger than the current median and a Maximum heap, with all the elements that are smaller than the current median. 

To preserve given constraints we keep both heaps balanced, or almost balanced - when one of the heaps is larger than the other one only by 1 element (this checked in every insertion). 

Otherwise, to insure the current median is the root of either one of the heaps (depends on size difference), we simply “rebalance” both heaps by removing the root of the larger heap and inserting it into the smaller one. This insures the root is always the valid current median.
