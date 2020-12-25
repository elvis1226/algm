package org.dgf.algm;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by apple on 2018/5/19.
 */
public class Power {
    static Logger log = LoggerFactory.getLogger(Power.class);
    public static double power(double x, int n) {
        if (n == 0) return 1;
        //if (n == 1) return x;

        double y = power(x, n / 2);

        if (n % 2 == 0) {
            return y*y;
        }
        else {
            return y*y*x;
        }
    }

    public static void main(String[] argv) {
        log.info("{}", power(2, 0) == 1);
        log.info("{}", power(2, 1) == 2);
        log.info("{}", power(2, 2) == 4);
        log.info("{}", power(2, 3) == 8);
        log.info("{}", power(2, 4) == 16);
        log.info("{}", power(2, 5) == 32);
        log.info("{}", power(2, 6) == 64);

        log.info("{}", power(3, 1) == 3);
        log.info("{}", power(3, 2) == 9);
        log.info("{}", power(3, 3) == 27);
        log.info("{}", power(3, 4) == 81);
        log.info("{}", power(3, 5) == 243);
        log.info("{}", power(3, 6) == 729);
    }
}
