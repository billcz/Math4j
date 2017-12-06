package org.billcz.common.math.subscripts;

import org.billcz.common.math.Matrix;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/4
 */
public class Subscript {
    private int[] subscripts;

    public Subscript(int len) {
        this.subscripts = new int[len];
    }

    public Subscript(int... subscripts) {
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

    public void setSubscript(int dim, int n) {
        subscripts[dim] = n;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < subscripts.length; i++) {
            int subscript = subscripts[i];
            if (subscript == Matrix.DIMENSION_WILDCARD) {
                sb.append(":");
            } else {
                sb.append(subscript);
            }
            if (i < subscripts.length) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static boolean lt(Subscript subscript1, Subscript subscript2) {
        int[] s1 = subscript1.subscripts;
        int[] s2 = subscript2.subscripts;

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] > s2[i]) return false;
        }

        return true;
    }

    public static Subscript subtract(Subscript subscript, int v) {
        Subscript result = new Subscript(subscript.getLength());
        for (int i = subscript.getLength() - 1; i != -1; i--) {
            result.setSubscript(i, subscript.getSubscript(i) - v);
        }
        return result;
    }

    public static boolean equal(Subscript subscript1, Subscript subscript2) {
        for (int i = 0; i < subscript1.getLength(); i++) {
            if (subscript1.getSubscript(i) != subscript2.getSubscript(i)) return false;
        }
        return true;
    }

    public static class SubscriptIterable implements Iterable<int[]> {
        Subscript sizes;
        Subscript cursor;
        Subscript last;
        public SubscriptIterable(int... sizes) {
            this.sizes = new Subscript(sizes);
            this.cursor = new Subscript(sizes.length);
            this.cursor.setSubscript(sizes.length - 1, -1);
            this.last = Subscript.subtract(this.sizes, 1);
        }

        public Iterator<int[]> iterator() {
            return new Iterator<int[]>() {
                public boolean hasNext() {
                    return !Subscript.equal(cursor, last);
                }

                public int[] next() {
                    int[] values = cursor.subscripts;
                    increment(values.length - 1, 1);
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
