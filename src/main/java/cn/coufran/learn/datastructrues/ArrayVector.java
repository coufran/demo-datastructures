package cn.coufran.learn.datastructrues;

public class ArrayVector<E> implements Vector<E> {
    private static final int DEFAULT_CAPACITY = 3;

    private int size;
    private int capacity;
    private Object[] elem;

    public ArrayVector() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayVector(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.elem = new Object[capacity];
    }

    public ArrayVector(E[] elem, int lo, int hi) {
        copyFrom(elem, lo, hi);
    }

    public ArrayVector(ArrayVector<E> vector, int lo, int hi) {
        copyFrom(vector.elem, lo, hi);
    }

    public ArrayVector(ArrayVector<E> vector) {
        this(vector, 0, vector.size);
    }

    private void copyFrom(Object[] elem, int lo, int hi) {
        this.capacity = 2 * (hi - lo);
        this.elem = new Object[this.capacity];
        this.size = 0;
        while(lo < hi) {
            this.elem[this.size++] = elem[lo++];
        }
    }

    /**
     * 扩容
     */
    private void expand() {
        if(this.size < this.capacity) {
            return;
        }
        this.capacity = Math.max(this.capacity, DEFAULT_CAPACITY);
        Object[] oldElem = this.elem;
        this.elem = new Object[this.capacity <<= 1];
        for(int i=0; i<size; i++) {
            this.elem[i] = oldElem[i];
        }
    }

    /**
     * 缩容
     */
    private void shirnk() {

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int r) {
        return (E) this.elem[r];
    }

    @Override
    public void put(int r, E e) {
        this.elem[r] = e;
    }

    @Override
    public int insert(int r, E e) {
        this.expand();
        for (int i = this.size; i > r; i--) {
            this.elem[i] = this.elem[i - 1];
        }
        this.elem[r] = e;
        this.size++;
        return r;
    }

    private int remove(int lo, int hi) {
        if(lo == hi) {
            return 0;
        }
        while(hi < this.size) {
            this.elem[lo++] = this.elem[hi++];
        }
        this.size = lo;
        this.shirnk();
        return hi - lo;
    }

    @Override
    public E remove(int r) {
        Object e = this.elem[r];
        this.remove(r, r+1);
        return (E) e;
    }

    @Override
    public int disordered() {
        return 0;
    }

    @Override
    public void sort() {

    }

    private int find(E e, int lo, int hi) {
        while(hi-- > lo && !this.elem[hi].equals(e));
        return hi;
    }

    @Override
    public int find(E e) {
        return this.find(e, 0, this.size);
    }

    @Override
    public void deduplicate() {
        for(int i=1; i<this.size; i++) {
            int r = this.find((E) this.elem[i], 0, i);
            if(r != -1) {
                this.remove(i);
            }
        }
    }

    @Override
    public void traverse() {

    }
}
