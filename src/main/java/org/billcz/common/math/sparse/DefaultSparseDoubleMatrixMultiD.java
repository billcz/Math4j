package org.billcz.common.math.sparse;

import org.billcz.common.math.MatrixMultiD;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/5
 */
public class DefaultSparseDoubleMatrixMultiD extends MatrixMultiD {
    private Map<Integer, Double> values;

    public DefaultSparseDoubleMatrixMultiD(int... sizes) {
        super(sizes);
        values = new HashMap<Integer, Double>();
    }

    public static DefaultSparseDoubleMatrixMultiD create(int... sizes) {
        return zeros(sizes);
    }

    public static DefaultSparseDoubleMatrixMultiD zeros(int... sizes) {
        return new DefaultSparseDoubleMatrixMultiD(sizes);
    }

    public boolean isSparse() {
        return true;
    }

    public void set(double value, int... subscripts) {
        values.put(makeIndex(subscripts), value);
    }

    public double get(int... subscripts) {
        return values.get(makeIndex(subscripts));
    }
}
