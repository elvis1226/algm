package org.dgf.string;

public class RepeatCharCompress {
    public String runLengthEncoding(String string) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        char pre = ' ';
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (i == 0) {
                pre = c;
                continue;
            }

            if (pre != c) {
                if (cnt > 0) {
                    sb.append(cnt + "" + pre);
                }
                cnt = 1;
                pre = c;
            }
            else {
                cnt++;
                if (cnt == 9) {
                    sb.append(cnt + "" + pre);
                    cnt = 0;
                }
            }

        }
        if (cnt > 0) {
            sb.append(cnt + "" + pre);
        }

        return sb.toString();
    }
}
