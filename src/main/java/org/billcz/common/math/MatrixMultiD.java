package org.billcz.common.math;


import org.billcz.common.math.dense.imp.DefaultDenseDoubleMatrixMultiD;
import org.billcz.common.math.subscripts.Subscripts;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public abstract class MatrixMultiD extends Matrix {
    public static MatrixMultiD create(int... subscripts) {
        return zeros(subscripts);
    }

    public static MatrixMultiD zeros(int... subscripts) {
        return DefaultDenseDoubleMatrixMultiD.zeros(subscripts);
    }

    public static MatrixMultiD random(int... subscripts) {
        return DefaultDenseDoubleMatrixMultiD.random(subscripts);
    }

    public int getDimensions() {
        return 0;
    }

    public int[] getMatrixSizes() {
        return new int[0];
    }

    public Matrix add(Matrix other) {
        return null;
    }

    public void set(double value, int... subscripts) {

    }

    public Iterable<int[]> allValues() {
        return null;
    }

    public Matrix substract(Matrix other) {
        return null;
    }

    public void set(double value, Subscripts subscripts) {

    }

    public Matrix multiply(Matrix other) {
        return null;
    }

    public double get(int... subscripts) {
        return 0;
    }

    public double get(Subscripts subscripts) {
        return 0;
    }
}

