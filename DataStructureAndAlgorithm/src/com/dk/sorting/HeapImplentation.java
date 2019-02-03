package com.dk.sorting;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class HeapImplentation {
	private int [] items;
	private int capacity = 10;
	private int size = 0;
	HeapType heapType = HeapType.MINHEAP;
	
	
	public enum HeapType{
		MINHEAP,
		MAXHEAP
		
	}
	
	public static void main(String ...strings) {
		// Min Heap
		HeapImplentation heap = new HeapImplentation(HeapType.MINHEAP);
		heap.add(6);
		heap.add(10);
		heap.add(5);
		heap.add(15);
		heap.add(4);
		heap.add(20);
		heap.add(2);
		
		heap.printItems();
		
		try {
			System.out.println("\n"+heap.peek());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		heap.printItems();
		
		try {
			System.out.println("\n"+heap.poll());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		heap.printItems();
		//Max Heap
		HeapImplentation maxHeap = new HeapImplentation(HeapType.MAXHEAP);
		maxHeap.add(6);
		maxHeap.add(10);
		maxHeap.add(5);
		maxHeap.add(15);
		maxHeap.add(4);
		maxHeap.add(20);
		maxHeap.add(2);
		
		maxHeap.printItems();
		
		try {
			System.out.println("\n"+maxHeap.peek());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maxHeap.printItems();
		
		try {
			System.out.println("\n"+maxHeap.poll());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		maxHeap.printItems();
	}
	
	public void printItems() {
		for(int i=0; i <size; i++) {
			System.out.print(items[i]+" ");
		}
	}
	public HeapImplentation(HeapType type) {
		this.heapType = type;
		items = new int[capacity];
	}

	
	public void add(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		/**
		 * When adding the element, adjust the Heap
		 */
		heapifyUp();
	}
	
	public int peek() throws IllegalAccessException {
		if(size < 0) {
			throw new IllegalAccessException("Array is empty");
		}
		
		return items[0];
	}
	
	public int poll() throws IllegalAccessException {
		if(size < 0) {
			throw new IllegalAccessException("Array is empty");
		}
		
		int item = items[0];
		items[0] = items[size-1];
		size--;
		/**
		 * When element got removed then re-arrange the Heap
		 */
		heapifyDown();
		return item;
	}
	
	
	public void heapifyDown() {
		int index = 0;
		int swapIndex = -1;
		Predicate<Integer> condition = null;
		BiPredicate<Integer, Integer> stopCondidtion = null;
		while(hasLeftChild(index)) {
			swapIndex = getLeftChildIndex(index);
			if(this.heapType == HeapType.MINHEAP) {
				condition = (i) -> hasRightChild(i) && getLeftChild(i) > getRightChild(i);
			}else {
				condition = (i) -> hasRightChild(i) && getLeftChild(i) < getRightChild(i);
			}
			
			if(condition.test(index)) {
				swapIndex = getRightChildIndex(index);
			}
			if(this.heapType == HeapType.MINHEAP) {
				stopCondidtion = (i, s) -> items[i] < items[s];
			}else {
				stopCondidtion = (i, s) -> items[i] > items[s];
			}
			if(stopCondidtion.test(index, swapIndex)) {
				//If root is max in min from it's child element then stop the swapping
				break;
			}else {
				swap(index, swapIndex);
			}
			
			index = swapIndex;
			
		}
	}
	
	public void heapifyUp() {
		int index = size - 1;
		Predicate<Integer> condition = null;
		
		while(index != 0) {
			if(this.heapType == HeapType.MINHEAP) {
				condition = (i) -> getParent(i) > items[i];
			}else {
				condition = (i) -> getParent(i) < items[i];
			}
			
			if(condition.test(index)) {
				swap(getParentIndex(index), index);
			}
			index = getParentIndex(index);
		}
	}
	

	private int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}
	
	private int getRightChildIndex(int index) {
		return 2*index + 2;
	}
	
	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}
	
	private int getLeftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	
	private int getRightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	
	private int getParent(int index) {
		return items[getParentIndex(index)];
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	
	private void ensureCapacity() {
		if(size == capacity) {
			capacity *= 2;
			Arrays.copyOf(items, capacity);
		}
	}
	
	private void swap(int indexOne, int indexTwo) {
		
		items[indexOne] ^= items[indexTwo];
		items[indexTwo] ^= items[indexOne];
		items[indexOne] ^= items[indexTwo];
	}
	
	

	public int[] getItems() {
		return items;
	}

	public void setItems(int[] items) {
		this.items = items;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public HeapType getHeapType() {
		return heapType;
	}

	public void setHeapType(HeapType heapType) {
		this.heapType = heapType;
	}
	
	

}
