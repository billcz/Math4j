package org.billcz.common.math.dense.imp;

import org.billcz.common.math.MatrixMultiD;
import org.billcz.common.math.util.RandomUtil;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public class DefaultDenseDoubleMatrixMultiD extends MatrixMultiD {
    private double[] values;

    public DefaultDenseDoubleMatrixMultiD(int...sizes) {
        super(sizes);
        init(sizes);
    }

    public static DefaultDenseDoubleMatrixMultiD create(int... sizes) {
        return zeros(sizes);
    }

    public static DefaultDenseDoubleMatrixMultiD zeros(int... sizes) {
        return new DefaultDenseDoubleMatrixMultiD(sizes);
    }

    public static DefaultDenseDoubleMatrixMultiD random(int... sizes) {
        DefaultDenseDoubleMatrixMultiD matrixMultiD = new DefaultDenseDoubleMatrixMultiD(sizes);
        matrixMultiD.random();
        return matrixMultiD;
    }

    private void init(int... sizes) {
        int dimension = 1;
        for (int size : sizes) {
            dimension *= size;
        }
        this.values = new double[dimension];
    }

    private void random() {
        for (int i = 0; i < values.length; i++) {
            values[i] = RandomUtil.randomInt();
        }
    }

    public boolean isSparse() {
        return false;
    }

    public void set(double value, int... subscripts) {
        values[makeIndex(subscripts)] = value;
    }

    public double get(int... subscripts) {
        return values[makeIndex(subscripts)];
    }

}
