/**
 * MaxHeap is an implementation of the Max-Heap
 * data structure. It is implemented using an
 * array.
 *
 * @author Benjamin Warner
 *
 * @param T - Generic object for the MaxHeap to store.
 */

 import java.util.Arrays;

public class MaxHeap<T> 
{
    private HeapNode<T>[] heap;
    private int heapSize;
    private int capacity;
    private final int DEFAULT_CAPACITY = 50;

    /**
     * Create an empty Max-Heap with a default capacity of 50.
     */
    @SuppressWarnings("unchecked")
    public MaxHeap() {
        this.heap = new HeapNode[DEFAULT_CAPACITY];
        this.heapSize = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    /**
     * Initialize a Max-Heap with values and their associate keys.
     *
     * The capacity for the heap is the length of the values + 50.
     * This is because, it's highly likely that additional values
     * will be added to the heap.
     *
     * @param T[] - the values to insert
     * @param int[] - the keys for the values
     */
    @SuppressWarnings("unchecked")
    public MaxHeap(T[] values, int[] keys) {
        if (values.length != keys.length)
            throw new RuntimeException();

        // assume that more values will be added than what was provided, so provide a bit
        // of a buffer on the capacity
        this.heap = new HeapNode[values.length + DEFAULT_CAPACITY];
        for (int i = 0; i < values.length; ++i)
            this.heap[i] = new HeapNode<T>(values[i], keys[i]);
        this.heapSize = values.length;
        this.capacity = heap.length + DEFAULT_CAPACITY;

        for (int i = this.heap.length / 2; i > -1; --i)
            maxHeapify(i);
    }

    /**
     * Get the value of the heaps root.
     *
     * @return T
     */
    public T heapMax() {
        return heap[0].getObject();
    }

    /**
     * Get the value of root node and remove it from the heap.
     *
     * @return T
     */
    public T extractHeapMax() {
        // remove and return the value of the root node
        T value = heap[0].getObject();
        heap[0] = heap[heapSize - 1];
        heap[heapSize - 1] = null;
        --heapSize;
        maxHeapify(0);
        return value;
    }

    /**
     * Increase the key value for the node at index.
     *
     * @param int index, int key
     */
    public void increaseHeapKey(int index, int key) {
        // apparently, the indexing for this method is 1-based instead
        // of 0-based. This is incredibly dumb, but whatever.
        heap[index - 1].setKey(key);
        for (int i = index; i > -1; i--)
            maxHeapify(i);
    }

    /**
     * Insert a value with key into the heap.
     * Max-Heapify the heap afterwards.
     *
     * @param T - the value
     * @param int - the key of the value
     */
    public void maxHeapInsert(T value, int key) {
        if (heapSize == capacity)
            expandCapacity();
        heap[heapSize] = new HeapNode<T>(value, key);
        heapSize++;
        for (int i = heapSize - 1; i > -1; --i)
            maxHeapify(i);
    }

    /**
     * Double the capacity of the heap and create a new array
     * with the expanded capacity.
     */
    private void expandCapacity() {
        capacity *= 2;
        heap = Arrays.copyOf(heap, capacity);
    }

    /**
     * Recursively move the node at index to its proper place, maintaining
     * the max-heap structure.
     *
     * @param int - index of the node to start with
     */
    public void maxHeapify(int index) {
        int l = left(index);
        int r = right(index);
        int largest = index;
        if (l < heapSize && heap[l].getKey() > heap[index].getKey())
            largest = l;
        if (r < heapSize && heap[r].getKey() > heap[largest].getKey())
            largest = r;
        if (largest != index) {
            exchange(index, largest);
            maxHeapify(largest);
        }
    }

    /**
     * Swap the node at index with its parent.
     *
     * @param int - index of the node to swap with its parent
     */
    private void moveUp(int index) {
        // swap the node at index with its parent
        exchange(parent(index), index);
    }

    /**
     * Get the number of elements in the heap.
     *
     * @return int
     */
    public int getHeapSize() {
        return this.heapSize;
    }

    /**
     * Determine if the heap contains no elements.
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        return this.heapSize == 0;
    }

    /**
     * Swap the position of first with second.
     *
     * @param int - the index of the first node
     * @param int - the index of the second node
     */
    private void exchange(int first, int second) {
        HeapNode<T> node1 = heap[first];
        HeapNode<T> node2 = heap[second];
        heap[first] = node2;
        heap[second] = node1;
    }

    /**
     * Get the index of the nodes left child at index.
     *
     * @param int - the index of the parent
     *
     * @return int
     */
    private int left(int index) {
        // return the index of the parents left child
        return index * 2 + 1;
    }

    /**
     * Get the index of the nodes right child at index.
     *
     * @param int - the index of the parent
     *
     * @return int
     */
    private int right(int index) {
        // return the index of the parents right child
        return index * 2 + 2;
    }

    /**
     * Get the index of nodes parent.
     *
     * @param int - the index of child node
     *
     * @return int
     */
    private int parent(int index) {
        // return the index of the childs parent
        return index / 2;
    }

    /**
     * Setter for the heapSize instance variable.
     *
     * Seeing as how the heapSize instance variable is private,
     * this function really has no use (until it's decided to enforce
     * some behavior regarding it). So, this function does
     * nothing but is included because the assignment said
     * I needed to.
     *
     * @param int size
     */
    private void setHeapSize(int size) {
        // do nothing; there's no need for this function
    }

    /**
     * Setter for the capacity instance variable.
     *
     * Same deal with the heapSize instance variable.
     * The variable is private, so there's no need
     * for a setter. Function does nothing.
     *
     * @param int capacity
     */
    private void setCapacity(int capacity) {
        // do nothing; there's no need for this function
    }

    /**
     * Get an array representation of the heap as a string.
     *
     * Mostly used for testing.
     *
     * @return String
     */
    public String toString() {
        String s = "[";

        for (int i = 0; i < heapSize - 1; ++i) {
            s += String.format("%s, ", heap[i].getKey());
        }

        s += heap[heapSize - 1].getKey();
        s += "]";

        return s;
    }
}
