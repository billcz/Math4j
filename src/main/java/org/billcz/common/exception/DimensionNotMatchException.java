package org.billcz.common.exception;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/11/28
 */
public class DimensionNotMatchException extends Exception {
    public DimensionNotMatchException() {
        super("The dimension not match.");
    }

    public DimensionNotMatchException(String message) {
        super(message);
    }
}
