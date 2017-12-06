package org.billcz.common.math;


import org.billcz.common.math.interfaces.MatrixIterateable;
import org.billcz.common.math.interfaces.MatrixCalculation;
import org.billcz.common.math.interfaces.MatrixOperation;
import org.billcz.common.math.interfaces.MatrixProperties;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public abstract class Matrix implements MatrixProperties, MatrixOperation, MatrixCalculation, MatrixIterateable {

    public static Matrix create(int... subscripts) {
        if (subscripts.length > 2) {
            return MatrixMultiD.create(subscripts);
        }
        return Matrix2D.create(subscripts);
    }

    public static Matrix zeros(int... subscripts) {
        if (subscripts.length > 2) {
            return MatrixMultiD.zeros(subscripts);
        }
        return Matrix2D.zeros(subscripts);
    }

    public static Matrix random(int... subscripts) {
        if (subscripts.length > 2) {
            return MatrixMultiD.random(subscripts);
        }
        return Matrix2D.random(subscripts);
    }

}


/**
 Matrix m1 = Matrix.create(2,3); // default create matrix
 Matrix m2 = Matrix.zeros(2,3);
 Matrix m3 = Matrix.random(2,3);
 Matrix m4 = Matrix.create(2,3,3);
 m1.set(2.0, 2, 3);
 Matrix m3 = m1.add(m2);

 */
