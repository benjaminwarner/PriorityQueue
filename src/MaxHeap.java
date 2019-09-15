/**
 * @author Benjamin Warner
 */

 import java.util.Arrays;

public class MaxHeap<T> 
{
    private HeapNode<T>[] heap;
    private int heapSize;
    private int capacity;
    private final int DEFAULT_CAPACITY = 50;

    public MaxHeap() {
        this.heap = new HeapNode<T>[DEFAULT_CAPACITY];
        this.heapSize = 0;
        this.capacity = DEFAULT_CAPACITY;
    }

    public MaxHeap(Object[] values, int[] keys) {
        if (values.length != keys.length)
            throw new RuntimeException();

        // assume that more values will be added than what was provided, so provide a bit
        // of a buffer on the capacity
        this.heap = new HeapNode<T>[values.length + DEFAULT_CAPACITY];
        for (int i = 0; i < values.length; ++i)
            this.heap[i] = new HeapNode<T>(values[i], keys[i]);
        this.heapSize = values.length;
        this.capacity = heap.length + DEFAULT_CAPACITY;

        for (int i = this.heap.length / 2; i > -1; --i)
            maxHeapify(i);
    }

    public T heapMax() {
        // return the value of the root node
        return heap[0].getObject();
    }

    public T extractHeapMax() {
        // remove and return the value of the root node
        T value = heap[0].getObject();
        heap[0] = heap[heapSize - 1];
        heap[heapSize - 1] = null;
        maxHeapify(0);
        return value;
    }

    public void increaseHeapKey(int index, int key) {
        // increase the priority of the value located at index
        // call maxHeapify afterwards
        heap[index].setKey(key);
    }

    public void maxHeapInsert(T value, int key) {
        heap[heapSize] = new HeapNode<T>(value, key);
        heapSize++;
        for (int i = parent(heapSize - 1); i > -1; --i)
            maxHeapify(i);
    }

    private void expandCapacity() {
        // double the capacity and create a new array with the
        // new capacity
        capacity *= 2;
        heap = Arrays.copyOf(heap, capacity);
    }

    public void maxHeapify(int index) {
        int l = left(index);
        int r = right(index);
        int largest = index;
        if (l <= heapSize && heap[l].getKey() > heap[index].getKey())
            largest = l;
        if (r <= heapSize && heap[r].getKey() > heap[largest].getKey())
            largest = r;
        if (largest != index) {
            exchange(index, largest);
            maxHeapify(largest);
        }
    }

    private void moveUp(int index) {
        // swap the node at index with its parent
        exchange(parent(index), index);
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public boolean isEmpty() {
        return this.heapSize == 0;
    }

    private void exchange(int first, int second) {
        HeapNode<T> node1 = heap[first];
        HeapNode<T> node2 = heap[second];
        heap[first] = node2;
        heap[second] = node1;
    }

    private int left(int index) {
        // return the index of the parents left child
        return index * 2;
    }

    private int right(int index) {
        // return the index of the parents right child
        return index * 2 + 1;
    }

    private int parent(int index) {
        // return the index of the childs parent
        return index / 2;
    }

    private void setHeapSize(int size) {
        // do nothing; there's no need for this function
    }

    private void setCapacity(int capacity) {
        // do nothing; there's no need for this function
    }
}