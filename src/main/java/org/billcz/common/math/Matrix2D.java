package org.billcz.common.math;


import org.billcz.common.math.dense.imp.DefaultDenseDoubleMatrix2D;
import org.billcz.common.math.interfaces.Matrix2DOperation;
import org.billcz.common.math.interfaces.Matrix2DProperties;
import org.billcz.common.math.sparse.DefaultSparseDoubleMatrix2D;
import org.billcz.common.math.subscripts.Subscripts;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public abstract class Matrix2D extends Matrix implements Matrix2DProperties, Matrix2DOperation {
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
        if (subscripts.length != DIMENSION_2D) return null;

        return isNeedSparse(subscripts) ? DefaultSparseDoubleMatrix2D.zeros(subscripts[0], subscripts[1]) : DefaultDenseDoubleMatrix2D.zeros(subscripts[0], subscripts[1]);
    }

    public static Matrix2D random(int... subscripts) {
        if (subscripts.length != DIMENSION_2D) return null;

        return isNeedSparse(subscripts) ? DefaultSparseDoubleMatrix2D.random(subscripts[0], subscripts[1]) : DefaultDenseDoubleMatrix2D.random(subscripts[0], subscripts[1]);
    }

    public int makeIndex(int i, int j) {
        return i * cols + j;
    }

    public void set(double value, int... subscripts) {
        if (subscripts.length != DIMENSION_2D) return;
        set(value, subscripts[0], subscripts[1]);
    }

    public abstract void set(double value, int i , int j);

    public double get(int... subscripts) {
        if (subscripts.length != DIMENSION_2D) return Double.NaN;
        return get(subscripts[0], subscripts[1]);
    }

    public abstract double get(int i, int j);

    public int getRows() {
        return rows;
    }

    public int getDimensions() {
        return DIMENSION_2D;
    }

    public int getCols() {
        return cols;
    }

    public int[] getMatrixSizes() {
        int[] sizes = new int[DIMENSION_2D];
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


    public Iterable<int[]> allValues() {
        return new Subscripts.SubscriptIterable(getMatrixSizes());
    }

    public Matrix getOneRow(int row) {
        int n = getCols();
        Matrix matrix = Matrix.create(1, n);
        for (int i = 0; i < n; i++) {
            matrix.set(get(row, i), 0, i);
        }
        return matrix;
    }

    public Matrix getOneCol(int col) {
        int m = getRows();

        Matrix matrix = Matrix.create(m, 1);
        for (int i = 0; i < m; i++) {
            matrix.set(get(i, col), i, 0);
        }

        return matrix;
    }

    public Matrix getMatrix(int... subscripts) {
        if (subscripts[0] == DIMENSION_WILDCARD && subscripts[1] == DIMENSION_WILDCARD) return this;

        if (subscripts[0] == DIMENSION_WILDCARD) {
            return getOneCol(subscripts[1]);
        } else if (subscripts[1] == DIMENSION_WILDCARD) {
            return getOneRow(subscripts[0]);
        } else {
            double value = get(subscripts);
            Matrix matrix = Matrix.create(1, 1);
            matrix.set(value, 0, 0);
            return matrix;
        }
    }

    public Matrix add(Matrix other) {
        if (other.getDimensions() != DIMENSION_2D) return null;
        Matrix result = Matrix.create(other.getMatrixSizes());

        for (int[] subscripts : other.allValues()) {
            double sum = this.get(subscripts) + other.get(subscripts);
            result.set(sum, subscripts);
        }

        return result;
    }

    public Matrix subtract(Matrix other) {
        if (other.getDimensions() != DIMENSION_2D) return null;
        Matrix result = Matrix.create(other.getMatrixSizes());

        for (int[] subscripts : other.allValues()) {
            double diff = this.get(subscripts) - other.get(subscripts);
            result.set(diff, subscripts);
        }

        return result;
    }

    public Matrix multiply(Matrix other) {
        if (other.getDimensions() != DIMENSION_2D) return null;
        int m = getRows();
        int n = getCols();
        int p = ((Matrix2D) other).getCols();

        if (n != ((Matrix2D) other).getRows()) return null;

        Matrix result = Matrix.create(m, p);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    result.set(result.get(i, k) + get(i,j) * other.get(j, k), i, k);
                }
            }
        }

        return result;
    }

    public Matrix transpose() {
        int m = getRows();
        int n = getCols();

        Matrix result = Matrix.create(n, m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result.set(get(i, j), j, i);
            }
        }

        return result;
    }

    private static boolean isNeedSparse(int... subscripts) {
        return subscripts[0] > DIMENSION_SPARSE_LIMIT || subscripts[1] > DIMENSION_SPARSE_LIMIT;
    }
}
