package org.billcz.common.math.interfaces;

import org.billcz.common.math.subscripts.Subscripts;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public interface MatrixOperation {
    public void set(double value, int... subscripts);
    public void set(double value, Subscripts subscripts);
    public double get(int... subscripts);
    public double get(Subscripts subscripts);
}
