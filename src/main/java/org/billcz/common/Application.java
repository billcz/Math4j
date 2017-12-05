package org.billcz.common;

import org.billcz.common.math.Matrix;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public class Application {
    public static void main(String[] args) {
        Matrix m1 = Matrix.random(4, 3);
        System.out.println(m1.toString());
//        System.out.println(m1.get(0,1));
//
//        Matrix m2 = Matrix.random(4,4);
//        m2.set(3.0, 1, 1);
//        System.out.println(m2);
//        System.out.println(m2.multiply(m1));
//        System.out.println(Matrix.random(1, 20));

        System.out.println(m1.getMatrix(2, 2));
        System.out.println(m1.getMatrix(2, Matrix.DIMENSION_WILDCARD));
    }
}
