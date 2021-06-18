package com.dk.array;
import java.util.Arrays;

/**
 * 
 * @author Deepak
 * 
 *         Given a large array of integers and a window of size 'w', find the
 *         current maximum in the window as the window slides through the entire
 *         array.
 * 
 *         Description: Given a large array of integers and a window of size w,
 *         find current maximum in the window as the window slides through the
 *         entire array. Consider the array below and let's try to find all
 *         maximum with window size = 3. [-4,2,-5,3,6] Step 1: For the first 3
 *         elements in window, max is 2. Step 2: Slide window one position to
 *         the right and max for window becomes 3. Step 3: In the last window,
 *         max is 6.
 *
 */
public class FindMaximumInSlidingWindow {

	public static void main(String[] args) {
		int[] array = { -4, 2, -5, 3, 6 };
		System.out.println("Window Size 3");
		findMaxSlidingWindow(array, 3);

		array = new int[]{ 1, 2, 3, 4, 3, 2, 1, 2, 5 };
		System.out.println("Window Size 4");
		findMaxSlidingWindow(array, 4);

		System.out.println("\nWindow Size 3");
		findMaxSlidingWindow(array, 3);

		System.out.println("\nWindow Size 5");
		findMaxSlidingWindow(array, 5);

	}

	public static void findMaxSlidingWindow(int[] arr, int window_size) {

		if (arr.length < window_size) {
			return;
		}

		for (int i = 0; i + (window_size - 1) < arr.length; i++) {
			int[] window = Arrays.copyOfRange(arr, i, i + window_size);
			Arrays.sort(window);
			System.out.print(window[window.length - 1] + ", ");
		}
	}

}
