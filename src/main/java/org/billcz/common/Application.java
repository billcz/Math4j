package org.billcz.common;

import org.billcz.common.math.Matrix;
import org.billcz.common.math.dense.imp.DefaultDenseDoubleMatrix2D;
import org.billcz.common.math.sparse.DefaultSparseDoubleMatrix2D;

import java.util.List;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public class Application {
    public static void main(String[] args) {
//        Matrix m1 = Matrix.create(4, 4);
//        System.out.println(m1);
//        System.out.println(m1.get(0, 1));
//
//        Matrix m2 = Matrix.zeros(4, 4);
//        m2.set(3.0, 1, 1);
//        System.out.println(m2);
//
//        Matrix m3 = Matrix.random(3, 4);
//        System.out.println(m3);
//
//        Matrix m4 = Matrix.random(4, 4);
//        System.out.println(m4);
//
//        Matrix dense1 = new DefaultDenseDoubleMatrix2D(3000, 4000);
//        dense1.set(200, 125, 223);
//        System.out.println(dense1.get(125, 223));
//
//        Matrix sparse1 = new DefaultSparseDoubleMatrix2D(3000, 4000);
//        sparse1.set(200, 223, 222);
//        System.out.println(sparse1.get(223, 222));

        Matrix highMatrix = Matrix.create(3, 3, 3, 3);
//        highMatrix.set(200, 1, 2, 3, 4);
//        System.out.println(highMatrix.get(1, 2, 3, 4));
        List<Matrix> matrixList = highMatrix.getMatrix(Matrix.DIMENSION_WILDCARD, 2, Matrix.DIMENSION_WILDCARD, Matrix.DIMENSION_WILDCARD);

        for (Matrix matrix : matrixList) {
            System.out.println(matrix);
        }
//        System.out.println(m2.add(m4));
//        System.out.println(m1.subtract(m2));
//        System.out.println(m3.multiply(m4));
//
//        System.out.println(m1.getMatrix(2, 2));
//        System.out.println(m1.getMatrix(Matrix.DIMENSION_WILDCARD, 2));
//        System.out.println(m1.getMatrix(2, Matrix.DIMENSION_WILDCARD));

    }
}
