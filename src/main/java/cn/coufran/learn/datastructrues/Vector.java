package cn.coufran.learn.datastructrues;

/**
 * 向量
 */
public interface Vector<E> extends Sequence {
    /**
     * 报告向量当前的规模（元素总数）
     */
    int size();

    /**
     * 获取秩为r的元素
     */
    E get(int r);

    /**
     * 用e替换秩为r的元素
     */
    void put(int r, E e);

    /**
     * e作为秩为r的元素插入，元后级元素后移
     */
    int insert(int r, E e);

    /**
     * 删除秩为r的元素，返回该元素中元存放的对象
     */
    E remove(int r);

    /**
     * 判断所有元素是否已经按非降序排列
     */
    int disordered();

    /**
     * 调整各元素的位置，是指按照非降序排列
     */
    void sort();

    /**
     * 查找目标元素e
     */
    int find(E e);

    /**
     * 剔除重复元素
     */
    void deduplicate();

    /**
     * 遍历向量并同一处理所有元素
     */
    void traverse();
}
