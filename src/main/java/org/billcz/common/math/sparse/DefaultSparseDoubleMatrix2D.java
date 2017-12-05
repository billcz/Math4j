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

    public static DefaultSparseDoubleMatrix2D create(int rows, int cols) {
        return zeros(rows, cols);
    }

    public static DefaultSparseDoubleMatrix2D zeros(int rows, int cols) {
        return new DefaultSparseDoubleMatrix2D(rows, cols);
    }

    public static DefaultSparseDoubleMatrix2D random(int rows, int cols) {
        DefaultSparseDoubleMatrix2D matrix2D = new DefaultSparseDoubleMatrix2D(rows, cols);
        matrix2D.random();
        return matrix2D;
    }

    private void random() {
        for (int k : values.keySet()) {
            values.put(k, ((int) (Math.random() * 1000)) / 1000.0);
        }
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

    public Iterable<int[]> allValues() {
        return new DefaultSparseDoubleMatrix2DIterable();
    }

    class DefaultSparseDoubleMatrix2DIterable implements Iterable<int[]> {
        private int cursor = 0;
        public Iterator<int[]> iterator() {

            return new Iterator<int[]>() {
                public boolean hasNext() {
                    return cursor < values.size();
                }

                public int[] next() {
                    int[] subscripts = new int[2];
                    subscripts[0] = cursor / getCols();
                    subscripts[1] = cursor % getCols();
                    cursor++;
                    return subscripts;
                }

                public void remove() {

                }
            };
        }
    }
}
