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
        m1.set(2.0, 1, 1);
        System.out.println(m1.toString());
        System.out.println(m1.get(0,1));

        Matrix m2 = Matrix.create(4,3);
        m2.set(3.0, 1, 1);
        System.out.println(m2.add(m1).toString());
    }
}
