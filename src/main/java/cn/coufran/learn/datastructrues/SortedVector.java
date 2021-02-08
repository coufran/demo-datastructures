package cn.coufran.learn.datastructrues;

/**
 * 有序向量
 */
public interface SortedVector<E> extends Vector<E> {
    /**
     * 查找目标元素e，返回不大于e且秩最大的元素的秩
     */
    int search(E e);

    /**
     * 剔除重复元素
     */
    void uniquify();
}
