/**
 * The PQueue class functions as a priority queue
 * and is essentially a light wrapper to the max-heap
 * data structure.
 *
 * @author Benjamin Warner
 *
 * @param T - Generic object for the priority queue to store.
 */

public class PQueue<T> {

    private MaxHeap<T> maxHeap;

    /**
     * Create an empty priority queue.
     */
    public PQueue() {
        this.maxHeap = new MaxHeap<T>();
    }

    /**
     * Create a priority queue and initialize it with
     * the given values and keys.
     *
     * @param T[] - the values to store in the PQueue
     * @param int[] - the priority of the values
     */
    public PQueue(T[] values, int[] keys) {
        this.maxHeap = new MaxHeap<T>(values, keys);
    }

    /**
     * Get the item with the highest priority, but don't
     * remove it.
     *
     * @return T
     */
    public T maximum() {
        return this.maxHeap.heapMax();
    }

    /**
     * Get the item with the highest priority, and
     * remove it from the queue.
     *
     * @return T
     */
    public T extractMax() {
        return this.maxHeap.extractHeapMax();
    }

    /**
     * Increase the key (priority) of the item located
     * at index. The index is 1-based.
     *
     * @param int - index of the item
     * @param int - the new key for the item
     */
    public void increaseKey(int index, int key) {
        this.maxHeap.increaseHeapKey(index, key);
    }

    /**
     * Insert value with key into the queue.
     *
     * @param T - the item to insert into the queue
     * @param int - the priority key for the item
     */
    public void insert(T value, int key) {
        this.maxHeap.maxHeapInsert(value, key);
    }

    /**
     * Check to see if the queue is empty.
     *
     * @return boolean - if the queue is empty or not
     */
    public boolean isEmpty() {
        return this.maxHeap.isEmpty();
    }

    /**
     * Get the number of items currently in the queue.
     *
     * @return int - the number of elements in the queue
     */
    public int size() {
        return this.maxHeap.getHeapSize();
    }
}
