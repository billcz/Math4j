package org.billcz.common.math.interfaces;

import org.billcz.common.math.Matrix;

import java.util.List;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public interface MatrixOperation {
    public void set(double value, int... subscripts);
    public double get(int... subscripts);
    public List<Matrix> getMatrix(int... subscripts);

    public Matrix transpose();
}
