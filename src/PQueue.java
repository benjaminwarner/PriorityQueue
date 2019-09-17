public class PQueue<T> {

    private MaxHeap<T> maxHeap;

    public PQueue() {
        this.maxHeap = new MaxHeap<T>();
    }

    public PQueue(T[] values, int[] keys) {
        this.maxHeap = new MaxHeap<T>(values, keys);
    }

    public T maximum() {
        return this.maxHeap.heapMax();
    }

    public T extractMax() {
        return this.maxHeap.extractHeapMax();
    }

    public void increaseKey(int index, int key) {
        this.maxHeap.increaseHeapKey(index, key);
    }

    public void insert(T value, int key) {
        this.maxHeap.maxHeapInsert(value, key);
    }

    public boolean isEmpty() {
        return this.maxHeap.isEmpty();
    }

    public int size() {
        return this.maxHeap.getHeapSize();
    }
}