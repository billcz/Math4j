package org.billcz.common.math.interfaces;

import org.billcz.common.math.Matrix;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public interface MatrixCalculation {
    public Matrix add(Matrix other);
    public Matrix subtract(Matrix other);
    public Matrix multiply(Matrix other);
}
