package org.billcz.common.math.util;

import java.util.Random;

/**
 * Description:
 * Author: billcz
 * Create time: 2017/12/5
 */
public class RandomUtil {
    private static final int DEFAULT_INT_MAX = 100;
    private static final double DEFAULT_DOUBLE_MAX = 100.0;

    public static double randomDouble(int max) {
        Random random = new Random();
        return random.nextDouble() * max;
    }

    public static double randomDouble() {
        Random random = new Random();
        return random.nextDouble() * DEFAULT_DOUBLE_MAX;
    }

    public static int randomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static int randomInt() {
        Random random = new Random();
        return random.nextInt(DEFAULT_INT_MAX);
    }
}
