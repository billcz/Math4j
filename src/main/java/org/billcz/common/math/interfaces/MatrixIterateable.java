package org.billcz.common.math.interfaces;

import org.billcz.common.math.subscripts.Subscripts;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public interface MatrixIterateable {

    public Iterable<int[]> allValues();

    public Iterable<int[]> allNotZeroValues();

}
