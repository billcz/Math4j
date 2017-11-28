package org.billcz.common.math;

import org.billcz.common.exception.DimensionNotMatchException;
import org.billcz.common.math.dimension.Dimension;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/11/28
 */
public interface DataMatrix {
    Dimension getDimenSion();

    void put(double value, Integer... dim) throws DimensionNotMatchException;
    void put(double value, Dimension dimension) throws DimensionNotMatchException;

    DataMatrix get(Integer... dim) throws DimensionNotMatchException;
    DataMatrix get(Dimension dimension) throws DimensionNotMatchException;

    void add(DataMatrix other);
    void substract(DataMatrix other);
    void multiplyElementWise(DataMatrix other);
    void multiply(DataMatrix other);
}
