package org.billcz.common.math.interfaces;

import org.billcz.common.math.Matrix;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public interface MatrixProperties {
    public int getDimensions();
    public int[] getMatrixSizes();
    public int getMatrixSize(int n);
    public boolean isSparse();
    public boolean isSameType(Matrix other);
}
