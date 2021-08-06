package com.dk.queue;

import java.util.*;

public class PriorityQueueImpl<T extends Comparable<T>>{
    List<T> heap = null;
    /*
       This is to keep track of indices of elements to improve Run time complexity of the removal with the trade0ff of extra memory.
     */
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public PriorityQueueImpl(){
        this(1);
    }

    public PriorityQueueImpl(int heapSize){
        this.heap = new ArrayList<>(heapSize);
    }

    //Construct Priority Queue for the given elements
    public PriorityQueueImpl(T [] elements){
        this.heap = new ArrayList<>(elements.length);
        int heapSize = elements.length;
        for(int i = 0; i < heapSize; i++){
            heap.add(elements[i]);
            map.computeIfAbsent(elements[i], t -> new TreeSet<>()).add(i);
        }

        //Heapify Process O(n)
        for(int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--){
            heapifyDown(i);
        }
    }

    public PriorityQueueImpl(Collection<T> elements){
       //Constructing Heap will take O(nlog)
        this(elements.size());
        for(T elem: elements){
           add(elem);
       }
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public void clear(){
        heap.clear();
        map.clear();
    }

    public int size(){
        return heap.size();
    }
    // Return the top elements from the priorityQueue
    public T peek(){
        if(!isEmpty()){
            return heap.get(0);
        }

        return null;
    }

    //Remove the elements
    public T poll(){
        return removeAt(0);
    }

    public boolean contains(T elem){
        // should take O(1), Map Lookup will take O(1)
        if(elem == null) return false;
        return map.containsKey(elem);
    }
    // Add the element to the heap.
    public void add(T element){
       if(element == null) throw new IllegalArgumentException("Null Elements has been passed");
       heap.add(element);
       map.computeIfAbsent(element, t -> new TreeSet<>()).add(heap.size() - 1);
       heapifyUp(heap.size() - 1);

    }

    // Recursively checks if this heap is a min heap
    // This method is just for testing purposes to make
    // sure the heap invariant is still being maintained
    // Called this method with k=0 to start at the root
    public boolean isMinHeap(int k) {

        // If we are outside the bounds of the heap return true
        int heapSize = size();
        if (k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        // Make sure that the current node k is less than
        // both of its children left, and right if they exist
        // return false otherwise to indicate an invalid heap
        if (left < heapSize && !less(k, left)) return false;
        if (right < heapSize && !less(k, right)) return false;

        // Recurse on both children to make sure they're also valid heaps
        return isMinHeap(left) && isMinHeap(right);
    }

    // Removes a particular element in the heap, O(log(n))
    public boolean remove(T element) {

        if (element == null) return false;

        // Linear removal via search, O(n)
        // for (int i = 0; i < heapSize; i++) {
        //   if (element.equals(heap.get(i))) {
        //     removeAt(i);
        //     return true;
        //   }
        // }

        // Logarithmic removal with map, O(log(n))
        Integer index = mapGet(element);
        if (index != null) removeAt(index);
        return index != null;
    }

    private T removeAt(int index){
        if(isEmpty()) return null;
        T removedData = heap.get(index);
        int lastIndex = heap.size() - 1;
        Collections.swap(heap, index, lastIndex);
        //TODO map remove.
        heap.remove(lastIndex);
        map.get(removedData).remove(lastIndex);
        if(map.get(removedData).size() == 0) map.remove(removedData);

        if( index == lastIndex) return removedData;

        heapifyDown(index);
        return null;
    }

    private boolean less(int i, int j){
        return heap.get(i).compareTo(heap.get(j)) <= 0;
    }

    //O(log(n))
    private void heapifyUp(int k){
        int parent = (k - 1)/2;
        while(k > 0 && less(k, parent)){
            Collections.swap(heap, k, parent);
            mapSwap(heap.get(k), heap.get(parent), k, parent);
            k = parent;
            parent = (k - 1)/2;
        }
    }

    private void heapifyDown(int k){
        int heapSize = size();
        while(true){
            int left = 2 * k + 1; //left node
            int right = 2 * k + 2; // right node

            //Assume left is smallest.
            int smallest = left;
            if(right < heapSize && less(right, left)){
                smallest = right;
            }
            // Stop we are outside of the boundary.
            if(left >= heapSize || less(k, smallest)){
                break;
            }

            Collections.swap(heap, k, smallest);
            mapSwap(heap.get(k), heap.get(smallest), k, smallest);
            k = smallest;
        }

    }

    private void mapSwap(T val1, T val2, int i, int j){
        TreeSet<Integer> set1 = map.get(val1);
        TreeSet<Integer> set2 = map.get(val2);
        set1.remove(i);
        set2.remove(j);

        set1.add(j);
        set2.add(i);
    }

    private Integer mapGet(T value) {
        TreeSet<Integer> set = map.get(value);
        if (set != null) return set.last();
        return null;
    }


}
