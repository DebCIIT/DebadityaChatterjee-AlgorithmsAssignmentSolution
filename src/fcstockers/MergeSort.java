package fcstockers;

public class MergeSort {
	static double[] merge(double arr[], int left, int mid, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		double leftArray[] = new double[n1];
		double rightArray[] = new double[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		
		while (i < n1 && j < n2) {
			
			if (leftArray[i] >= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}

				
		return arr;
	

	}

	
	public static double[] sort(double[] notes, int left, int right) {
		
		if(left == right)
			return notes;

		int mid = 0;
		double[] arr = new double[notes.length];
		
		if (left < right) {
			
			// Find the middle point
			mid = (left + right) / 2;

			// Sort first and second halves
			sort(notes, left, mid);
			sort(notes, mid + 1, right);
			
			// Merge the sorted halves
			arr = merge(notes, left, mid, right);

		}
		
		return arr;
		
	}

	public static void printArray(double arr[], int start, int end, int asc_des) {
		
		if (asc_des == 2) {
			for (int j = start; j <= end; j++) {
				System.out.print(arr[j] + " ");
			}
		} else {
			for (int j = end; j >= 0; j--) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}


}
