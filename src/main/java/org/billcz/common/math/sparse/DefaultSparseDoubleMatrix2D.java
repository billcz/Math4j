package org.billcz.common.math.sparse;

import org.billcz.common.math.Matrix;
import org.billcz.common.math.Matrix2D;

import java.util.HashMap;
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

    public boolean isSparse() {
        return true;
    }

    public void set(double value, int i, int j) {
        values.put(makeIndex(i, j), value);
    }

    public double get(int i, int j) {
        return values.get(makeIndex(i, j));
    }
}
