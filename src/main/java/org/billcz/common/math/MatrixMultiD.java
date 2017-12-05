package org.billcz.common.math;


import org.billcz.common.math.dense.imp.DefaultDenseDoubleMatrixMultiD;
import org.billcz.common.math.interfaces.MatrixMultiDOperation;
import org.billcz.common.math.interfaces.MatrixMultiDProperties;
import org.billcz.common.math.sparse.DefaultSparseDoubleMatrixMultiD;
import org.billcz.common.math.subscripts.Subscripts;

import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public abstract class MatrixMultiD extends Matrix implements MatrixMultiDProperties, MatrixMultiDOperation {
    private int[] sizes;

    public MatrixMultiD(int[] sizes) {
        this.sizes = sizes;
    }

    public static MatrixMultiD create(int... subscripts) {
        return zeros(subscripts);
    }

    public static MatrixMultiD zeros(int... subscripts) {
        return isNeedSparse(subscripts) ? DefaultSparseDoubleMatrixMultiD.zeros(subscripts) : DefaultDenseDoubleMatrixMultiD.zeros(subscripts);
    }

    public static MatrixMultiD random(int... subscripts) {
        return isNeedSparse(subscripts) ? DefaultSparseDoubleMatrixMultiD.random(subscripts) : DefaultDenseDoubleMatrixMultiD.random(subscripts);
    }

    public int getDimensions() {
        return sizes.length;
    }

    public int[] getMatrixSizes() {
        return sizes;
    }

    public int getMatrixSize(int n) {
        return sizes[n];
    }

    public int makeIndex(int... subscripts) {
        return makeIndexByRow(subscripts);
    }

    public Iterable<int[]> allValues() {
        return new Subscripts.SubscriptIterable(getMatrixSizes());
    }

    public Matrix getMatrix(int... subscripts) {

        return null;
    }

    public Matrix add(Matrix other) {
        Matrix result = Matrix.create(other.getMatrixSizes());

        for (int[] subscripts : other.allValues()) {
            double sum = this.get(subscripts) + other.get(subscripts);
            result.set(sum, subscripts);
        }

        return result;
    }

    public Matrix subtract(Matrix other) {
        Matrix result = Matrix.create(other.getMatrixSizes());

        for (int[] subscripts : other.allValues()) {
            double diff = this.get(subscripts) - other.get(subscripts);
            result.set(diff, subscripts);
        }

        return result;
    }


    public Matrix multiply(Matrix other) {
        return null;
    }

    public Matrix transpose() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("\n");
        int[] sizes = getMatrixSizes();

        return sb.toString();
    }

    private static boolean isNeedSparse(int... subscripts) {
        for (int subscript : subscripts) {
            if (subscript > DIMENSION_SPARSE_LIMIT) return true;
        }

        return subscripts.length > DIMENSION_SPARSE_SIZE_LIMIT;
    }

    private int makeIndexByRow(int... subscripts) {
        int product = 1;
        int index = 0;
        for (int i = subscripts.length -1 ; i > 0; i--) {
            int subscript = subscripts[i];
            index += product * subscript;
            product *= sizes[i];
        }
        return index;
    }
}

