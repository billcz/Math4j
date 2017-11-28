package org.billcz.common.math.dimension;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/11/28
 */
public class SubScript {
    private int i;
    private static final int WILDCARD = -1;

    public SubScript() {
        this.i = 1;
    }

    public SubScript(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
