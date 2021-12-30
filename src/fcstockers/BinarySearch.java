package fcstockers;

public class BinarySearch {
	static int binarySearchImplementation(double[] arr, int start, int end, double key)
	   {
		if(start == (end-1))
		{
			if(arr[start] == key)
				return start;
			else
				return -1;
		}
		if(end >= start)
		{
		   int mid = (start + (end-1))/2;
		
		   if(arr[mid] == key)
			return mid;

		   // if the element is bigger than it must be on left of the mid
		   if(arr[mid] < key)
			 return binarySearchImplementation(arr, start, mid - 1, key);
		
		// if the element is smaller than the mid element, then it must be on the right of the array
		   return binarySearchImplementation(arr, mid + 1, end, key);
		}

		return -1;
	   }
}
