package org.dgf.algm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2018/5/20.
 * 0 : 0
 * 1 : 0 1
 * 2
 * 00 : 0
 * 01 : 1
 * 11 : 3
 * 10 : 2
 * 3
 * 0 00, 0 01, 0 11, 0 10, 1 10, 1 11, 1 01, 1 00
 */
public class GrayCode {
    static Logger log = LoggerFactory.getLogger(GrayCode.class);

    public static List<Integer> GrayCode(int n) {
        if (n == 0)
        {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }


        List<Integer> gcN_1 = GrayCode(n-1);
        for (int i = gcN_1.size()-1; i >= 0; i--) {
            gcN_1.add( (1<<n-1) + gcN_1.get(i));
        }
        return gcN_1;
    }

    public static void main(String[] argv) {
        log.info("{},{}", Integer.toBinaryString((8 & (1<<20)) -1 ),Integer.toBinaryString((1<<20)).length());
        log.info("{}, {}", 2, GrayCode(2));
        log.info("{}, {}", 3, GrayCode(3));
        log.info("{}, {}", 3, GrayCode(4));
    }
}
