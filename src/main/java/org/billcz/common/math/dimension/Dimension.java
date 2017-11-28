package org.billcz.common.math.dimension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/11/28
 */
public class Dimension {
    private List<SubScript> dimensions;

    public Dimension() {
    }

    public Dimension(List<SubScript> dimensions) {
        this.dimensions = dimensions;
    }

    public Dimension(Integer... dims) {
        SubScript[] subScripts = new SubScript[dims.length];
        for (int i = 0; i < dims.length; i++) {
            subScripts[i] = new SubScript(dims[i]);
        }

        init(subScripts);
    }

    public Dimension(SubScript... dims) {
        init(dims);
    }

    public int getSize() {
        return dimensions.size();
    }

    public List<SubScript> getDimensions() {
        return dimensions;
    }

    public int[] getDimensionsValues() {
        int[] dims = new int[dimensions.size()];

        for (int i = 0; i < dimensions.size(); i++) {
            dims[i] = dimensions.get(i).getI();
        }
        return dims;
    }

    @Override
    public String toString() {
        return Arrays.toString(getDimensionsValues());
    }

    private void init(SubScript[] dims) {
        if (dims.length == 1) {
            this.dimensions = new ArrayList<SubScript>();
            this.dimensions.add(new SubScript(1));
            this.dimensions.add(dims[0]);
            return;
        }

        this.dimensions = Arrays.asList(dims);
    }
}
