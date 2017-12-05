package org.billcz.common.math.interfaces;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public interface Matrix2DProperties extends MatrixProperties {
    public int DIMENSION_SPARSE_LIMIT = 10000;

    public int getRows();
    public int getCols();
    public int makeIndex(int i, int j);
}
