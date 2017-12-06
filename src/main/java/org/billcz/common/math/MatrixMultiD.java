package org.billcz.common.math;


import org.billcz.common.math.dense.imp.DefaultDenseDoubleMatrixMultiD;
import org.billcz.common.math.interfaces.MatrixMultiDOperation;
import org.billcz.common.math.interfaces.MatrixMultiDProperties;
import org.billcz.common.math.sparse.DefaultSparseDoubleMatrixMultiD;
import org.billcz.common.math.subscripts.Subscript;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public abstract class MatrixMultiD extends Matrix implements MatrixMultiDProperties, MatrixMultiDOperation {
    private int[] sizes;
    private Subscript subscript;

    public MatrixMultiD(int[] sizes) {
        this.sizes = sizes;
        this.subscript = new Subscript(sizes);
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
        return new Subscript.SubscriptIterable(getMatrixSizes());
    }

    public List<Matrix> getMatrix(int... subscripts) {
        int selectedRows = subscripts[ROW];
        int selectedCols = subscripts[COL];

        int matrixRows = getMatrixSize(ROW);
        int matrixCols = getMatrixSize(COL);

        int rows = selectedRows == DIMENSION_WILDCARD ? matrixRows : 1;
        int cols = selectedCols == DIMENSION_WILDCARD ? matrixCols : 1;

        List<Subscript> subscriptList = new ArrayList<Subscript>();
        subscriptList.add(new Subscript(subscripts));
        for (int i = 2; i < subscripts.length; i++) {
            int index = subscripts[i];
            int size = getMatrixSize(i);

            if (index == DIMENSION_WILDCARD) {
                List<Subscript> wildcardList = new ArrayList<Subscript>();

                for (int j = 0; j < size; j++) {
                    for (Subscript subscript : subscriptList) {
                        int[] newScripts = subscript.getSubscripts().clone();
                        newScripts[i] = j;
                        wildcardList.add(new Subscript(newScripts));
                    }
                }

                subscriptList = wildcardList;
            }
        }

        List<Matrix> matrices = new ArrayList<Matrix>();
        for (Subscript subscript : subscriptList) {
            int[] newSizes = subscripts.clone();
            newSizes[ROW] = rows;
            newSizes[COL] = cols;
            MatrixMultiD matrix = (MatrixMultiD) Matrix.create(newSizes);
            matrix.setSubscript(subscript);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    Subscript newSubscript = new Subscript(subscript.getSubscripts().clone());
                    newSubscript.setSubscript(ROW, i);
                    newSubscript.setSubscript(COL, j);
                    matrix.set(get(newSubscript.getSubscripts()), newSubscript.getSubscripts());
                    matrices.add(matrix);
                }
            }
        }

        return matrices;
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
        int[] newSubscripts = new int[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            newSubscripts[i] = Matrix.DIMENSION_WILDCARD;
        }
        List<Matrix> matrices = getMatrix(newSubscripts);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(subscript);
        sb.append("]\n");
        int[] sizes = getMatrixSizes();

        return sb.toString();
    }

    public Subscript getSubscript() {
        return subscript;
    }

    public void setSubscript(Subscript subscript) {
        this.subscript = subscript;
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
        for (int i = subscripts.length -1 ; i != -1; i--) {
            int subscript = subscripts[i];
            index += product * subscript;
            product *= sizes[i];
        }
        return index;
    }
}

