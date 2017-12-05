package org.billcz.common.math.interfaces;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public interface MatrixProperties {
    public int DIMENSION_2D = 2;
    public int DIMENSION_WILDCARD = -0xFFFF;

    public int getDimensions();
    public int[] getMatrixSizes();
    public int getMatrixSize(int n);
    public boolean isSparse();
}
