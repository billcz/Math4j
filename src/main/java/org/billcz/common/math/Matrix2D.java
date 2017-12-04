package org.billcz.common.math;


import org.billcz.common.math.dense.imp.DefaultDenseDoubleMatrix2D;
import org.billcz.common.math.interfaces.Matrix2DProperties;
import org.billcz.common.math.sparse.DefaultSparseDoubleMatrix2D;
import org.billcz.common.math.subscripts.Subscripts;

import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public abstract class Matrix2D extends Matrix implements Matrix2DProperties {
    private int rows;
    private int cols;

    public Matrix2D(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public static Matrix2D create(int... subscripts) {
        return zeros(subscripts);
    }

    public static Matrix2D zeros(int... subscripts) {
        if (subscripts.length > 2) return null;

        if (subscripts.length == 2) {
            return DefaultDenseDoubleMatrix2D.zeros(subscripts[0], subscripts[1]);
        } else {
            return DefaultDenseDoubleMatrix2D.zeros(subscripts[0], 1);
        }
    }

    public static Matrix2D random(int... subscripts) {
        if (subscripts.length > 2) return null;

        if (subscripts.length == 2) {
            return DefaultDenseDoubleMatrix2D.random(subscripts[0], subscripts[1]);
        } else {
            return DefaultDenseDoubleMatrix2D.random(subscripts[0], 1);
        }
    }

    public int makeIndex(int i, int j) {
        return i * cols + j;
    }

    public void set(double value, int... subscripts) {
        if (subscripts.length != 2) return;
        set(value, subscripts[0], subscripts[1]);
    }

    public void set(double value, Subscripts subscripts) {
        if (subscripts.getDimension() > 2) return;
        set(value, subscripts.getSubscript(0), subscripts.getSubscript(1));
    }


    public abstract void set(double value, int i , int j);

    public double get(int... subscripts) {
        if (subscripts.length != 2) return Double.NaN;
        return get(subscripts[0], subscripts[1]);
    }

    public double get(Subscripts subscripts) {
        if (subscripts.getDimension() > 2) return Double.NaN;
        return get(subscripts.getSubscript(0), subscripts.getSubscript(1));
    }

    public abstract double get(int i, int j);

    public int getRows() {
        return rows;
    }

    public int getDimensions() {
        return 2;
    }

    public int getCols() {
        return cols;
    }

    public int[] getMatrixSizes() {
        int[] sizes = new int[2];
        sizes[0] = rows;
        sizes[1] = cols;
        return sizes;
    }

    public int getMatrixSize(int n) {
        return getMatrixSizes()[n];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("\n");
        for (int i = 0; i < getRows(); i++) {
            sb.append("\t");
            for (int j = 0; j < getCols(); j++) {
                sb.append(get(i, j));
                if (j != getCols() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    public Matrix add(Matrix other) {
        if (other.getDimensions() != 2) return null;
        Matrix result = new DefaultDenseDoubleMatrix2D(rows, cols);

        if (isSparse() || other.isSparse()) {
            result = new DefaultSparseDoubleMatrix2D(rows, cols);
        }

        Iterator<int[]> it = other.allValues();
        while (it.hasNext()) {
            int[] subscripts = it.next();
            double sum = this.get(subscripts) + other.get(subscripts);
            result.set(sum, subscripts);
        }

        return result;
    }

    public Matrix substract(Matrix other) {
        return null;
    }

    public Matrix multiply(Matrix other) {
        return null;
    }
}
