package org.billcz.common.math.dense.imp;

import org.billcz.common.math.Matrix2D;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public class DefaultDenseDoubleMatrix2D extends Matrix2D {
    private double[] values;

    public DefaultDenseDoubleMatrix2D(int rows, int cols) {
        super(rows, cols);
        this.values = new double[rows * cols];
        Arrays.fill(values, 0, rows * cols, 0.0);
    }

    public static DefaultDenseDoubleMatrix2D create(int rows, int cols) {
        return zeros(rows, cols);
    }

    public static DefaultDenseDoubleMatrix2D zeros(int rows, int cols) {
        return new DefaultDenseDoubleMatrix2D(rows, cols);
    }

    public static DefaultDenseDoubleMatrix2D random(int rows, int cols) {
        DefaultDenseDoubleMatrix2D matrix2D = new DefaultDenseDoubleMatrix2D(rows, cols);
        matrix2D.random();
        return matrix2D;
    }

    private void random() {
        for (int i = 0; i < values.length; i++) {
            values[i] = ((int) (Math.random() * 1000)) / 1000.0;
        }
    }

    public void set(double value, int i, int j) {
        values[makeIndex(i, j)] = value;
    }

    public double get(int i, int j) {
        return values[makeIndex(i, j)];
    }

    public boolean isSparse() {
        return false;
    }

    public Iterator<int[]> allValues() {
        return new DefaultDenseDoubleMatrix2DIterate();
    }

    class DefaultDenseDoubleMatrix2DIterate implements Iterator<int[]> {
        private int currentIndex = 0;

        public boolean hasNext() {
            return currentIndex != values.length;
        }

        public int[] next() {
            int[] subscripts = new int[2];
            subscripts[0] = currentIndex / getCols();
            subscripts[1] = currentIndex % getCols();
            return subscripts;
        }

        public void remove() {

        }
    }

}
