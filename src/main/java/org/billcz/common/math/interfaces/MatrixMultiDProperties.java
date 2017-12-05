package org.billcz.common.math.interfaces;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public interface MatrixMultiDProperties extends MatrixProperties {
    public int DIMENSION_SPARSE_SIZE_LIMIT = 5;
    public int DIMENSION_SPARSE_LIMIT = 10000;

    public int makeIndex(int... subscripts);
}
