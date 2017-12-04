package org.billcz.common.math.sparse;

import org.billcz.common.math.Matrix2D;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public class DefaultSparseDoubleMatrix2D extends Matrix2D  {
    private Map<Integer, Double> values;

    public DefaultSparseDoubleMatrix2D(int rows, int cols) {
        super(rows, cols);
        values = new HashMap<Integer, Double>();
    }

    public boolean isSparse() {
        return true;
    }

    public void set(double value, int i, int j) {
        values.put(makeIndex(i, j), value);
    }

    public double get(int i, int j) {
        return values.get(makeIndex(i, j));
    }

    public Iterator<int[]> allValues() {
        return new DefaultSparseDoubleMatrix2DIterate();
    }

    class DefaultSparseDoubleMatrix2DIterate implements Iterator<int[]> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex != values.size();
        }

        public int[] next() {
            int[] subscripts = new int[2];
            subscripts[0] = currentIndex / getCols();
            subscripts[1] = currentIndex % getCols();
            currentIndex++;
            return subscripts;
        }

        public void remove() {

        }
    }

}
