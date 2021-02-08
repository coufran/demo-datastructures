package cn.coufran.learn.datastructrues;

import org.junit.Before;
import org.junit.Test;

public class VectorTest {
    private Vector vector;

    @Before
    public void init() {
        vector = null;
    }

    @Test
    public void testVector() {
        vector.insert(0, 9);
        vector.insert(0, 4);
        vector.insert(1, 5);
        vector.put(1, 2);
        vector.get(2);
    }

}
