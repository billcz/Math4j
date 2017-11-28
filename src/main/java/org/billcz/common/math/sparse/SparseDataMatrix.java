package org.billcz.common.math.sparse;

import org.billcz.common.exception.DimensionNotMatchException;
import org.billcz.common.math.DataMatrix;
import org.billcz.common.math.dimension.Dimension;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/11/28
 */
public class SparseDataMatrix implements DataMatrix {
    private Dimension dimension;
    private Map<Integer, Double> values;

    /**
     * the defualt constructor
     * 1 * 1, ths default value is 0.0d;
     */
    public SparseDataMatrix() {
        this(1);
    }

    public SparseDataMatrix(Integer... dims) {
        this.dimension = new Dimension(dims);
        this.values = new HashMap<Integer, Double>();
    }

    public SparseDataMatrix(Dimension dimension) {
        this.dimension = dimension;
        this.values = new HashMap<Integer, Double>();
    }

    public Dimension getDimenSion() {
        return dimension;
    }

    public DataMatrix get(Integer... dim) throws DimensionNotMatchException {
        return get(new Dimension(dim));
    }

    public DataMatrix get(Dimension dimension) throws DimensionNotMatchException {
        if (dimension.getSize() > dimension.getSize()) {
            throw new DimensionNotMatchException();
        }

        return null;
    }


    public void put(double value, Integer... dim) throws DimensionNotMatchException {
        put(value, new Dimension(dim));
    }

    public void put(double value, Dimension indexs) throws DimensionNotMatchException {
        if (indexs.getSize() > this.dimension.getSize()) {
            throw new DimensionNotMatchException();
        }

        if (this.values == null) {
            this.values = new HashMap<Integer, Double>();
        }

        int[] idxs = getIndex(indexs);
        for (int idx : idxs) {
            this.values.put(idx, value);
        }
    }

    public void add(DataMatrix other) {

    }

    public void substract(DataMatrix other) {

    }

    public void multiplyElementWise(DataMatrix other) {

    }

    public void multiply(DataMatrix other) {

    }

    private void put()
    private int[] getIndex(Dimension indexs) {

        return new int[0];
    }
}
