package org.billcz.common.math.subscripts;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public class Subscripts {
    private int[] subscripts;

    public Subscripts(int len) {
        this.subscripts = new int[len];
    }

    public Subscripts(int... subscripts) {
        this.subscripts = subscripts;
    }

    public int getLength() {
        return subscripts.length;
    }

    public int[] getSubscripts() {
        return subscripts;
    }

    public int getSubscript(int n) {
        return subscripts[n];
    }

    @Override
    public String toString() {
        return Arrays.toString(subscripts);
    }

    public static boolean lt(Subscripts subscripts1, Subscripts subscripts2) {
        int[] s1 = subscripts1.subscripts;
        int[] s2 = subscripts2.subscripts;

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] > s2[i]) return false;
        }

        return true;
    }


    public static class SubscriptIterable implements Iterable<int[]> {
        Subscripts sizes;
        Subscripts cursor;

        public SubscriptIterable(int... sizes) {
            this.sizes = new Subscripts(sizes);
            this.cursor = new Subscripts(sizes.length);
        }

        public Iterator<int[]> iterator() {
            return new Iterator<int[]>() {
                public boolean hasNext() {
                    return Subscripts.lt(cursor, sizes);
                }

                public int[] next() {
                    int[] values = cursor.subscripts;
                    increment(values.length, 1);
                    return values;
                }

                public void remove() {

                }
            };
        }

        private void increment(int dim, int v) {
            int[] c = cursor.subscripts;
            c[dim] += v;
            if (c[dim] >= sizes.getSubscript(dim)) {
                c[dim] = 0;
                increment(dim - 1, v);
            }
        }
    }

}
