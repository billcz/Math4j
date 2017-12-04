package org.billcz.common.math.subscripts;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public class Subscripts {
    private int[] subscripts;

    public Subscripts(int[] subscripts) {
        this.subscripts = subscripts;
    }

    public int getDimension() {
        return subscripts.length;
    }

    public int getSubscript(int n) {
        return subscripts[n];
    }

    public int makeIndex(int[] sizes) {
        return 0;
    }
}
